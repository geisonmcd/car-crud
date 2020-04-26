package service;

import java.util.List;

import entities.Car;

public class CarService {
	
	FileManager fileManager;
	
	public CarService() {
		fileManager = new FileManager();
	}
	
	public void save(Car car) throws Exception {
		fileManager.saveCar(car);
	}
	
	public void update(Car car) {
		fileManager.updateCar(car);
	}
	
	public void delete(Car car) {
		fileManager.deleteCar(car);
	}
	
	public List<Car> find(String text) {
		return fileManager.findCarsByChassiOrModel(text);
	}

	public List<Car> list(boolean showDeleted) {
		return fileManager.list(showDeleted);
	}
	
}
