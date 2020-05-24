package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Car;

public class MySQLCarDAO implements CarDAO {

	String dbdriver = "com.mysql.cj.jdbc.Driver";
	String dburl = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC";
	String dbusuario = "root";
	String dbsenha = "root";

	@Override
	public boolean createTableIfNotExists() {
		try {
			Class.forName(dbdriver);
			Connection con = DriverManager.getConnection(dburl, dbusuario, dbsenha);
			Statement stmt = con.createStatement();
			stmt.execute("create table if not exists car (chassi varchar(30) primary key, brand varchar(30), "
					+ "model varchar(30) not null, year integer, price double);");
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean saveCar(Car car) {
		try {
			Class.forName(dbdriver);
			Connection con = DriverManager.getConnection(dburl, dbusuario, dbsenha);
			PreparedStatement ps = con.prepareStatement("insert into car values (?,?,?,?,?)");
			ps.setString(1, car.getChassi());
			ps.setString(2, car.getBrand());
			ps.setString(3, car.getModel());
			ps.setInt(4, car.getYear());
			ps.setDouble(5, car.getPrice());
			ps.executeUpdate();
			ps.close();
			con.close();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCar(Car car) {
		try {
			Class.forName(dbdriver);
			Connection con = DriverManager.getConnection(dburl, dbusuario, dbsenha);
			PreparedStatement pstmt = con
					.prepareStatement("UPDATE car SET brand=?, model=?, year=?, price=? WHERE chassi=?");
			pstmt.setString(1, car.getBrand());
			pstmt.setString(2, car.getModel());
			pstmt.setInt(3, car.getYear());
			pstmt.setDouble(4, car.getPrice());
			pstmt.setString(5, car.getChassi());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCar(Car car) {
		try {
			Class.forName(dbdriver);
			Connection con = DriverManager.getConnection(dburl, dbusuario, dbsenha);
			PreparedStatement pstmt = con.prepareStatement("DELETE FROM car WHERE chassi=?");
			pstmt.setString(1, car.getChassi());
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Car> findByChassiOrModel(String text) {
		try {
			Class.forName(dbdriver);
			Connection con = DriverManager.getConnection(dburl, dbusuario, dbsenha);
			PreparedStatement stmt = con.prepareStatement("SELECT * from car where chassi like ? or model like ?");
			stmt.setString(1, '%' + text + '%');
			stmt.setString(2, '%' + text + '%');
			ResultSet rs = stmt.executeQuery();
			List<Car> cars = new ArrayList<Car>();
			while (rs.next()) {
				String chassi = rs.getString("chassi");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				int year = rs.getInt("year");
				double price = rs.getDouble("price");
				cars.add(new Car(chassi, brand, model, year, price));
			}
			stmt.close();
			rs.close();
			con.close();
			return cars;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<Car>();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Car>();
		}
	}

	@Override
	public List<Car> list() {
		try {
			Class.forName(dbdriver);
			Connection con = DriverManager.getConnection(dburl, dbusuario, dbsenha);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from car");
			List<Car> cars = new ArrayList<Car>();
			while (rs.next()) {
				String chassi = rs.getString("chassi");
				String brand = rs.getString("brand");
				String model = rs.getString("model");
				int year = rs.getInt("year");
				double price = rs.getDouble("price");
				cars.add(new Car(chassi, brand, model, year, price));
			}
			stmt.close();
			rs.close();
			con.close();
			return cars;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<Car>();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Car>();
		}
	}

	@Override
	public int getRegisterCount() {
		try {
			Class.forName(dbdriver);
			Connection con = DriverManager.getConnection(dburl, dbusuario, dbsenha);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select count(*) as count from car");
			int count = 0;
			if (rs.next()) {
				count = rs.getInt("count");
			}
			stmt.close();
			rs.close();
			con.close();
			return count;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public boolean clearFile() {
		try {
			Class.forName(dbdriver);
			Connection con = DriverManager.getConnection(dburl, dbusuario, dbsenha);
			Statement stmt = con.createStatement();
			stmt.execute("truncate table car");
			stmt.close();
			con.close();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
