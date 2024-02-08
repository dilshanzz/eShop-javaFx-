package dao.custom;

import dao.CrudDao;
import entity.Auser;

public interface AuserDao extends CrudDao<Auser> {
    void updatePassword(String email, String np);
}
