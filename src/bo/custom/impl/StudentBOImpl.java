package bo.custom.impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.QueryDAO;
import dao.custom.StudentDAO;
import dto.StudentDTO;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private StudentDAO studentDAO= DAOFactory.getInstance().getDao(DAOFactory.DAOType.STUDENT);
    private QueryDAO queryDAO= DAOFactory.getInstance().getDao(DAOFactory.DAOType.QUERY);

    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.save(new Student(studentDTO.getStId(), studentDTO.getStName(),studentDTO.getStAddress(),studentDTO.getStContact(),studentDTO.getStDob(),studentDTO.getStGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return studentDAO.update(new Student(studentDTO.getStId(), studentDTO.getStName(),studentDTO.getStAddress(),studentDTO.getStContact(),studentDTO.getStDob(),studentDTO.getStGender()));
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDAO.delete(id);
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        Student student=studentDAO.get(id);
        return new StudentDTO(student.getStId(), student.getStName(),student.getStAddress(),student.getStContact(),student.getStDob(),student.getStGender());
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws Exception {
        List<Student> studentList=studentDAO.getAll();
        ArrayList<StudentDTO> studentDTOArrayList= new ArrayList();
        for (Student student : studentList) {
            studentDTOArrayList.add(new StudentDTO(
                    student.getStId(),
                    student.getStName(),
                    student.getStAddress(),
                    student.getStContact(),
                    student.getStDob(),
                    student.getStGender())
            );
        }
        return studentDTOArrayList;
    }

    @Override
    public String getId() throws Exception {
        return null;
    }

    @Override
    public int getRegCount() throws ClassNotFoundException, SQLException {
        return studentDAO.getRegCount();
    }
}
