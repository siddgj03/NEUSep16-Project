package ui.vehicleView;

import java.util.List;

import javax.swing.ImageIcon;

public class Vehicle {
	private String title;
	private String imagePath;
	private double msrp;
	private int sale;
	private int save;
	private String category;
	private String make;
	private float mileAge;
	private String model;
	private int year;
	private String bodyType;
	private String color;
	private String trim;
	private Rating rating;
	private String expires;
	private List<ImageIcon> imageList;

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public List<ImageIcon> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImageIcon> imageList) {
		this.imageList = imageList;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public float getMileAge() {
		return mileAge;
	}

	public void setMileAge(float mileAge) {
		this.mileAge = mileAge;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getMsrp() {
		return msrp;
	}

	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getSave() {
		return save;
	}

	public void setSave(int save) {
		this.save = save;
	}

	public String getExpires() {
		return expires;
	}

	public void setExpires(String expires) {
		this.expires = expires;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
