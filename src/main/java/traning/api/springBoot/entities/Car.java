package traning.api.springBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {
	
	enum Color{
		RED,
		BLUE,
		GREEN,
		YELLOW
	}
	
	@Id
	private Long id;
	private String model;
	private String brand;
	private int year;
	private Color color;
	
	
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

}
