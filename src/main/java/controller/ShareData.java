package controller;

public class ShareData {
    public static String oId;

    public static void setOrderId( String id){
        oId = id;
    }
    public static String getOrderId(){
        return oId;
    }
}
