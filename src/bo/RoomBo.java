package bo;

import Entity.Rooms;

import java.sql.SQLException;
import java.util.List;

public interface RoomBo {
    public List<Rooms> getAllRooms() throws SQLException, ClassNotFoundException;

    boolean deleteStudent(String no) throws Exception;
}
