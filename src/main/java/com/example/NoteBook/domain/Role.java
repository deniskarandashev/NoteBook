package com.example.NoteBook.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author Denis Karandashev
 * @project NoteBook
 * @date 22.05.2020
 */
public enum Role implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
