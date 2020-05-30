package entity;

public class Car {

	private String chassi;
	private String brand;
	private String model;
	private Integer year;
	private Double price;
	
	public Car() {}

	public Car(String chassi) {
		this.chassi = chassi;
	}
	
	public Car(String chassi, String brand, String model, Integer year, Double price) {
		this.chassi = chassi;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	public Car(String chassi, String brand, String model, Integer year, Double price, Integer deleted) {
		this.chassi = chassi;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
	}
	
	public Car(String chassi, Integer year) {
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

	public Integer getYear() {
		return year;
	}

	public Double getPrice() {
		return price;
	}

	public String getYearAsString() {
		return Integer.toString(this.getYear());
	}
	
	public String getPriceAsString() {
		return Double.toString(this.getPrice());
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return chassi  + "," + brand + "," + model+ "," + year
				+ "," + price;
	}

}