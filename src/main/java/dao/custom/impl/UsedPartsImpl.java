package dao.custom.impl;

import dao.UsedPartsDao;
import entity.UsedParts;

import java.sql.SQLException;
import java.util.List;

public class UsedPartsImpl implements UsedPartsDao {
    @Override
    public boolean save(UsedParts entity) throws SQLException, ClassNotFoundException {
        return false;
    }

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
}
