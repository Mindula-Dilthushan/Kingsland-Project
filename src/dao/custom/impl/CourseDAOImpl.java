package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CourseDAO;
import entity.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean save(Course course) throws Exception {
        return CrudUtil.execute("INSERT INTO course VALUES(?,?,?,?,?)",course.getCourseCode(),course.getCourseName(),course.getCourseIntake(),course.getCourseFee(),course.getCourseDuration());
    }

    @Override
    public boolean update(Course course) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Course get(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM course WHERE courseCode=?",s);
        if (resultSet.next()) {
            return new Course(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5));
        } else {
            return null;
        }
    }

    @Override
    public List<Course> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM course");
        ArrayList<Course> courseArrayList = new ArrayList<>();
        while (resultSet.next()) {
            courseArrayList.add(
                    new Course(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4),
                            resultSet.getString(5)
                    )
            );
        }
        return courseArrayList;
    }

    @Override
    public int getRegCount() throws ClassNotFoundException, SQLException {
        String SQL = "SELECT COUNT(courseCode) FROM course";
        ResultSet rst = CrudUtil.execute(SQL);
        if (rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }
}
