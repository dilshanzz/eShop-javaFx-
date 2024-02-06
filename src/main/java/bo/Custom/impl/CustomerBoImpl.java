package bo.Custom.impl;

import bo.Custom.CustomerBo;
import dao.DaoFactory;
import dao.custom.CustomerDao;
import dao.custom.impl.CustomerDaoImpl;
import dao.util.DaoType;
import dto.CustomerDto;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao = DaoFactory.getInstance().getDao(DaoType.CUSTOMER);

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }

    @Override
    public boolean save(CustomerDto dto) throws SQLException, ClassNotFoundException {
        try {
            customerDao.save(new Customer(
                    dto.getContact(),
                    dto.getEmail(),
                    dto.getName()
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }
    @Override
    public List<CustomerDto> allCustomers() throws SQLException, ClassNotFoundException {
        List<Customer> list = customerDao.getAll();
        List<CustomerDto> customerList = new ArrayList<>();
        for (Customer c: list) {
           customerList.add (new CustomerDto(
                    c.getId(),
                    c.getMail(),
                    c.getName()
            ));

        }
        return customerList;
    }
    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        customerDao.update(new Customer(
                dto.getContact(),
                dto.getEmail(),
                dto.getName()
        ));
        return true;
    }
}