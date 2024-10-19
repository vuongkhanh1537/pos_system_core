package com.longhuei.pos_system_core.modules.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.modules.auth.dto.LoginRequest;
import com.longhuei.pos_system_core.utils.EntryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(EntryService.PREFIX_AUTH)
@AllArgsConstructor
@CrossOrigin("*")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public BaseResponse<?> login(@RequestBody LoginRequest request) {
        return this.authService.login(request);
    }
}
