package entity;

public class Student implements SuperEntity {
    private String stId;
    private String stName;
    private String stAddress;
    private String stContact;
    private String stDob;
    private String stGender;

    public Student() {
    }

    public Student(String stId, String stName, String stAddress, String stContact, String stDob, String stGender) {
        this.stId = stId;
        this.stName = stName;
        this.stAddress = stAddress;
        this.stContact = stContact;
        this.stDob = stDob;
        this.stGender = stGender;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getStAddress() {
        return stAddress;
    }

    public void setStAddress(String stAddress) {
        this.stAddress = stAddress;
    }

    public String getStContact() {
        return stContact;
    }

    public void setStContact(String stContact) {
        this.stContact = stContact;
    }

    public String getStDob() {
        return stDob;
    }

    public void setStDob(String stDob) {
        this.stDob = stDob;
    }

    public String getStGender() {
        return stGender;
    }

    public void setStGender(String stGender) {
        this.stGender = stGender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "stId='" + stId + '\'' +
                ", stName='" + stName + '\'' +
                ", stAddress='" + stAddress + '\'' +
                ", stContact='" + stContact + '\'' +
                ", stDob='" + stDob + '\'' +
                ", stGender='" + stGender + '\'' +
                '}';
    }
}
