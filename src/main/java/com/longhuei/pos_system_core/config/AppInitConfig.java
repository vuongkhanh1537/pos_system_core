package com.longhuei.pos_system_core.config;

import com.longhuei.pos_system_core.modules.auth.AuthRepository;
import com.longhuei.pos_system_core.modules.auth.User;
import com.longhuei.pos_system_core.utils.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AppInitConfig {
    private final PasswordEncoder passwordEncoder;
    
    @Bean
    ApplicationRunner applicationRunner(
        AuthRepository authRepository
    ) {
        return args -> {
            if (authRepository.findByUsername("admin").isEmpty()) {

                User user = User.builder()
                    .name("Admin")
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .role(UserRole.ADMIN)
                    .build();
                authRepository.save(user); 
            }
        };
    }
}
