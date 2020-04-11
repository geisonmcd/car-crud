package entities;

public class Car {

	private String chassi;
	private String brand;
	private String model;
	private int year;
	private double price;

	public Car(String chassi, String brand, String model, int year, double price) {
		this.chassi = chassi;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	public Car(String chassi, int year) {
		this.chassi = chassi;
		this.year = year;
	}
	
	public String getChassi() {
		return chassi;
	}



	public void setChassi(String chassi) {
		this.chassi = chassi;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
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



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getYearAsString() {
		return Integer.toString(this.getYear());
	}

	@Override
	public String toString() {
		return chassi  + "," + model + "," + brand + "," + year
				+ "," + price;
	}

}