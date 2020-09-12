package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.RegistrationDAO;
import entity.Registration;
import entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public boolean save(Registration registration) throws Exception {
        return CrudUtil.execute("INSERT INTO registration VALUES(?,?,?,?,?)",registration.getRegNo(),registration.getRegDate(),registration.getRegDate(),registration.getStId(),registration.getCourseCode());
    }

    @Override
    public boolean update(Registration registration) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Registration get(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM registration WHERE regNo=?",s);
        if (resultSet.next()) {
            return new Registration(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getDouble(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            );
        } else {
            return null;
        }
    }

    @Override
    public List<Registration> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM registration");
        ArrayList<Registration> registrationArrayList = new ArrayList<>();
        while (resultSet.next()) {
            registrationArrayList.add(
                    new Registration(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    )
            );
        }
        return registrationArrayList;
    }

    @Override
    public int getRegCount() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(regNo) FROM registration";
        ResultSet rst = CrudUtil.execute(SQL);
        if (rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }
}
