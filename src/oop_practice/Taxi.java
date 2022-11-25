package oop_practice;


public class Taxi extends PublicTransportation{

    String destination;
    int distanceToDestination; // 단위 km
    int basicDistance; // 단위 km

    int minimumRate;
    int ratePerDistance;

    public Taxi() {
        this.maxPassengerCount = 4;
        this.minimumRate = 3000;
        this.fuelAmount = 100;
        this.currentSpeed = 0;
        this.currentState = "일반";
        this.basicDistance = 1;
        this.ratePerDistance = 1000;
    }


    // getter & Setter
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public String getDistanceToDestination() {
        return distanceToDestination + "km";
    }


    public void setDistanceToDestination(int distanceToDestination) {
        this.distanceToDestination = distanceToDestination;
    }


    public String getBasicDistance() {
        return basicDistance + "km";
    }

    public void setBasicDistance(int basicDistance) {
        this.basicDistance = basicDistance;
    }

    public int getMinimumRate() {
        return minimumRate;
    }

    public void setMinimumRate(int minimumRate) {
        this.minimumRate = minimumRate;
    }

    public int getRatePerDistance() {
        return ratePerDistance;
    }

    public void setRatePerDistance(int ratePerDistance) {
        this.ratePerDistance = ratePerDistance;
    }

    @Override
    public void setFuelAmount(int fuelAmount) {
        if (this.fuelAmount + fuelAmount < 10) {
            System.out.println("주유가 필요합니다.");
            this.currentState = "운행불가";
        }
        this.fuelAmount += fuelAmount;

    }

    // 운행 시작 메소드
    public void run(int passenger, String destination, int distanceToDestination){
        if(passenger <= this.maxPassengerCount){
            this.currentPassengerCount = passenger;
            this.destination = destination;
            this.distanceToDestination = distanceToDestination;
            this.currentState = "운행중";
        }else{
            System.out.println("최대 승객 수 초과");
        }

    }

    // 지불 금액 계산 메소드
    public int calculateCharge(){
        int charge = this.minimumRate + this.ratePerDistance * (this.distanceToDestination - this.basicDistance);
        this.price += charge;
        return charge;
    }

}
