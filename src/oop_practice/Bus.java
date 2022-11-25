package oop_practice;

public class Bus extends PublicTransportation {

    int priceAmount;

    public Bus() {
        this.maxPassengerCount = 30;
        this.currentState = "운행중";
        this.price = 1000;
        this.priceAmount = 0;
    }

    public int getPriceAmount() {
        return priceAmount;
    }

    @Override
    public void setFuelAmount(int fuelAmount) {
        if (this.fuelAmount + fuelAmount < 10) {
            System.out.println("주유가 필요합니다.");
            this.currentState = "차고지행";
        }
        this.fuelAmount += fuelAmount;

    }

    // 탑승 구현: boardState > true, 하차 구현: boardState > false
    public void setCurrentPassengerCount(int passenger, boolean boardState) {

        if (!this.currentState.equals("운행중")) {
            System.out.println("현재 운행중이 아닙니다.");
        }else{
            if (boardState && currentPassengerCount + passenger <= maxPassengerCount) {
                this.currentPassengerCount += passenger;
                this.priceAmount += price * passenger;
            } else if (!boardState) {
                this.currentPassengerCount -= passenger;
                this.priceAmount = 0;
            } else {
                System.out.println("최대 승객 수 초과");
            }
        }
    }

    public void setPriceAmount(int passenger) {
        this.priceAmount += price * passenger;
    }


}

