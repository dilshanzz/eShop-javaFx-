package bo.Custom.impl;

import bo.Custom.ItemBo;
import dao.DaoFactory;
import dao.custom.ItemDao;
import dao.util.DaoType;
import dto.ItemDto;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBompl implements ItemBo {

    ItemDao itemDao = DaoFactory.getInstance().getDao(DaoType.ITEM);

    @Override
    public List<ItemDto> allItems() throws SQLException, ClassNotFoundException {
        List<Item> list1 = itemDao.getAll();
        List<ItemDto> list = new ArrayList<>();
        for (Item item:list1) {
            list.add(new ItemDto(
                    item.getName(),
                    item.getCategory(),
                    item.getQuantity()
            ));
        }
        return list;

    }

    @Override
    public boolean updateItem(ItemDto itemDto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new Item(
                itemDto.getName(),
                itemDto.getCategory(),
                itemDto.getQuantity()
        ));
    }

    @Override
    public boolean saveItem(ItemDto itemDto) throws SQLException, ClassNotFoundException {
        return itemDao.save(new Item(
                itemDto.getName(),
                itemDto.getCategory(),
                itemDto.getQuantity()
        ));
    }

    @Override
    public boolean deleteItem(String name) throws SQLException, ClassNotFoundException {
        return itemDao.delete(name);
    }
}
