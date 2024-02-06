package bo;

import bo.Custom.impl.*;
import dao.util.BoType;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){}

    public static BoFactory getInstance(){
        return boFactory!=null ? boFactory : (boFactory = new BoFactory());
    }
    public <T extends SuperBo>T getBo(BoType type){
        switch (type){
            case USER: return  (T) new UserBoImpl();
            case CUSTOMER:return  (T)new CustomerBoImpl();
            case ORDER:return (T) new OrderBoImpl();
            case PART:return  (T) new PartBoImpl();
            case AUSER: return (T) new AuserBoImpl();
            case ITEM:return (T) new ItemBompl();
//            case ORDERDATA:return (T) new OrderDataBoImpl();
            case USEDPARTS:return (T) new UsedPartsBoImpl();
//            case REPORTS:return null;
        }
        return null;
    }


}
