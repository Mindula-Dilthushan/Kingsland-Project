package dao;

import dao.custom.impl.CourseDAOImpl;
import dao.custom.impl.QueryDAOImpl;
import dao.custom.impl.RegistrationDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? (daoFactory = new DAOFactory()) : (daoFactory);
    }

    public enum DAOType {
        STUDENT, COURSE, REGISTRATION,QUERY
    }

    public <T> T getDao(DAOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentDAOImpl();
            case COURSE:
                return (T) new CourseDAOImpl();
            case REGISTRATION:
                return (T) new RegistrationDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }
}
