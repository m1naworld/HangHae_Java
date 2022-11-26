package oop_practice;

public class PublicTransportation {

    private static int num = 0;
    protected int number;
    protected int maxPassengerCount;
    protected int currentPassengerCount = 0;
    protected int price;
    protected int fuelAmount = 100;
    protected int currentSpeed = 0;
    protected String currentState;


    public PublicTransportation(int maxPassengerCount, int price, String currentState) {
        this.number = num + 1;
        this.maxPassengerCount = maxPassengerCount;
        this.price = price;
        this.currentState = currentState;
    }

    public PublicTransportation() {
        num += 1;
        this.number = num;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMaxPassengerCount() {
        return maxPassengerCount;
    }

    public void setMaxPassengerCount(int maxPassengerCount) {
        this.maxPassengerCount = maxPassengerCount;
    }

    public int getCurrentPassengerCount() {
        return currentPassengerCount;
    }

    public void setCurrentPassengerCount(int currentPassengerCount) {
        this.currentPassengerCount = currentPassengerCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int speed) {
        if (this.fuelAmount < 10) {
            System.out.println("주유량을 확인해 주세요!");
        } else {
            this.currentSpeed += speed;
        }
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    // 잔여 승객 계산 메소드
    public int remain(){
        return this.maxPassengerCount - this.currentPassengerCount;
    }
}
