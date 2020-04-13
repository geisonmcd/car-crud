package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import entities.Car;

public class FileManager {

	RandomAccessFile raf;
	static final int CHASSI_FIELD_SIZE = 24;
	static final int BRAND_FIELD_SIZE = 24;
	static final int MODEL_FIELD_SIZE = 24;
	static final int YEAR_FIELD_SIZE = 4;
	static final int PRICE_FIELD_SIZE = 8;
	static final int REGISTER_SIZE = CHASSI_FIELD_SIZE + BRAND_FIELD_SIZE + MODEL_FIELD_SIZE + YEAR_FIELD_SIZE
			+ PRICE_FIELD_SIZE;

	public void saveCar(Car car) {
		openFile();
		add(car);
		closeFile();
	}

	public void updateCar(Car car) {
		openFile();
		update(car);
		closeFile();
	}

	private void update(Car car) {
		try {
			raf.seek(0);
			int registerIndex = 1;
			while (raf.getFilePointer() < raf.length()) {
				String chassi = this.readString(12);
				if (car.getChassi().equals(chassi)) {
					if (car.getBrand() != null) {
						
					}
					break;
				} else {
					raf.seek(REGISTER_SIZE * registerIndex);
				}
				registerIndex++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Car> findCarsByChassiOrModel(String text) {
		if (text.isEmpty())	return new ArrayList<Car>();
		openFile();
		List<Car> cars = new ArrayList<Car>();
		try {
			raf.seek(0);
			while (raf.getFilePointer() < raf.length()) {
				String chassi = this.readString(12);
				String brand = this.readString(12);
				String model = this.readString(12);
				int year = raf.readInt();
				double price = raf.readDouble();
				if (chassi.contains(text) || model.contains(text)) {
					cars.add(new Car(chassi, brand, model, year, price));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		closeFile();
		return cars;
	}

	private void add(Car car) {
		try {
			this.raf.seek(this.raf.length());
			this.writeString(car.getChassi(), 12);
			this.writeString(car.getBrand(), 12);
			this.writeString(car.getModel(), 12);
			this.raf.writeInt(car.getYear());
			this.raf.writeDouble(car.getPrice());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeString(String word, int size) throws IOException {
		StringBuffer buf = null;
		if (word != null)
			buf = new StringBuffer(word);
		else
			buf = new StringBuffer(size);
		buf.setLength(size);
		this.raf.writeChars(buf.toString());
	}

	private String readString(int size) throws IOException {
		char text[] = new char[size];
		char temp;
		for (int i = 0; i < text.length; i++) {
			temp = this.raf.readChar();
			text[i] = temp;
		}
		return new String(text).replace('\0', ' ');
	}

	public void openFile() {
		try {
			File fileName = new File("file.dat");
			this.raf = new RandomAccessFile(fileName, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			this.raf = null;
		}
	}

	public void closeFile() {
		try {
			this.raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Car> list() {
		openFile();
		List<Car> cars = new ArrayList<Car>();
		try {
			raf.seek(0);
			while (raf.getFilePointer() < raf.length()) {
				String chassi = this.readString(12);
				String brand = this.readString(12);
				String model = this.readString(12);
				int year = raf.readInt();
				double price = raf.readDouble();
				cars.add(new Car(chassi, brand, model, year, price));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		closeFile();
		return cars;
	}
}
