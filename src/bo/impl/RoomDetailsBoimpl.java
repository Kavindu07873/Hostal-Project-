package bo.impl;

import Entity.Reserved;
import Entity.Rooms;
import bo.RoomDetailsBo;
import dao.impl.RoomDetailsDaoimpl;

import java.sql.SQLException;
import java.util.List;

public class RoomDetailsBoimpl implements RoomDetailsBo {

    RoomDetailsDaoimpl roomDetailsDaoimpl = new RoomDetailsDaoimpl();

    @Override
    public List<Reserved> getAllRoomsDetails()throws SQLException,ClassNotFoundException{
        return roomDetailsDaoimpl.loadAll();
    }

}
