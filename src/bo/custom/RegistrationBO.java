package bo.custom;

import dto.RegistrationDTO;
import java.util.ArrayList;

public interface RegistrationBO {
    public boolean saveRegistration(RegistrationDTO registrationDTO)throws Exception;
    public boolean updateRegistration(RegistrationDTO registrationDTO)throws Exception;
    public boolean deleteRegistration(String id)throws Exception;
    public RegistrationDTO getRegistration(String id)throws Exception;
    public ArrayList<RegistrationDTO> getAllRegistration()throws Exception;
    public String getId()throws Exception;
}

