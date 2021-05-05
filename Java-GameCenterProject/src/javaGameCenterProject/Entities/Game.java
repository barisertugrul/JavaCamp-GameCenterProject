package javaGameCenterProject.Entities;

import java.time.LocalDate;

import javaGameCenterProject.Abstract.Entity;

public class Game implements Entity {
	
	private int id;
	private int  categoryId;
	private String name;
	private String version;
	private LocalDate releaseDate;
	private double unitPrice;
	private int unitsInStock;

	public Game(int categoryId, String name, String version, LocalDate releaseDate, double unitPrice,
			int unitsInStock) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.version = version;
		this.releaseDate = releaseDate;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
}
