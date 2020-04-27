package service;

import java.util.List;

import entity.Car;
import persistence.FileManager;

/**
 * Classe que integra a conversa do front end com o backend
 *
 */
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
	
	public List<Car> findByChassiOrModel(String text) {
		return fileManager.findCarsByChassiOrModel(text);
	}

	public List<Car> list(boolean showDeleted) {
		return fileManager.list(showDeleted);
	}

	/**
	 * Retorna as propriedades do arquivo em um array de tamanho 2 sendo:
	 * [0] = tamanho do arquivo;
	 * [1] = número de registros;
	 * @return
	 */
	public long[] getProperties() {
		return fileManager.getProperties();
	}

	/**
	 * Exclui/limpa o arquivo
	 */
	public void clearFile() {
		fileManager.deleteFile();
	}
	
}
