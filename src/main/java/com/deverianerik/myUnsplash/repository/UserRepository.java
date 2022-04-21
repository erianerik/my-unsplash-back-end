package com.deverianerik.myUnsplash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deverianerik.myUnsplash.dto.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Long> {

}
