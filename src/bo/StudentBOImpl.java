package bo;

import Entity.Student;
import dao.StudentDao;
import dao.StudentDaoImpl;
import org.jetbrains.annotations.NotNull;

import java.sql.SQLException;
import java.util.List;

public class StudentBOImpl implements StudentBo {
    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean update(@NotNull Student student) {
        return studentDao.update(new Student(
                student.getStu_Id(),
                student.getName(),
                student.getAddress()
        ));
    }

    @Override
    public List<Student> getAllStudent() throws SQLException, ClassNotFoundException {
       return studentDao.loadAll();
    }

    @Override
    public boolean deleteStudent(String id) throws Exception {
        return studentDao.delete(id);
    }
//
//    @Override
//    public boolean delete(String id) throws Exception {
//        return false;
//    }

    public boolean saveStudent(Student student) throws SQLException, ClassNotFoundException {
        return studentDao.save(student);
    }



//    @Override
//    public boolean delete(String id) throws Exception {
//        return StudentDao.delete(id);
//    }
}
