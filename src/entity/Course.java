package entity;

public class Course implements SuperEntity{
    private String courseCode;
    private String courseName;
    private String courseIntake;
    private double courseFee;
    private String courseDuration;

    public Course() {
    }

    public Course(String courseCode, String courseName, String courseIntake, double courseFee, String courseDuration) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseIntake = courseIntake;
        this.courseFee = courseFee;
        this.courseDuration = courseDuration;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseIntake() {
        return courseIntake;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseIntake='" + courseIntake + '\'' +
                ", courseFee=" + courseFee +
                ", courseDuration='" + courseDuration + '\'' +
                '}';
    }
}
