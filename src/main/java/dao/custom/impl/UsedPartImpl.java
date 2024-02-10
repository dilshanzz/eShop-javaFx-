package dao.custom.impl;

import dao.custom.UsedPartDao;
import entity.Part;
import entity.UsedParts;

import java.sql.SQLException;
import java.util.List;

public class UsedPartImpl implements UsedPartDao {


    @Override
    public boolean update(UsedParts entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<UsedParts> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(UsedParts part) throws SQLException {
        return false;
    }
}