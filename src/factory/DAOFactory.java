package factory;

import dao.CarDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;

	public abstract CarDAO getCarDAO();

	public static DAOFactory getDAOFactory(int qualFabrica) {
		switch (qualFabrica) {
		case MYSQL:
			return new MySQLDAOFactory();
		default:
			return null;
		}
	}

}
