package com.deverianerik.myUnsplash.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "image")
public class ImageDto implements Serializable {
	private static final long serialVersionUID = 8110032858877488437L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String linkImage;
	private String labelImage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLinkImage() {
		return linkImage;
	}

	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}

	public String getLabelImage() {
		return labelImage;
	}

	public void setLabelImage(String labelImage) {
		this.labelImage = labelImage;
	}
}
