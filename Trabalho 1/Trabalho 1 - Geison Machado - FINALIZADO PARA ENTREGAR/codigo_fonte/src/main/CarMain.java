package main;

import controller.CarController;
import service.CarService;

public class CarMain {

	public static void main(String[] args) {
		CarController carController = new CarController();
		carController.execute();
	}

}
