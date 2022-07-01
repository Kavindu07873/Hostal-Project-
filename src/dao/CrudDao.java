package dao;

import Entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T extends Entity.SuperEntity,ID>{

    List<T> loadAll() throws SQLException, ClassNotFoundException;

    boolean save(T student)throws  SQLException , ClassNotFoundException ;
    public  boolean delete(ID id) throws Exception;

    boolean update(Student student);
}

