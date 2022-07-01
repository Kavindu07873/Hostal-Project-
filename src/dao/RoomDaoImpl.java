package dao;

import Entity.Rooms;
import Entity.Student;
import Utill.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class RoomDaoImpl implements RoomDao {

    public static List<String> getRoomDetails(String selectRoomtype) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT KyMoney FROM Rooms WHERE Room_type = :Room_type";
        Query query = session.createQuery(hql);

        query.setParameter("Room_type",selectRoomtype);

        List<String> RoomType = (List<String>) ((org.hibernate.query.Query<?>) query).list();

        transaction.commit();
        session.close();
        System.out.println(RoomType);
        return RoomType;
    }

    public static List<String> getKeyWords(String w) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT Type_Id  FROM Rooms WHERE Room_type = :Room_type";
        Query query = session.createQuery(hql);

        query.setParameter("Room_type",w);

        List<String> keyType = (List<String>) ((org.hibernate.query.Query<?>) query).list();

        transaction.commit();
        session.close();

        return keyType;
    }

    @Override
    public List<Rooms> loadAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql= " From Rooms";
        Query query = session.createQuery(hql);
        List<Rooms> list = (List<Rooms>) ((org.hibernate.query.Query<?>) query).list();
        transaction.commit();
        session.close();
        System.out.println(list);
        return  list;
    }



    @Override
    public boolean save(Rooms rooms) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(rooms);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Rooms rooms = session.load(Rooms.class, s);

        session.delete(rooms);

        transaction.commit();
        session.close();
        return true;    }



    @Override
    public boolean update(Student student) {
        return false;
    }

    public static List getRoomIds() throws  SQLException{
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        String hql = "SELECT Type_Id FROM Rooms";
        Query query = session.createQuery(hql);
        List<Rooms> list = (List<Rooms>) ((org.hibernate.query.Query<?>) query).list();
          System.out.println(list);

        transaction.commit();
        session.close();
        return list;
    }
}
