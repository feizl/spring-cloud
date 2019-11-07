package com.wehe.order.controller;

import com.wehe.api.user.service.UserFeignApi;
import com.wehe.api.user.service.UserFeignApi2;
import com.wehe.api.user.vo.UserVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController  {

    @Resource
    private UserFeignApi userFeignApi;

    @Resource
    private UserFeignApi2 userFeignApi2;

    /**
     * 测试feign 调用
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/api/user/{userId}")
    public ResponseEntity<UserVo> getUser(@PathVariable("userId") Long userId){

        UserVo userVo = userFeignApi.getUser(userId);
        if( userVo != null && userVo.getName().equals("fallback")){
            return new ResponseEntity<>(userVo,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userVo,HttpStatus.OK);
    }

    /**
     * 测试服务提供方500错误，fallback
     *
     * @param userId
     * @return
     */
    @GetMapping(value = "/api/user2/{userId}")
    public ResponseEntity<UserVo> getUser2(@PathVariable("userId") Long userId){

        UserVo userVo = userFeignApi.getUser2(userId);
        if( userVo != null && userVo.getName().equals("fallback2")){
            return new ResponseEntity<>(userVo,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(userVo,HttpStatus.OK);
    }

    /**
     * 测试 404 feign 异常
     * @return
     */
    @GetMapping(value = "/api/xxx")
    public String getNone(){

        userFeignApi2.getNone();

        return "ok";
    }
}
