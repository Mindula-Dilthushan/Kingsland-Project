package dao.custom;

import dao.CrudDAO;
import entity.Registration;
import java.sql.SQLException;

public interface RegistrationDAO extends CrudDAO<Registration,String> {
    int getRegCount()throws ClassNotFoundException, SQLException;
}
