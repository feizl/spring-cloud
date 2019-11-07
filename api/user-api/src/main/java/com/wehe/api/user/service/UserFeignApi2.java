
package com.wehe.api.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "user-service")
public interface UserFeignApi2 {

    @GetMapping(value = "/api/xxx")
    void getNone( ) ;

}

