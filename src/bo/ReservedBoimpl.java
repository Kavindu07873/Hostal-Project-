package bo;

import Entity.Reserved;
import dao.ReservedDaoImpl;

import java.sql.SQLException;

public class ReservedBoimpl implements  ReservedBo {
    ReservedDaoImpl reservedDao = new ReservedDaoImpl();
    @Override
    public boolean saveReserved(Reserved reserved) throws SQLException, ClassNotFoundException {
        System.out.println("mkd lede");
           return   reservedDao.save(reserved);
    }
}
