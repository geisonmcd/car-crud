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
	static final String FILE_NAME = "file.dat";
	static final int CHASSI_FIELD_SIZE = 24;
	static final int BRAND_FIELD_SIZE = 24;
	static final int MODEL_FIELD_SIZE = 24;
	static final int YEAR_FIELD_SIZE = 4;
	static final int PRICE_FIELD_SIZE = 8;
	static final int DELETED_FIELD_SIZE = 4;
	static final int REGISTER_SIZE = CHASSI_FIELD_SIZE + BRAND_FIELD_SIZE + MODEL_FIELD_SIZE + YEAR_FIELD_SIZE + PRICE_FIELD_SIZE + DELETED_FIELD_SIZE;
	static final int CHASSI_STRING_SIZE = CHASSI_FIELD_SIZE / 2;
	static final int BRAND_STRING_SIZE = BRAND_FIELD_SIZE / 2;
	static final int MODEL_STRING_SIZE = MODEL_FIELD_SIZE / 2;
	static final int NOT_DELETED = 0;
	static final int DELETED = 1;

	public void saveCar(Car car) {
		openFile();
		try {
			this.raf.seek(this.raf.length());
			this.writeString(car.getChassi(), CHASSI_STRING_SIZE);
			this.writeString(car.getBrand(), BRAND_STRING_SIZE);
			this.writeString(car.getModel(), MODEL_STRING_SIZE);
			this.raf.writeInt(car.getYear());
			this.raf.writeDouble(car.getPrice());
			this.raf.writeInt(NOT_DELETED);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFile();			
		}
	}

	public void deleteCar(Car car) {
		car.setDeleted(DELETED);
		updateCar(car);
	}

	public void updateCar(Car car) {
		openFile();
		try {
			int registerIndex = 1;
			while (raf.getFilePointer() < raf.length()) {
				String chassi = this.readString(CHASSI_STRING_SIZE);
				if (car.getChassi().equals(chassi.trim())) {
					if (car.getBrand() != null) {
						this.writeString(car.getBrand(), BRAND_STRING_SIZE);
					} else if (car.getModel() != null) {
						raf.seek(raf.getFilePointer() + BRAND_FIELD_SIZE);
						this.writeString(car.getModel(), MODEL_STRING_SIZE);
					} else if (car.getYear() != null) {
						raf.seek(raf.getFilePointer() + BRAND_FIELD_SIZE + MODEL_FIELD_SIZE);
						raf.writeInt(car.getYear());
					} else if(car.getPrice() != null) {
						raf.seek(raf.getFilePointer() + BRAND_FIELD_SIZE + MODEL_FIELD_SIZE + YEAR_FIELD_SIZE);
						raf.writeDouble(car.getPrice());
					} else if (car.getDeleted() != null) {
						raf.seek(raf.getFilePointer() + BRAND_FIELD_SIZE + MODEL_FIELD_SIZE + YEAR_FIELD_SIZE + PRICE_FIELD_SIZE);
						raf.writeInt(DELETED);
					}
					break;
				}
				raf.seek(registerIndex * REGISTER_SIZE);
				registerIndex++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFile();
		}
	}

	public List<Car> findCarsByChassiOrModel(String text) {
		if (text.isEmpty())	return new ArrayList<Car>();
		openFile();
		List<Car> cars = new ArrayList<Car>();
		try {
			raf.seek(0);
			while (raf.getFilePointer() < raf.length()) {
				String chassi = this.readString(CHASSI_STRING_SIZE);
				String brand = this.readString(BRAND_STRING_SIZE);
				String model = this.readString(MODEL_STRING_SIZE);
				int year = raf.readInt();
				double price = raf.readDouble();
				int deleted = raf.readInt();
				if (deleted == NOT_DELETED && (chassi.contains(text) || model.contains(text))) {
					cars.add(new Car(chassi, brand, model, year, price, deleted));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		closeFile();
		return cars;
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
			File fileName = new File(FILE_NAME);
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
				String chassi = this.readString(CHASSI_STRING_SIZE);
				String brand = this.readString(BRAND_STRING_SIZE);
				String model = this.readString(MODEL_STRING_SIZE);
				int year = raf.readInt();
				double price = raf.readDouble();
				int deleted = raf.readInt();
				cars.add(new Car(chassi, brand, model, year, price, deleted));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFile();
		}
		return cars;		
	}
}
