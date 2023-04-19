package dao.impl;

import Entity.Student;
import Utill.FactoryConfiguration;
import dao.StudentDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    public static List getStudentIds() throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        //        Student resultSet =  session.get(Student.class,);
        //        System.out.println(resultSet);
        //        ArrayList<String> ids = new ArrayList<>();
        //        while (resultSet.next()){
        //            ids.add(resultSet.getString(1));
        //        }

            String hql = "SELECT Stu_Id FROM Student";
              Query query = session.createQuery(hql);
        List<Student> list = (List<Student>) ((org.hibernate.query.Query<?>) query).list();
        System.out.println("aaaaaaaaaa");

        System.out.println(list);

        transaction.commit();
        session.close();
      return list;
    }

    public static List<String> getStudentDetails(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//      //  String hql= " SELECT Name FROM  Student WHERE Stu_Id ";
//        String hql = "SELECT Name  FROM Student WHERE Stu_Id = :Student_Stu_Id";
//
//        Query query = session.createQuery(hql);
//        List<Student> list = (List<Student>) ((org.hibernate.query.Query<?>) query).list();
//        //
//        System.out.println(list);
//String sql = "SELECT * FROM EMPLOYEE WHERE id = :employee_id";
//SQLQuery query = session.createSQLQuery(sql);
//query.addEntity(Employee.class);
//query.setParameter("employee_id", 10);
//List results = query.list();

//        String hql = "FROM Employee E WHERE E.id = :employee_id";
//Query query = session.createQuery(hql);
//query.setParameter("employee_id",10);
//List results = query.list();
    String hql = "SELECT Name FROM Student WHERE Stu_Id = :Student_id";
    Query query = session.createQuery(hql);

    query.setParameter("Student_id",id);

    List<String> studentList = (List<String>) ((org.hibernate.query.Query<?>) query).list();


      //  System.out.println("1");
 //       System.out.println(studentList);



        transaction.commit();
        session.close();

        return studentList;
    }



//    @Override
//    public List<Student> getAll() throws SQLException, ClassNotFoundException {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        String hql= " From Student";
//        Query query = session.createQuery(hql);
//        List<Student> list = (List<Student>) ((org.hibernate.query.Query<?>) query).list();
//        transaction.commit();
//        session.close();
//
//        return  list;
//    }


  //  @Override
   // public List<Student> findAll() throws Exception {
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        String hql= " From Student";
//        Query query = session.createQuery(hql);
//        List<Student> list = (List<Student>) ((org.hibernate.query.Query<?>) query).list();
//        transaction.commit();
//        session.close();
//
//        return  list;
 //   }

    @Override
    public List<Student> loadAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql= " From Student";
        Query query = session.createQuery(hql);
        List<Student> list = (List<Student>) ((org.hibernate.query.Query<?>) query).list();
        transaction.commit();
        session.close();

        return  list;
    }

    @Override
    public boolean save(Student student) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(student);

        transaction.commit();
        session.close();
        return true;
    }
    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.load(Student.class, s);

        session.delete(student);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(student);

        transaction.commit();
        session.close();
        return true;    }
}
