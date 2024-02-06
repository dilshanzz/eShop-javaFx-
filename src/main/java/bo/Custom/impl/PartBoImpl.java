package bo.Custom.impl;

import bo.Custom.PartBo;
import dao.DaoFactory;
import dao.custom.PartDao;
import dao.util.DaoType;
import dto.OrderDto;
import dto.PartDto;
import entity.Part;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PartBoImpl implements PartBo {

    PartDao partDa0 = DaoFactory.getInstance().getDao(DaoType.PART);
    @Override
    public List<PartDto> allParts() throws SQLException, ClassNotFoundException {
        List<Part> list1 = partDa0.getAll();
        List<PartDto> list = new ArrayList<>();

        for (Part part: list1) {
//            list.add(new PartDto(
//                    part.getCode(),
//                    part.getName(),
//                    part.getPrice()
//            ));
            PartDto dto = new PartDto(
                    part.getCode(),
                    part.getName(),
                    part.getPrice()
            );
            list.add(dto);

        }
        return list;
    }

    @Override
    public boolean save(PartDto dto) throws SQLException, ClassNotFoundException {
        return partDa0.save(new Part(
               dto.getCode(),
               dto.getName(),
               dto.getPrice()
        ));
    }

    @Override
    public boolean update(PartDto dto) throws SQLException, ClassNotFoundException {
        return partDa0.update(new Part(
                dto.getCode(),
                dto.getName(),
                dto.getPrice()
        ));
    }

    @Override
    public boolean deletePart(String code) throws SQLException, ClassNotFoundException {
        return partDa0.delete(code);
    }

    @Override
    public boolean saveOrderPart(OrderDto orderDto) {
        return false;
    }

}
