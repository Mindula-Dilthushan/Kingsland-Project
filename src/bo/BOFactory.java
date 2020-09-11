package bo;

import bo.custom.impl.CourseBOImpl;
import bo.custom.impl.RegistrationBOImpl;
import bo.custom.impl.StudentBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    //2nd Step
    private BOFactory(){

    }

    //3rd Step
    public static BOFactory getInstance() {
        return (boFactory == null) ?
                (boFactory = new BOFactory()) : (boFactory);
    }

    //4th Step
    public enum BOType {
        STUDENT, COURSE, REGISTRATION
    }

    //5th Step
    public <T> T getBo(BOType type) {
        switch (type) {
            case STUDENT:
                return (T) new StudentBOImpl();
            case COURSE:
                return (T) new CourseBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBOImpl();
             default:
                return null;
        }
    }
}
