package com.roganov.security;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            Set<GrantedAuthority> newAuthorities =
                    ((JSONArray) (
                            (JSONObject) (
                                    (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
                            ).getClaims().get("realm_access")
                    ).get("roles")).stream()
                            .map(r -> new SimpleGrantedAuthority("" + r))
                            .collect(Collectors.toSet());
            SecurityContextHolder.getContext().setAuthentication(
                    new JwtAuthenticationToken(
                            (Jwt) (SecurityContextHolder.getContext().getAuthentication()).getPrincipal(),
                            newAuthorities,
                            SecurityContextHolder.getContext().getAuthentication().getName()
                    )
            );
        }
        filterChain.doFilter(request, response);
    }
}
