package com.deverianerik.myUnsplash.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deverianerik.myUnsplash.dto.ImageDto;
import com.deverianerik.myUnsplash.dto.StatusDto;
import com.deverianerik.myUnsplash.dto.UserDto;
import com.deverianerik.myUnsplash.repository.ImageRepository;
import com.deverianerik.myUnsplash.repository.UserRepository;

@RestController
@RequestMapping("/image")
public class ImageController {

	private static Long USER_ID = (long) 1;

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> getListImage() {
		try {	
			return ResponseEntity.ok(imageRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
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

	@DeleteMapping("/{idImage}")
	@Transactional
	public ResponseEntity<?> removeImage(@PathVariable Long idImage, @RequestBody String password) {
		try {
			Optional<UserDto> userDto = userRepository.findById(USER_ID);
			StatusDto statusDto = new StatusDto();
			if (userDto.isPresent()) {
				if (userDto.get().getPassword().equals(password)) {
					imageRepository.deleteById(idImage);
					statusDto.setStatus(Boolean.TRUE);
					statusDto.setMessage("Imagem removida com sucesso");
				} else {
					statusDto.setStatus(Boolean.FALSE);
					statusDto.setMessage("Senha inválida");
				}
			}
			return ResponseEntity.ok(statusDto);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}

	}
}
