package com.Fintrack.Fintrack.repository;

import com.Fintrack.Fintrack.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
