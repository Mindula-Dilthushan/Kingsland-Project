package bo.custom;


import dto.RegistrationDTO;
import dto.StudentDTO;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;


public interface RegistrationBO {
    boolean addRegistration(StudentDTO studentDTO) throws Exception;
    public boolean saveReg(RegistrationDTO registrationDTO)throws Exception;
    int getRegCount()throws ClassNotFoundException, SQLException;
    public int getReg(String code)throws Exception;
    public ArrayList<RegistrationDTO> getAllRegister()throws Exception;
    public RegistrationDTO getRegister(String id)throws Exception;
    ObservableList<StudentDTO> getStudents(String name)throws ClassNotFoundException, SQLException;
}

