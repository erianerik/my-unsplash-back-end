package com.deverianerik.myUnsplash.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deverianerik.myUnsplash.dto.ImageDto;
import com.deverianerik.myUnsplash.repository.ImageRepository;

@RestController
@RequestMapping("/image")
public class ImageController {

	@Autowired
	private ImageRepository imageRepository;

	@GetMapping
	public List<ImageDto> getListImage() {
		return imageRepository.findAll();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<?> addImage(@RequestBody ImageDto image) {
		try {
			imageRepository.save(image);
			return ResponseEntity.ok(image);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@DeleteMapping
	@Transactional
	public boolean removeImage(@RequestBody Long idImage) {
		try {
			imageRepository.deleteById(idImage);
			return Boolean.TRUE;
		} catch(Exception e) {
			return Boolean.FALSE;
		}
		
	}
}
