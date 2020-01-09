package com.example.demo.config.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * description
 *
 * @author : jkkim
 */
@Getter
@Setter
public class CustomUserDetails extends User {

    private String name;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String name) {
        super(username, password, authorities);
        this.name = name;
    }

}
