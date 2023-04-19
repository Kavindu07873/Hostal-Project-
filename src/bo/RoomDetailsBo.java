package bo;

import Entity.Reserved;

import java.sql.SQLException;
import java.util.List;

public interface RoomDetailsBo {


    List<Reserved> getAllRoomsDetails()throws SQLException,ClassNotFoundException;
}
