package org.example;

public class DeliveryDepartment {
    private String address;
    private boolean isAvailableForTruck;
    private boolean isAvailableForTrain;
    private boolean isAvailableForBus;

    private boolean isAvailableForCourieer;


    public DeliveryDepartment(String address, boolean isAvailableForTruck, boolean isAvailableForTrain, boolean isAvailableForBus) {
        if (address.isEmpty()) {
            throw new IllegalArgumentException("emptyadress");
        }

        this.address = address;
        this.isAvailableForTruck = isAvailableForTruck;
        this.isAvailableForTrain = isAvailableForTrain;
        this.isAvailableForBus = isAvailableForBus;
        this.isAvailableForCourieer = isAvailableForCourieer;
    }

    public double getMaxWeight() {
        if (isAvailableForTrain) return 1000;
        if (isAvailableForTruck) return 500;
        if (isAvailableForBus) return 100;
        if (isAvailableForCourieer) return 30;
        return 0;
    }

    public String getAddress() {
        return address;
    }
}
