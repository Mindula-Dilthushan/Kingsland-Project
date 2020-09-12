package dao;

import entity.Student;
import javafx.collections.ObservableList;
import java.sql.SQLException;

public interface QueryDAO extends SuperDAO {
    ObservableList<Student> getStudents(String name)throws ClassNotFoundException, SQLException;
}
