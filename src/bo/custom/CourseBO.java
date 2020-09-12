package bo.custom;

import dto.CourseDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseBO {

    public boolean saveCourse(CourseDTO courseDTO) throws Exception;

    public boolean updateCourse(CourseDTO courseDTO) throws Exception;

    public boolean deleteCourse(String id) throws Exception;

    public CourseDTO getCourse(String id) throws Exception;

    public ArrayList<CourseDTO> getAllCourse() throws Exception;
    public String getId() throws Exception;
    public int getRegCount()throws ClassNotFoundException, SQLException;
}