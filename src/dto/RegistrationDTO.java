package dto;

public class RegistrationDTO {
    private String regNo;
    private String regDate;
    private double regFee;
    private String stID;
    private String courseCode;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String regNo, String regDate, double regFee, String stID, String courseCode) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        this.stID = stID;
        this.courseCode = courseCode;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public String getStID() {
        return stID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "regNo='" + regNo + '\'' +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", stID='" + stID + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
