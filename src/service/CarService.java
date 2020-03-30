package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import entities.Car;

public class CarService {
	
	public void save(Car car) {
		try {
			System.out.println("Agora estou salvando esse carro: " + car);
			FileWriter writer = new FileWriter("cars.txt", true);
			PrintWriter print = new PrintWriter(writer);
			print.printf("%s" + "%n", car);
			print.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void read() {
		try {
			FileReader fr = new FileReader("cars.txt");
			BufferedReader textReader = new BufferedReader(fr);
			String line = textReader.readLine();
			while (line != null) {
				System.out.println(line);
				line = textReader.readLine();
			}
			textReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
