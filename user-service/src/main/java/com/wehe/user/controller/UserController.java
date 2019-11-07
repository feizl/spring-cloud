package com.wehe.user.controller;

import com.wehe.api.user.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class UserController {

    private AtomicInteger atomicInteger = new AtomicInteger();

    private Map<Long,UserVo> map = new ConcurrentHashMap<>();

    private volatile long sleepTime = 10;

    /**
     * 更新sleeptime,为了测试ribbon超时
     *
     * @param sleepTime
     * @return
     */
    @PutMapping(value = "/api/sleepTime")
    Long updateSleepTime( @RequestParam Long sleepTime){
        this.sleepTime = sleepTime;
        return this.sleepTime;
    }

    @GetMapping(value = "/api/user/{userId}")
    public UserVo getUser(@PathVariable("userId") Long userId)  {

        System.out.println("get user...."+sleepTime);

        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.get(userId);
    }

    /**
     * 直接返回异常，测试feign异常信息
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/api/user2/{userId}")
    public UserVo getUser2(@PathVariable("userId") Long userId)  {

        System.out.println("get user2....");

        throw new RuntimeException("test");
//        return map.get(userId);
    }

    /**
     * 添加用户信息
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "/api/user")
    public Integer addUser( @RequestBody UserVo userVo) {
        map.put(userVo.getUserId(),userVo);
        return 0;
    }

}
