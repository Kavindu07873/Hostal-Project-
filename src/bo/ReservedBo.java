package bo;

import Entity.Reserved;

import java.sql.SQLException;

public interface ReservedBo {
    boolean saveReserved(Reserved reserved) throws SQLException, ClassNotFoundException;
}
