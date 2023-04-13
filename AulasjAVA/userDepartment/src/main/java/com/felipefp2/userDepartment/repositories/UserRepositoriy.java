package com.felipefp2.userDepartment.repositories;

import com.felipefp2.userDepartment.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoriy extends JpaRepository<User, Long> {

}
