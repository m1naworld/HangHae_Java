package oop_practice;

public class TestBus {
    public static void main(String[] args) {

        System.out.println("=========== 버스 2대 생성 ===========");
        Bus a = new Bus();
        Bus b = new Bus();

        // 각 버스의 번호 출력
        System.out.println(a.getNumber());
        System.out.println(b.getNumber());


        System.out.println("=========== 승객 2명 탑승 ===========");
        int passenger = 2;
        a.setCurrentPassengerCount(passenger, true);
        System.out.println("탑승 승객 수 = " + a.getCurrentPassengerCount()); // 탑승 승객 = 2
        System.out.println("잔여 승객 수 = " + (a.maxPassengerCount - a.currentPassengerCount)); // 잔여 승객 = 28
        System.out.println("요금 확인 = " + a.getPriceAmount()); // 요금 확인


        System.out.println("=========== 주유량 변경 ===========");
        // 주유량 - 50
        a.setFuelAmount(-50);
        System.out.println("주유량 = " + a.getFuelAmount());


        System.out.println("=========== 버스 상태 변경 ===========");
        a.setCurrentState("차고지행");
        System.out.println("상태 = " + a.getCurrentState());


        System.out.println("=========== 주유량 변경 ===========");
        // 주유량 + 10
        a.setFuelAmount(10);
        System.out.println("주유량 = " + a.getFuelAmount());


        System.out.println("=========== 버스 상태 변경 ===========");
        // 상태 운행중으로 변경
        a.setCurrentState("운행중");
        System.out.println("상태 = " + a.getCurrentState());


        System.out.println("=========== 승객 초과일 때 ===========");
        // 승객 + 45
        int passenger1 = 45;
        a.setCurrentPassengerCount(passenger, false); // 기존 2명 하차 및 요금 초기화
        a.setCurrentPassengerCount(passenger1, true);
        System.out.println(a.getCurrentPassengerCount()); // 승객 45명 적용 안된걸 확인할 수 있음


        System.out.println("=========== 기존 2명 하차후 5명 탑승 ===========");
        // 승객 + 5
        int passenger2 = 5;
        a.setCurrentPassengerCount(passenger2, true);
        System.out.println("탑승 승객 수 = " + a.getCurrentPassengerCount());
        System.out.println("잔여 승객 수 = " + (a.getMaxPassengerCount() - a.getCurrentPassengerCount()));
        System.out.println("요금 = " + a.getPriceAmount()); // 요금 확인


        System.out.println("=========== 주유량 10미중 일때 ===========");
        // 주유량 -55
        a.setFuelAmount(-55);
        System.out.println("주유량 = " + a.getFuelAmount());
        System.out.println("상태 = " + a.getCurrentState());
    }
}
