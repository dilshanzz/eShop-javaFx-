package bo.Custom;

import bo.SuperBo;
import dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemBo extends SuperBo {
    List<ItemDto> allItems() throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDto itemDto) throws SQLException, ClassNotFoundException;

    boolean saveItem(ItemDto itemDto) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String name) throws SQLException, ClassNotFoundException;
}
