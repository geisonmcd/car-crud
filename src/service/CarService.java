package service;

import java.util.List;

import dao.CarDAO;
import entity.Car;
import factory.DAOFactory;
import factory.Factory;

/**
 * Classe que integra a conversa do front end com o backend
 *
 */
public class CarService {
	
	DAOFactory factory;
	CarDAO cardao;
	
	public CarService() {
		factory = DAOFactory.getDAOFactory(Factory.FABRICA);
		cardao = factory.getCarDAO();
	}
	
	public void createTableIfNotExists() {
		cardao.createTableIfNotExists();
	}
	
	public void save(Car car) throws Exception {
		cardao.saveCar(car);
	}
	
	public void update(Car car) {
		cardao.updateCar(car);
	}
	
	public void delete(Car car) {
		cardao.deleteCar(car);
	}
	
	public List<Car> findByChassiOrModel(String text) {
		return cardao.findByChassiOrModel(text);
	}

	public List<Car> list(boolean showDeleted) {
		return cardao.list();
	}

	public int getRegisterCount() {
		return cardao.getRegisterCount();
	}

	public void clearFile() {
		cardao.clearFile();
	}
	
}
