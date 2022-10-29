package com.magazine.project.repositories;

import com.magazine.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByUserName(@NotBlank(message = "The 'name' cannot be empty") @Size(min = 3) String userName);
    Optional<User> getUserByEmail(@Email String email);
}
