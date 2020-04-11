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

	public void saveCar(Car car) {
		openFile();
		add(car);
		closeFile();
	}

	private void add(Car car) {
		try {
			this.raf.seek(this.raf.length());
			this.writeString(car.getChassi(), 12);
			this.raf.writeInt(car.getYear());
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
		char palavra[] = new char[size];
		char temp;
		for(int i=0; i< palavra.length; i++) {
		temp = this.raf.readChar();
		palavra[i] = temp; }
		return new String (palavra).replace('\0', ' '); 
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
				int year = raf.readInt();
				cars.add(new Car(chassi,year));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		closeFile();
		return cars;
	}
}
