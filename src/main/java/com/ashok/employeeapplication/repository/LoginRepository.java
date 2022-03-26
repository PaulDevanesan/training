package com.ashok.employeeapplication.repository;

import com.ashok.employeeapplication.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UserInfo, String> {
}
