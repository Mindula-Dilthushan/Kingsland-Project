package dao.custom.impl;

import dao.CrudUtil;
import dao.QueryDAO;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public ObservableList<Student> getStudents(String name) throws ClassNotFoundException, SQLException {
        String SQL = "SELECT DISTINCT " +
                "s.stId," +
                "s.stName," +
                "s.stAddress," +
                "s.stContact," +
                "s.stDob," +
                "s.stGender " +
                "FROM student s," +
                "course c," +
                "registration r\n" +
                "where (c.courseCode=r.courseCode && s.stId=r.stId) and c.courseName = ? ";

        ResultSet rst = CrudUtil.execute(SQL,name);
        ObservableList<Student> list = FXCollections.observableArrayList();
        while (rst.next()){
            list.add(new Student(
                    rst.getString("stId"),
                    rst.getString("stName"),
                    rst.getString("stAddress"),
                    rst.getString("stContact"),
                    rst.getString("stDob"),
                    rst.getString("stGender")));
        }
        return list;
    }
}
