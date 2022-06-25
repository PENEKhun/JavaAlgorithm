package com.company;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

//    int[] fees = {180, 5000, 10, 600};
//    String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

    public static List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Fee fee = new Fee(fees);
        Records recordList = new Records(records);

//        System.out.println(fee);
//        System.out.println(recordList);

        CarList carList = new CarList();
        recordList.items.stream()
                .map(Record::getCarNum)
                .filter(carList::isNewCarNum)
                .forEach(carList::addNewCar);

        for (Car car : carList.carList) {
            car.setParkingTime(recordList.getParkingTime(car.carNum));
            car.payFee(fee);
        }


        carList.carList.sort(Comparator.naturalOrder());
        answer = carList.carList.stream()
                .map(Car::getFee)
                .collect(Collectors.toList());

        return answer;
    }

    static class Fee{
        int defaultTime;
        int defaultFee;
        int unitTime;
        int unitFee;

        public Fee(int[] fees) {
            this.defaultTime = fees[0];
            this.defaultFee = fees[1];
            this.unitTime = fees[2];
            this.unitFee = fees[3];
        }

        @Override
        public String toString() {
            return "Fee{" +
                    "defaultTime=" + defaultTime +
                    ", defaultFee=" + defaultFee +
                    ", unitTime=" + unitTime +
                    ", unitFee=" + unitFee +
                    '}';
        }
    }

    static class Records {
        List<Record> items;

        @Override
        public String toString() {
            return "Records{" +
                    "recordList=" + items +
                    '}';
        }

        public Records(String[] records) {
            this.items = new ArrayList<>();
            for (String record : records) {
                Record item = new Record(record);
                this.items.add(item);
            }
        }

        public int getParkingTime(String carNumber) {
            Status findStatus = Status.IN;
            String startAt = "";
            String endAt = "";
            int totalTime = 0;
            for (Record item : this.items) {
                if (item.carNum.equals(carNumber) && item.status.equals(findStatus)) {
                    if (findStatus.equals(Status.IN)) {
                        startAt = item.time;
                        findStatus = Status.OUT;
                    } else {
                        endAt = item.time;
                        findStatus = Status.IN;
                        totalTime += Record.diffTime(startAt, endAt);
                        startAt = "";
                        endAt = "";
                    }
                }
            }
            if (!startAt.equals("") && endAt.equals("")){
                // 입차 했으나, 출차 기록이 없을경우
                endAt = "23:59";
                totalTime += Record.diffTime(startAt, endAt);
            }
            return totalTime;
        }
    }

    static class Record {
        String time;
        String carNum;
        Status status;

        public Record(String record) {
            this.time = record.split(" ")[0];
            this.carNum = record.split(" ")[1];
            this.status = Status.valueOf(record.split(" ")[2]);
        }

        public String getCarNum() {
            return carNum;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "time=" + time +
                    ", carNum='" + carNum + '\'' +
                    ", status=" + status +
                    '}';
        }

        static int diffTime(String startAt, String endAt) {
            try {
                SimpleDateFormat f = new SimpleDateFormat("HH:mm", Locale.KOREA);
                Date d1 = f.parse(startAt);
                Date d2 = f.parse(endAt);
                long diff = d2.getTime() -d1.getTime();
                return (int) (diff / 60000);
            } catch (Exception e){
                System.out.println("idc");
            }
            return 0;
        }
    }

    enum Status {
        IN(0), OUT(1);

        final int value;

        Status(int value) {
            this.value = value;
        }

    }

    static class CarList{
        List<Car> carList;

        @Override
        public String toString() {
            return "CarList{" +
                    "carList=" + carList +
                    '}';
        }

        public CarList() {
            this.carList = new ArrayList<>();
        }

        public void addNewCar(String carNum) {
            Car car = new Car(carNum);
            this.carList.add(car);
        }

        public boolean isNewCarNum(String carNum) {
            return carList.stream().noneMatch(car -> car.carNum.equals(carNum));
        }


    }
    static class Car implements Comparable<Car>{
        String carNum;
        int parkingTime;
        int fee;

        public int getFee() {
            return fee;
        }

        public String getCarNum() {
            return carNum;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "carNum='" + carNum + '\'' +
                    ", parkingTime=" + parkingTime +
                    ", fee=" + fee +
                    '}';
        }

        public Car(String carNum) {
            this.carNum = carNum;
            this.parkingTime = 0;
            this.fee = 0;
        }

        public void setParkingTime(int parkingTime) {
            this.parkingTime = parkingTime;
        }

        public void payFee(Fee fee) {
            if (fee.defaultTime >= parkingTime){
                this.fee = fee.defaultFee;
            } else {
                int overTime = parkingTime - fee.defaultTime;
                double calUnitTime = Math.floor(((overTime) % fee.unitTime == 0) ? overTime / fee.unitTime + 0 : overTime / fee.unitTime + 1);
                this.fee = (int) (fee.defaultFee + (calUnitTime * fee.unitFee));
            }
        }

        @Override
        public int compareTo(Car arg0){
            int targetCar = Integer.parseInt(arg0.getCarNum());
            int thisCar = Integer.parseInt(carNum);
            return Integer.compare(thisCar, targetCar);
        }
    }

}