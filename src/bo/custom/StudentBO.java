package bo.custom;

import dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBO {
    public boolean saveStudent(StudentDTO studentDTO)throws Exception;
    public boolean updateStudent(StudentDTO studentDTO)throws Exception;
    public boolean deleteStudent(String id)throws Exception;
    public StudentDTO getStudent(String id)throws Exception;
    public ArrayList<StudentDTO> getAllStudent()throws Exception;
    public String getId()throws Exception;
}
