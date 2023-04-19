package dao.impl;

import Entity.Reserved;
import Entity.Rooms;
import Entity.Student;
import Utill.FactoryConfiguration;
import dao.RoomDetailsDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class RoomDetailsDaoimpl implements RoomDetailsDao {

    @Override
    public List<Reserved> loadAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql= " From Reserved ";
        Query query = session.createQuery(hql);
        List<Reserved> list = (List<Reserved>) ((org.hibernate.query.Query<?>) query).list();
        transaction.commit();
        session.close();
        System.out.println(list);
        return  list;
    }

    @Override
    public boolean save(Reserved student) throws SQLException, ClassNotFoundException {
        return false;
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
