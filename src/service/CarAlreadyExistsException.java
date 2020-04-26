package service;

@SuppressWarnings("serial")
public class CarAlreadyExistsException extends Exception {
	
	public CarAlreadyExistsException() {
		super("Um carro com esse chassi já existe");
	}

}
