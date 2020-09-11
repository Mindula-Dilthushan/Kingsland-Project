package bo.custom.impl;

import bo.custom.StudentBO;
import dto.StudentDTO;
import java.util.ArrayList;

public class StudentBOImpl implements StudentBO {
    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws Exception {
        return false;
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return false;
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        return null;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws Exception {
        return null;
    }

    @Override
    public String getId() throws Exception {
        return null;
    }
}
