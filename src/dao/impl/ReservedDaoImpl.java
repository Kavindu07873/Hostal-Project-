package dao.impl;

import Entity.Reserved;
import Entity.Student;
import Utill.FactoryConfiguration;
import dao.ReservedDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ReservedDaoImpl implements ReservedDao {

//@Override
//public boolean save(Reserved reserved) throws SQLException, ClassNotFoundException{
//        Session session = FactoryConfiguration.getInstance().getSession();
//        Transaction transaction = session.beginTransaction();
//
//        session.save(reserved);
//
//        transaction.commit();
//        session.close();
//        return true;
//        }

    @Override
    public List loadAll() throws SQLException, ClassNotFoundException {
        return null;
    }

//    @Override
    public static String generateNewID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql="SELECT Reserved_id FROM Reserved ORDER BY Reserved_id DESC";
        Query query = session.createQuery(hql);
        query.setMaxResults(1);
        List<String> list = query.list();

        transaction.commit();
        session.close();

        return list.isEmpty() ? "R-001" : String.format("R-%03d", (Integer.parseInt(list.get(0).replace("R-", "")) + 1));
    }

    @Override
    public boolean save(Reserved reserved) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(reserved);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        return false;
    }


    @Override
    public boolean update(Student student) {
        return false;
    }
}
