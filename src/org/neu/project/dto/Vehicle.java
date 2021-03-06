package org.neu.project.dto;

import java.util.List;
import java.util.UUID;
import java.util.TreeSet;

import javax.swing.ImageIcon;

public class Vehicle {

	private String id;
	private String webId;
	private String category;
	private int year;
	private String make;
	private String model;
	private String trim;
	private String type;
	private double price;
	private String title;

	private String imagePath;
	private List<ImageIcon> imageList;
	private Rating rating;
	private String color;
	private String bodyType;
	
	//group 6
	private TreeSet<CarSpecificSpecialList> splTree;
	private TreeSet<CarSpecificSpecialList> splTreeByExpiry;

	public TreeSet<CarSpecificSpecialList> getSplTreeByExpiry() {
		return splTreeByExpiry;
	}

	public void setSplTreeByExpiry(TreeSet<CarSpecificSpecialList> splTreeByExpiry) {
		this.splTreeByExpiry = splTreeByExpiry;
	}

	public TreeSet<CarSpecificSpecialList> getSplTree() {
		return splTree;
	}

	public void setSplTree(TreeSet<CarSpecificSpecialList> splTree) {
		this.splTree = splTree;
	}
	//
	
	
	public enum VehicleInfo {
		Id, WebId, Category, Year, Make, Model, Trim, Type, Price;
	}

	public Vehicle() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Vehicle(String dealerId) {
		this();
		this.webId = dealerId;
	}

	public Vehicle(String id, String webId, String category, String year, String make, String model, String trim,
			String type, String price) {
		super();
		this.id = id;
		this.webId = webId;
		this.category = category;
		this.year = Integer.parseInt(year);
		this.make = make;
		this.model = model;
		this.trim = trim;
		this.type = type;
		this.price = Double.parseDouble(price);
	}

	public String[] getVehicleInfo() {
		return new String[] { id, webId, category, year + "", make, model, trim, type, price + "" };
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWebId() {
		return webId;
	}

	public void setWebId(String webId) {
		this.webId = webId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = Integer.parseInt(year);
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = Double.parseDouble(price);
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<ImageIcon> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImageIcon> imageList) {
		this.imageList = imageList;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String toString() {
		return id + "~" + webId + "~" + category + "~" + year + "~" + make + "~" + model + "~" + trim + "~" + type + "~"
				+ price;
	}

}
