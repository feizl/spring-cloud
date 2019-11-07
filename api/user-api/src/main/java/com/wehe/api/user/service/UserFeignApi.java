
package com.wehe.api.user.service;

import com.wehe.api.user.service.fallback.UserClientFallback;
import com.wehe.api.user.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(value = "user-service",fallback = UserClientFallback.class)
public interface UserFeignApi {

	@GetMapping(value = "/api/user/{userId}")
	UserVo getUser(@PathVariable("userId") Long userId) ;

    @GetMapping(value = "/api/user2/{userId}")
    UserVo getUser2(@PathVariable("userId") Long userId) ;

    @PostMapping(value = "/api/user")
    Integer addUser(@RequestBody UserVo userVo) ;

}

