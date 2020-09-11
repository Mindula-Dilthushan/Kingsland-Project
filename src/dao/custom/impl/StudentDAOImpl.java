package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.StudentDAO;
import entity.Student;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean save(Student student) throws Exception {
        return CrudUtil.execute("INSERT INTO student VALUES(?,?,?,?,?)",student.getStId(),student.getStName(),student.getStAddress(),student.getStContact(),student.getStDob(),student.getStGender());
    }

    @Override
    public boolean update(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }

    @Override
    public Student get(String s) throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM student WHERE stId=?",s);
        if (resultSet.next()) {
            return new Student(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        } else {
            return null;
        }
    }

    @Override
    public List<Student> getAll() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM student");
        ArrayList<Student> studentArrayList = new ArrayList<>();
        while (resultSet.next()) {
            studentArrayList.add(
                    new Student(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        System.out.println("studentArrayList = " + studentArrayList);
        return studentArrayList;
    }
}
