package dao;

import java.util.List;

import entity.Car;

public interface CarDAO {
	
	public boolean createTableIfNotExists();

	public boolean saveCar(Car car);

	public boolean updateCar(Car car);

	public boolean deleteCar(Car car);

	public List<Car> findByChassiOrModel(String text);

	public List<Car> list();

	public int getRegisterCount();

	public boolean clearFile();

}