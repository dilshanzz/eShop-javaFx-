package dao;

import bo.Custom.impl.CustomerBoImpl;
import dao.custom.CustomerDao;
import dao.custom.impl.*;
import dao.util.DaoType;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory (){}

    public static DaoFactory getInstance(){
        return  daoFactory!=null ? daoFactory : (daoFactory=new DaoFactory());
    }

    public <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case USER: return (T) new UserDaoImpl();
            case CUSTOMER: return (T) new CustomerDaoImpl();
           // case ORDER: return (T) new OrderDaoImpl();
            case PART: return (T) new PartDaoImpl();
            case AUSER: return (T) new AuserDaoImpl();
            case ITEM: return (T) new ItemDaoImpl();
//            case ORDERDATA:return (T) new OrderDataDaoImpl();
            case USEDPARTS:return (T) new UsedPartsImpl();
//            case INVENTORY:return null;
        }
        return null;
    }
}
