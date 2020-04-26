package entity;

public class Car {

	private String chassi;
	private String brand;
	private String model;
	private Integer year;
	private Double price;
	private Integer deleted;
	
	public Car() {}

	public Car(String chassi) {
		this.chassi = chassi;
//		this.brand = "";
//		this.model = "";
	}
	
	public Car(String chassi, String brand, String model, int year, double price) {
		this.chassi = chassi;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
		this.deleted = 0;
	}
	
	public Car(String chassi, String brand, String model, int year, double price, int deleted) {
		this.chassi = chassi;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
		this.deleted = deleted;
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



	public Integer getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getYearAsString() {
		return Integer.toString(this.getYear());
	}
	
	public String getPriceAsString() {
		return Double.toString(this.getPrice());
	}
	
	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getDeletedAsString() {
		return this.deleted == 1 ? "Sim" : "Não";
	}


	@Override
	public String toString() {
		return chassi  + "," + brand + "," + model+ "," + year
				+ "," + price;
	}

}