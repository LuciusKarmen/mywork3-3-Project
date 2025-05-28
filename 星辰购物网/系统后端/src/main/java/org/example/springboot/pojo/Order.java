package org.example.springboot.pojo;

public class Order {

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
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

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername;
    }

    public Boolean getOrderCar() {
        return orderCar;
    }

    public void setOrderCar(Boolean orderCar) {
        this.orderCar = orderCar;
    }

    public Boolean getOrderSend() {
        return orderSend;
    }

    public void setOrderSend(Boolean orderSend) {
        this.orderSend = orderSend;
    }

    public Boolean getOrderOk() {
        return orderOk;
    }

    public void setOrderOk(Boolean orderOk) {
        this.orderOk = orderOk;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", orderuser='" + orderuser + '\'' +
                ", ordershop='" + ordershop + '\'' +
                ", ordername='" + ordername + '\'' +
                ", ordernumber=" + ordernumber +
                ", orderCar=" + orderCar +
                ", orderSend=" + orderSend +
                ", orderOk=" + orderOk +
                '}';
    }

    private String orderid;
    private String orderuser;
    private String ordershop;
    private String ordername;
    private int ordernumber;
    private Boolean orderCar;
    private Boolean orderSend;
    private Boolean orderOk;


}
