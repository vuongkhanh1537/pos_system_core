package com.longhuei.pos_system_core.modules.auth;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.auth.dto.LoginRequest;

public interface AuthService {
    BaseResponse<?> login(LoginRequest request);
}
