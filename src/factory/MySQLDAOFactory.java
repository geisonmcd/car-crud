package factory;

import dao.CarDAO;
import dao.MySQLCarDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public CarDAO getCarDAO() {
		return new MySQLCarDAO();
	}

}
