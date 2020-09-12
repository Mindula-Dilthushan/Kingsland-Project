package entity;

public class Registration implements SuperEntity {
    private String regNo;
    private String regDate;
    private double regFee;
    private String stId;
    private String courseCode;

    public Registration() {
    }

    public Registration(String regNo, String regDate, double regFee, String stId, String courseCode) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        this.stId = stId;
        this.courseCode = courseCode;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNo='" + regNo + '\'' +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", stId='" + stId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}
