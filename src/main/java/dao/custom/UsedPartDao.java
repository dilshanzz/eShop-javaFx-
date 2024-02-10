package dao.custom;

import dao.CrudDao;
import entity.Part;
import entity.UsedParts;

import java.sql.SQLException;

public interface UsedPartDao extends CrudDao<UsedParts> {

    boolean save(UsedParts part) throws SQLException;
}
