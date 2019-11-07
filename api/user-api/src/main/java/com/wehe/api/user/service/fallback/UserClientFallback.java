package com.wehe.api.user.service.fallback;

import com.wehe.api.user.service.UserFeignApi;
import com.wehe.api.user.vo.UserVo;

public class UserClientFallback implements UserFeignApi {

    @Override
    public UserVo getUser(Long userId) {
        UserVo userVo = new UserVo();
        userVo.setName("fallback");
        userVo.setUserId(userId);
        return userVo;
    }

    @Override
    public Integer addUser(UserVo userVo) {
        return -1;
    }

    @Override
    public UserVo getUser2(Long userId) {
        UserVo userVo = new UserVo();
        userVo.setName("fallback2");
        userVo.setUserId(userId);
        return userVo;
    }
}
