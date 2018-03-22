package ca.boss.matching.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reference")
public class Reference {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = null;

	Integer universeId = null, catalogId = null, profileId = null;
	private String brand = null, model = null, title = null, url = null, image = null;
	private String ean = null, color = null, size = null, capacity = null, memory = null, description = null,
			image1 = null, image2 = null, image3 = null, image4 = null;
	private Float price = null;

	public String getColor() {
		return color;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUniverseId(Integer universeId) {
		this.universeId = universeId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public int getUniverseId() {
		return universeId;
	}

	public void setUniverseId(int universeId) {
		this.universeId = universeId;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getTitle() {
		return title;
	}

	public String getEan() {
		return ean;
	}

	public String getUrl() {
		return url;
	}

	public Float getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public String getImage1() {
		return image1;
	}

	public String getImage2() {
		return image2;
	}

	public String getImage3() {
		return image3;
	}

	public String getImage4() {
		return image4;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public void setImage4(String image4) {
		this.image4 = image4;
	}

}
