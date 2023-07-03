package org.prog.manager;

public class Car {

    private final String serialNumber;
    private String plateNumber;

    public Car(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSerialNumber() {
        return this.serialNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public String toString() {
        return "S/N " + serialNumber + " . Plates : " + plateNumber;
    }
}
