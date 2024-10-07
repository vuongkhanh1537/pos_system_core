package com.longhuei.pos_system_core.modules.auth;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.longhuei.pos_system_core.dto.BaseResponse;
import com.longhuei.pos_system_core.exception.ApplicationException;
import com.longhuei.pos_system_core.exception.ErrorCode;
import com.longhuei.pos_system_core.modules.auth.dto.AuthResponse;
import com.longhuei.pos_system_core.modules.auth.dto.LoginRequest;
import com.longhuei.pos_system_core.utils.Const;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;

import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    @Override
    public BaseResponse<?> login(LoginRequest request) {
        BaseResponse<AuthResponse> response = new BaseResponse<>();
        User user = this.authRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new ApplicationException(ErrorCode.USER_NOT_EXISTED));
        
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new ApplicationException(ErrorCode.UNAUTHENTICATED);
        }

        String token = generateToken(user);
        response.setWsResponse(new AuthResponse(token));
        return response;
    }

    private String generateToken(User user) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(user.getUsername())
                .issueTime(new Date())
                .expirationTime(new Date(Instant.now().plus(Const.EXPIRATION_TIME_AFTER, ChronoUnit.HOURS).toEpochMilli()))
                .jwtID(UUID.randomUUID().toString())
                .claim("scope", user.getRole())
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jWSObject = new JWSObject(header, payload);

        try {
            jWSObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jWSObject.serialize();
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }
    }
} 
