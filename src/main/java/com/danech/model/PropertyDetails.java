package com.danech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "propertyDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String name;
	private String propertyType;
	private Long sq_yd;
	private Long price;
	private String possession;
	private String area;
	@Column(columnDefinition="TEXT")
	private String highlights;
	private String website;
	private String brochureLink;
	private String youtubeVideo;
	private String suggestedArea;
	public String getSuggestedArea() {
		return suggestedArea;
	}
	public void setSuggestedArea(String suggestedArea) {
		this.suggestedArea = suggestedArea;
	}
	public String getBrochureLink() {
		return brochureLink;
	}
	public void setBrochureLink(String brochureLink) {
		this.brochureLink = brochureLink;
	}
	private String projectImage;
	public String getProjectImage() {
		return projectImage;
	}
	public void setProjectImage(String projectImage) {
		this.projectImage = projectImage;
	}
	private String priceRemark;
	private String city;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPriceRemark() {
		return priceRemark;
	}
	public void setPriceRemark(String priceRemark) {
		this.priceRemark = priceRemark;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public Long getSq_yd() {
		return sq_yd;
	}
	public void setSq_yd(Long sq_yd) {
		this.sq_yd = sq_yd;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}

	public String getPossession() {
		return possession;
	}
	public void setPossession(String possession) {
		this.possession = possession;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHighlights() {
		return highlights;
	}
	public void setHighlights(String highlights) {
		this.highlights = highlights;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getYoutubeVideo() {
		return youtubeVideo;
	}
	public void setYoutubeVideo(String youtubeVideo) {
		this.youtubeVideo = youtubeVideo;
	}
	
}

