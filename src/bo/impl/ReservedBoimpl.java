package bo.impl;

import Entity.Reserved;
import bo.ReservedBo;
import dao.impl.ReservedDaoImpl;

import java.sql.SQLException;

public class ReservedBoimpl implements ReservedBo {
    ReservedDaoImpl reservedDao = new ReservedDaoImpl();
    @Override
    public boolean saveReserved(Reserved reserved) throws SQLException, ClassNotFoundException {

           return   reservedDao.save(reserved);
    }
}
