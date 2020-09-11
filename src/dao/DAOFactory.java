package dao;

import bo.custom.impl.CourseBOImpl;
import bo.custom.impl.RegistrationBOImpl;
import bo.custom.impl.StudentBOImpl;
import dao.custom.impl.QueryDAOImpl;

public class DAOFactory {
    //1st Step
    private static DAOFactory daoFactory;

    //2nd Step
    private DAOFactory() {
    }

    //3rd Step
    public static DAOFactory getInstance() {
        return (daoFactory == null) ?
                (daoFactory = new DAOFactory()) : (daoFactory);
    }

    //4th Step
    public enum DAOType {
        STUDENT, COURSE, REGISTRATION,QUERY
    }

    public <T> T getDao(DAOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }

}
