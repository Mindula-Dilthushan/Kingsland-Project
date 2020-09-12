package dao.custom;

import dao.CrudDAO;
import entity.Course;
import java.sql.SQLException;

public interface CourseDAO extends CrudDAO<Course,String> {
    int getRegCount()throws ClassNotFoundException, SQLException;

}
