//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class TaxiBooking {
//
//    public static void main(String[] args) {
//
//        boolean runApp = true;
//
//        Scanner s = new Scanner(System.in);
//        int taxiCt = 4;
//        List<Booking> bookingList = new ArrayList<>();
//        Taxi[] taxis = new Taxi[taxiCt];
//        createTaxis(taxis);
//
//        System.out.println("Welcome to XOLO Taxi");
//        while (runApp) {
//
//            System.out.println("Please Select any one of the choice");
//            System.out.println("1. Book a Taxi");
//            System.out.println("2. Exit");
//
//            int choice = s.nextInt();
//            switch (choice) {
//                case 1 -> TaxiApp.addBooking(taxis, taxiCt, bookingList);
//                case 2 -> runApp = false;
//                default -> System.out.println("Please enter a valid choice");
//            }
//
//
//        }
//
//    }
//
//    private static void createTaxis(Taxi[] taxis) {
//        for (int i = 0; i < taxis.length; i++) {
//            taxis[i] = new Taxi();
//        }
//    }
//
//}
//
//class Taxi {
//    int taxiId;
//    int totalEarnings;
//    char currentPosition;
//    int tripStartTime;
//    int tripEndTime;
//
//    public void setTripStartTime(int tripStartTime) {
//        this.tripStartTime = tripStartTime;
//    }
//
//    public void setTripEndTime(int tripEndTime) {
//        this.tripEndTime = tripEndTime;
//    }
//
//    public Taxi() {
//        this.taxiId = Util.getUpdatedTaxiId();
//        this.totalEarnings = 0;
//        this.currentPosition = 'a';
//        tripStartTime = Integer.MAX_VALUE;
//        tripEndTime = Integer.MAX_VALUE;
//    }
//
//    public void changeAvailability(int pickupTime, char pickupPoint, char dropPoint) {
//        int dropTime = pickupTime + Math.abs(dropPoint - pickupPoint);
//        setTripStartTime(pickupTime);
//        setTripEndTime(dropTime);
//        currentPosition = dropPoint;
//    }
//
//    public boolean isTaxiFree(int pickupTime, char pickupPoint, char dropPoint) {
//        int tripTime = TaxiApp.getTripTime(pickupPoint, dropPoint) + pickupTime;
//        System.out.println("Taxi ID " + taxiId + " Start time " + tripStartTime + " End time " + tripEndTime);
//        return pickupPoint < tripStartTime && tripTime < tripEndTime;
//    }
//
//}
//
//class TaxiApp {
//    static Scanner s = new Scanner(System.in);
//
//    static int customerId;
//    static char pickupPoint;
//    static char dropPoint;
//    static int pickupTime;
//
//    static int getTripTime(char pickupPoint, char dropPoint) {
//        return Math.abs(dropPoint - pickupPoint);
//    }
//
//    static void addBooking(Taxi[] taxis, int taxiCount, List<Booking> bookingList) {
//        System.out.println("Enter your customer Id");
//        customerId = s.nextInt();
//        System.out.println("Enter your Pickup point (a-f)");
//        pickupPoint = s.next().charAt(0);
//        System.out.println("Enter your Dropping point (a-f)");
//        dropPoint = s.next().charAt(0);
//        System.out.println("Enter your pickup Time");
//        pickupTime = s.nextInt();
//
//        Booking currentBooking = new Booking(Util.getUpdatedBookingId(), customerId, pickupPoint, dropPoint, pickupTime, -1);
//        Taxi allotedTaxi = checkForAvailability(pickupPoint, dropPoint, pickupTime, taxis, taxiCount);
//        if (allotedTaxi != null) {
//            currentBooking.taxiId = allotedTaxi.taxiId;
//            bookingList.add(currentBooking);
//            System.out.println("Your booking is confirmed and the Taxi allocated is " + allotedTaxi.taxiId);
//            allotedTaxi.changeAvailability(pickupTime, pickupPoint, dropPoint);
//            allotedTaxi.totalEarnings += calculateEarnings(pickupPoint, dropPoint);
//        } else {
//            System.out.println("Sorry! No Taxis available at your pickup location");
//        }
//
//    }
//
//    public static int calculateEarnings(char pickupPoint, char dropPoint) {
//        return (((getTripTime(pickupPoint, dropPoint) * 15) - 5) * 10) + 100;
//    }
//
//    private static Taxi checkForAvailability(char pickupPoint, char dropPoint, int pickupTime, Taxi[] taxis, int taxiCount) {
//
//        int allotedTaxiId = -1;
//        Taxi allotedTaxi;
//        int shortestDistance = -1;
//
//        for (int taxi = 0; taxi < taxiCount; taxi++) {
//            if (taxis[taxi].isTaxiFree(pickupTime, pickupPoint, dropPoint)) {
//                System.out.println("Taxi " + taxis[taxi].taxiId + " is Free ");
//                if (taxis[taxi].currentPosition == pickupPoint) {
//                    if (allotedTaxiId == -1) {
//                        allotedTaxiId = taxi;
//                    } else if (shortestDistance != -1) {
//                        allotedTaxiId = taxi;
//                        shortestDistance = -1;
//                    } else {
//                        if (taxis[allotedTaxiId].totalEarnings > taxis[taxi].totalEarnings) {
//                            allotedTaxiId = taxi;
//                        }
//                    }
//                } else {
//                    shortestDistance = Math.abs(taxis[taxi].currentPosition - pickupPoint);
//                    allotedTaxiId = taxi;
//                }
//            }
//        }
//
//        if (allotedTaxiId == -1) {
//            return null;
//        }
//        System.out.println(allotedTaxiId);
//        allotedTaxi = taxis[allotedTaxiId];
//        return allotedTaxi;
//
//    }
//}
//
//class Booking {
//    int bookingId;
//    int customerId;
//    char pickupPoint;
//    char dropPoint;
//    int timings;
//    int taxiId;
//
//    public Booking(int bookingId, int customerId, char pickupPoint, char dropPoint, int timings, int taxiId) {
//        this.bookingId = bookingId;
//        this.customerId = customerId;
//        this.pickupPoint = pickupPoint;
//        this.dropPoint = dropPoint;
//        this.timings = timings;
//        this.taxiId = taxiId;
//    }
//}
//
//class Util {
//    private static int taxiId = 1;
//    private static int bookingId = 1;
//
//    static int getUpdatedTaxiId() {
//        return taxiId++;
//    }
//
//    static int getUpdatedBookingId() {
//        return bookingId++;
//    }
//
//
//}
//
//enum BookingStatus {
//    BOOKING_CONFIRMED,
//    BOOKING_REJECTED
//}