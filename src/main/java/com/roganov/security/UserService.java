package com.roganov.security;

import com.roganov.entity.UserEntity;
import com.roganov.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserEntity> userOpt = userRepository.findByLogin(s);
        if(userOpt.isEmpty()) {
            throw new UsernameNotFoundException("Пользователь с таким логином не найден");
        }

        UserEntity userEntity = userOpt.get();

        return new User(userEntity.getLogin(), userEntity.getPassword(), positionToAuthorities(userEntity));
    }

    private Collection<? extends GrantedAuthority> positionToAuthorities(UserEntity userEntity) {
        return List.of(new SimpleGrantedAuthority(userEntity.getRole().getAuthority()));
    }
}
