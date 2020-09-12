package bo.custom.impl;

import bo.custom.RegistrationBO;
import dao.DAOFactory;
import dao.QueryDAO;
import dao.custom.RegistrationDAO;
import dao.custom.StudentDAO;
import db.DBConnection;
import dto.RegistrationDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Registration;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RegistrationBOImpl implements RegistrationBO{

    RegistrationDAO registrationDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOType.REGISTRATION);
    StudentDAO studentDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOType.STUDENT);
    QueryDAO queryDAO = DAOFactory.getInstance().getDao(DAOFactory.DAOType.QUERY);

    @Override
    public boolean addRegistration(StudentDTO studentDTO) throws Exception {
        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        Student student = studentDAO.get(studentDTO.getStId());
        try {
            if (student != null) {
                for (RegistrationDTO regDTO : studentDTO.getAllRegDetails()) {
                    Registration registration = new Registration(
                            regDTO.getRegNo(),
                            regDTO.getRegDate(),
                            regDTO.getRegFee(),
                            regDTO.getStID(),
                            regDTO.getCourseCode()
                    );

                    boolean isAddedRegistartion = registrationDAO.save(registration);
                    if (!isAddedRegistartion) {
                        connection.rollback();
                        return false;
                    }
                }
                connection.commit();
                return true;
              }else{
                boolean isAddedStudent = studentDAO.save(
                                        new Student(
                                                studentDTO.getStId(),
                                                studentDTO.getStName(),
                                                studentDTO.getStAddress(),
                                                studentDTO.getStContact(),
                                                studentDTO.getStDob(),
                                                studentDTO.getStGender())
                );
                if (isAddedStudent) {
                    for (RegistrationDTO regDTO : studentDTO.getAllRegDetails()) {
                        Registration reg = new Registration(
                                regDTO.getRegNo(),
                                regDTO.getRegDate(),
                                regDTO.getRegFee(),
                                regDTO.getStID(),
                                regDTO.getCourseCode()
                        );

                        boolean isAddedRegistartion = registrationDAO.save(reg);
                            if (!isAddedRegistartion) {
                                    connection.rollback();
                                    return false;
                                }
                    }
                    connection.commit();
                        return true;
                    } else {
                            connection.rollback();
                                return false;
                            }
                    }
                }
            finally{
                connection.setAutoCommit(true);
            }
    }

    @Override
    public boolean saveReg(RegistrationDTO registrationDTO) throws Exception {
        return registrationDAO.save(new Registration(registrationDTO.getRegNo(),registrationDTO.getRegDate(),registrationDTO.getRegFee(),registrationDTO.getStID(),registrationDTO.getCourseCode()));
    }

    @Override
    public int getRegCount() throws ClassNotFoundException, SQLException {
        return registrationDAO.getRegCount();
    }

    @Override
    public int getReg(String code) throws Exception {
        return registrationDAO.getRegCount();
    }

    @Override
    public ArrayList<RegistrationDTO> getAllRegister() throws Exception {
        List<Registration> registrationList=registrationDAO.getAll();
        ArrayList<RegistrationDTO> registrationDTOArrayList= new ArrayList();
        for (Registration registration : registrationList) {
            registrationDTOArrayList.add(new RegistrationDTO(
                    registration.getRegNo(),
                    registration.getRegDate(),
                    registration.getRegFee(),
                    registration.getStId(),
                    registration.getCourseCode())
            );
        }
        return registrationDTOArrayList;
    }

    @Override
    public RegistrationDTO getRegister(String id) throws Exception {
        Registration registration=registrationDAO.get(id);
        return new RegistrationDTO(
                registration.getRegNo(),
                registration.getRegDate(),
                registration.getRegFee(),
                registration.getStId(),
                registration.getCourseCode()
        );
    }

    @Override
    public ObservableList<StudentDTO> getStudents(String name) throws ClassNotFoundException, SQLException {
        ObservableList<Student> list = queryDAO.getStudents(name);
        ObservableList<StudentDTO> studentList = FXCollections.observableArrayList();
        for (Student student : list) {
            studentList.add(
                    new StudentDTO(
                            student.getStId(),
                            student.getStName(),
                            student.getStAddress(),
                            student.getStContact(),
                            student.getStDob(),
                            student.getStGender())
            );
        }
        return studentList;
    }
}
