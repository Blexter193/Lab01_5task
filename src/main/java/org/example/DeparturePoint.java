package org.example;

public class DeparturePoint {
    private DeliveryDepartment deliveryDepartment;
    public DeparturePoint(DeliveryDepartment deliveryDepartment){
        this.deliveryDepartment = deliveryDepartment;
    }
    public double getMaxWeight(){
        return  deliveryDepartment.getMaxWeight();
    }
    public String getAddress(){
        return deliveryDepartment.getAddress();
    }
}
