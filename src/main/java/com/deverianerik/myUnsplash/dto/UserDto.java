package com.deverianerik.myUnsplash.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserDto implements Serializable {
	private static final long serialVersionUID = 4394893286498788211L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ImageDto> listImages;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ImageDto> getListImages() {
		return listImages;
	}

	public void setListImages(List<ImageDto> listImages) {
		this.listImages = listImages;
	}
}
