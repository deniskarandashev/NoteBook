package com.example.NoteBook.repos;

import com.example.NoteBook.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Denis Karandashev
 * @project NoteBook
 * @date 23.05.2020
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
