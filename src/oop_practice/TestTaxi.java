package oop_practice;

public class TestTaxi {

    public static void main(String[] args) {

        System.out.println("=========== 택시 2대 생성 ===========");
        Taxi taxi1 = new Taxi();
        Taxi taxi2 = new Taxi();

        System.out.println(taxi1.getNumber());
        System.out.println(taxi2.getNumber());


        System.out.println("=========== 택시 운행 시작 ===========");
        taxi1.run(2, "서울역", 2);
        System.out.println("탑승 승객 수 = " + taxi1.getCurrentPassengerCount());
        System.out.println("잔여 승객 수 = " + taxi1.remain());
        System.out.println("기본 요금 확인 = " + taxi1.getMinimumRate());
        System.out.println("목적지 = " + taxi1.getDestination());
        System.out.println("목적지까지 거리 = " + taxi1.getDistanceToDestination());
        System.out.println("지불할 요금 = " + taxi1.calculateCharge());
        System.out.println("상태 = " + taxi1.getCurrentState());

        System.out.println("=========== 주유량 변경 ===========");
        taxi1.setFuelAmount(-80);
        System.out.println(taxi1.getFuelAmount());
        System.out.println("누적요금 = " + taxi1.getPrice());

        System.out.println("=========== 승객 수 초과 ===========");
        taxi1.run(5, null, 0);

        System.out.println("=========== 택시 운행 시작 ===========");
        taxi1.run(3, "구로디지털단지역", 12);
        System.out.println("탑승 승객 수 = " + taxi1.getCurrentPassengerCount());
        System.out.println("잔여 승객 수 = " + taxi1.remain());
        System.out.println("기본 요금 확인 = " + taxi1.getMinimumRate());
        System.out.println("목적지 = " + taxi1.getDestination());
        System.out.println("목적지까지 거리 = " + taxi1.getDistanceToDestination());
        System.out.println("지불할 요금 = " + taxi1.calculateCharge());


        System.out.println("=========== 주유량 변경 ===========");
        taxi1.setFuelAmount(-20);
        System.out.println("주유량 = " + taxi1.getFuelAmount());
        System.out.println("상태 = " + taxi1.getCurrentState());
        System.out.println("누적 요금 = " + taxi1.price);


    }
}
