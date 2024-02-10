package bo.Custom.impl;

import bo.Custom.UsedPartsBo;
import dao.DaoFactory;
import dao.custom.UsedPartDao;
import dao.util.DaoType;
import dto.UsedPartsDto;
import entity.UsedParts;

import java.sql.SQLException;

public class UsedPartsBoImpl implements UsedPartsBo {
    UsedPartDao usedPartDao = DaoFactory.getInstance().getDao(DaoType.USEDPARTS);

    @Override
    public boolean save(UsedPartsDto dto) throws SQLException {
        return usedPartDao.save(new UsedParts(
                dto.getCode(),
                dto.getQty(),
                dto.getPrice()
        ));
    }
}
