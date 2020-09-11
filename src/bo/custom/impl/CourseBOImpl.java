package bo.custom.impl;

import bo.custom.CourseBO;
import dao.DAOFactory;
import dao.QueryDAO;
import dao.custom.CourseDAO;
import dto.CourseDTO;
import entity.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {

    private CourseDAO courseDAO= DAOFactory.getInstance().getDao(DAOFactory.DAOType.COURSE);
    private QueryDAO queryDAO= DAOFactory.getInstance().getDao(DAOFactory.DAOType.QUERY);

    @Override
    public boolean saveCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.save(new Course(courseDTO.getCourseCode(), courseDTO.getCourseName(),courseDTO.getCourseIntake(),courseDTO.getCourseFee(),courseDTO.getCourseDuration()));
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) throws Exception {
        return courseDAO.update(new Course(courseDTO.getCourseCode(), courseDTO.getCourseName(),courseDTO.getCourseIntake(),courseDTO.getCourseFee(),courseDTO.getCourseDuration()));
    }

    @Override
    public boolean deleteCourse(String id) throws Exception {
        return courseDAO.delete(id);
    }

    @Override
    public CourseDTO getCourse(String id) throws Exception {
        Course course=courseDAO.get(id);
        return new CourseDTO(course.getCourseCode(), course.getCourseName(),course.getCourseIntake(),course.getCourseFee(),course.getCourseDuration());
    }

    @Override
    public ArrayList<CourseDTO> getAllCourse() throws Exception {
        List<Course> courseList=courseDAO.getAll();
        ArrayList<CourseDTO> courseDTOArrayList= new ArrayList();
        for (Course course : courseList) {
            courseDTOArrayList.add(new CourseDTO(course.getCourseCode(),course.getCourseName(),course.getCourseIntake(),course.getCourseFee(),course.getCourseDuration()));
        }
        return courseDTOArrayList;
    }

    @Override
    public String getId() throws Exception {
        return queryDAO.getId();
    }
}
