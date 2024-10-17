package com.hotel.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        System.out.println("100");
        var authorities = authentication.getAuthorities();
        System.out.println("200");
        var roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .findFirst();
        System.out.println("1");
        if (roles.orElse("").equals("ADMIN")) {
            response.sendRedirect("/admin/home");
        }
    }
}
