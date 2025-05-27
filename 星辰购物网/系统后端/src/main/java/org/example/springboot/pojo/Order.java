package org.example.springboot.pojo;

public class Order {
    public int getOrderok() {
        return orderok;
    }

    public void setOrderok(int orderok) {
        this.orderok = orderok;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderuser() {
        return orderuser;
    }

    public void setOrderuser(String orderuser) {
        this.orderuser = orderuser;
    }

    public String getOrdershop() {
        return ordershop;
    }

    public void setOrdershop(String ordershop) {
        this.ordershop = ordershop;
    }

    public int getOrdersend() {
        return ordersend;
    }

    public void setOrdersend(int ordersend) {
        this.ordersend = ordersend;
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    @Override
    public String toString() {
        return "order{" +
                "orderid='" + orderid + '\'' +
                ", orderuser='" + orderuser + '\'' +
                ", ordershop='" + ordershop + '\'' +
                ", ordersend=" + ordersend +
                ", orderok=" + orderok +
                ", ordername='" + ordername + '\'' +
                ", ordernumber=" + ordernumber +
                '}';
    }

    private String orderid;
    private String orderuser;
    private String ordershop;
    private int ordersend;
    private int orderok;
    private String ordername;
    private int ordernumber;


}
