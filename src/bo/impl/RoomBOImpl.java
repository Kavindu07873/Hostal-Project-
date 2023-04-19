package bo.impl;

import Entity.Rooms;
import bo.RoomBo;
import dao.impl.RoomDaoImpl;

import java.sql.SQLException;
import java.util.List;

public class RoomBOImpl implements RoomBo {
    RoomDaoImpl roomDao =  new RoomDaoImpl();
  @Override
    public List<Rooms> getAllRooms()throws SQLException ,ClassNotFoundException{
        return roomDao.loadAll();
    }

    public boolean saveRoom(Rooms rooms) throws SQLException, ClassNotFoundException {
   return roomDao.save(rooms);
    }
            @Override
        public boolean deleteStudent(String no) throws Exception {
      return roomDao.delete(no);
    }
}
