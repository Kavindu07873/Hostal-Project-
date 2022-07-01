package bo;

import Entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentBo {

    //static List<StudentDto> getAllStudent() {
   //     return null;
//    }

    boolean update( Student student);

    public List<Student> getAllStudent() throws SQLException, ClassNotFoundException;
    public  boolean deleteStudent(String id) throws Exception;



}
