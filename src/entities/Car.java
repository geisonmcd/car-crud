package entities;

public class Car {
	
	public String brand;
	public String model;
	public String chassi;
	public int year;
	public double price;
	
	public Car(String chassi,String brand, String model, int year, double price) {
		this.chassi = chassi;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", model=" + model + ", " + "chassi=" + chassi + ", year=" + year + ", price="
				+ price + "]";
	}
	
}