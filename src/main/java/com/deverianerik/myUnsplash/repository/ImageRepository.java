package com.deverianerik.myUnsplash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deverianerik.myUnsplash.dto.ImageDto;

public interface ImageRepository extends JpaRepository<ImageDto, Long>{

}
