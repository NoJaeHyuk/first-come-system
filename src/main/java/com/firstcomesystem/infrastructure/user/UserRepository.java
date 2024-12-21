package com.firstcomesystem.infrastructure.user;

import com.firstcomesystem.domain.users.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

}
