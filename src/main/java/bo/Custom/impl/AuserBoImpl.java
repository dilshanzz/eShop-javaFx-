package bo.Custom.impl;

import bo.Custom.AuserBo;
import dao.DaoFactory;
import dao.custom.AuserDao;
import dao.util.DaoType;
import dto.AuserDto;
import entity.Auser;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuserBoImpl implements AuserBo {

    AuserDao auserDao = DaoFactory.getInstance().getDao(DaoType.AUSER);
    @Override
    public List<AuserDto> allAdmins() throws SQLException, ClassNotFoundException {
        List<AuserDto> list = new ArrayList<>();
        List<Auser> list1 = auserDao.getAll();
        for (Auser user: list1) {
            list.add(new AuserDto(
                    user.getMail(),
                    user.getName(),
                    user.getPassword()
            ));
        }
        return list;
    }

    @Override
    public boolean deleteAdmin(String mail) throws SQLException, ClassNotFoundException {
        return auserDao.delete(mail);
    }

    @Override
    public boolean saveAdmin(AuserDto dto) throws SQLException, ClassNotFoundException {
        auserDao.save(new Auser(
                dto.getMail(),
                dto.getName(),
                dto.getPassword()
        ));
        return true;
    }

}
