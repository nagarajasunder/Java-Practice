
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainTicketBooking {


    public static void main(String[] args) {

        TicketBookingApp app = new TicketBookingApp(1, 1, 1, 1, 1);
        app.start();
    }


}

class Ticket {

    int passengerId;
    Berth berthPreference;
    TicketStatus ticketStatus;
    private final int age;
    String passengerName;
    String ticketNumber;

    public Ticket(int passengerId, Berth berthPreference, TicketStatus ticketStatus, int age, String passengerName, String ticketNumber) {
        this.passengerId = passengerId;
        this.berthPreference = berthPreference;
        this.ticketStatus = ticketStatus;
        this.age = age;
        this.passengerName = passengerName;
        this.ticketNumber = ticketNumber;
    }


}

enum TicketStatus {
    CONFIRM,
    RAC,
    WAITING_LIST
}

enum Berth {
    LOWER,
    MIDDLE,
    UPPER
}

class TicketBookingApp {


    boolean quit = false;

    private int lowerCt;
    private int middleCt;
    private int upperCt;
    private int passengerId;
    private int racCt;
    private int waitingListCt;

    private int lowerBerthNumber;
    private int middleBerthNumber;
    private int upperBerthNumber;


    private final List<Ticket> bookingList = new ArrayList<>();
    private final List<Ticket> racList = new ArrayList<>();
    private final List<Ticket> waitingList = new ArrayList<>();

    public TicketBookingApp(int lowerCt, int middleCt, int upperCt, int racCt, int waitingListCt) {
        this.lowerCt = lowerCt;
        this.middleCt = middleCt;
        this.upperCt = upperCt;
        this.racCt = racCt;
        this.waitingListCt = waitingListCt;
        this.passengerId = 1;
        lowerBerthNumber = 1;
        middleBerthNumber = 1;
        upperBerthNumber = 1;
    }


    public int getLowerCt() {
        return lowerCt;
    }

    public int getMiddleCt() {
        return middleCt;
    }

    public int getUpperCt() {
        return upperCt;
    }

    public int getPassengerId() {
        return passengerId++;
    }

    private void updateWaitingListCt() {
        --this.waitingListCt;
    }

    private void updateRacCt() {
        --this.racCt;
    }

    public int getWaitingListCt() {
        return waitingListCt;
    }

    public int getRacCt() {
        return racCt;
    }

    public String getLowerBerthNumber() {
        if (getLowerCt() > 0) {
            return lowerBerthNumber++ + "L";
        }
        return null;
    }

    public String getMiddleBerthNumber() {
        if (getMiddleCt() > 0) {
            return middleBerthNumber++ + "M";
        }
        return null;
    }

    public String getUpperBerthNumber() {

        if (getUpperCt() > 0) {
            return upperBerthNumber++ + "U";
        }
        return null;
    }

    public void addToBooking(Ticket ticket) {
        bookingList.add(ticket);
        reduceBerthCount(ticket.berthPreference);
    }

    public void setLowerCt(int lowerCt) {
        this.lowerCt = lowerCt;
    }

    public void setMiddleCt(int middleCt) {
        this.middleCt = middleCt;
    }

    public void setUpperCt(int upperCt) {
        this.upperCt = upperCt;
    }

    private void reduceBerthCount(Berth berthPreference) {
        switch (berthPreference) {
            case LOWER -> setLowerCt(getLowerCt() - 1);
            case MIDDLE -> setMiddleCt(getMiddleCt() - 1);
            case UPPER -> setUpperCt(getUpperCt() - 1);
        }
    }

    public List<Ticket> getBookingList() {
        return bookingList;
    }

    private List<Ticket> getRacList() {
        return racList;
    }

    private List<Ticket> getWaitingList() {
        return waitingList;
    }


    public void showBookingList() {
        System.out.println("----------------------------------------------");
        System.out.println("-------------Booking List----------------------");

        List<Ticket> bookingList = getBookingList();
        if (bookingList.isEmpty()) {
            System.out.println("No Tickets are booked");
            System.out.println("----------------------------------------------");
        } else {
            for (Ticket ticket : bookingList) {
                System.out.println("Ticket Number: " + ticket.ticketNumber);
                System.out.println("Passenger Id: " + ticket.passengerId);
                System.out.println("Berth Preference " + ticket.berthPreference.toString());
                System.out.println("----------------------------------------------");
            }
        }
    }

    private void showRacList() {
        System.out.println("----------------------------------------------");
        System.out.println("-------------RAC List-------------------------");

        List<Ticket> bookingList = getRacList();
        if (bookingList.isEmpty()) {
            System.out.println("No Tickets are booked");
            System.out.println("----------------------------------------------");
        } else {
            for (Ticket ticket : bookingList) {
                System.out.println("Ticket Number: " + ticket.ticketNumber);
                System.out.println("Passenger Id: " + ticket.passengerId);
                System.out.println("Berth Preference " + ticket.berthPreference.toString());
                System.out.println("----------------------------------------------");
            }
        }
    }

    private void showWaitingListTicket() {
        System.out.println("----------------------------------------------");
        System.out.println("-------------Waiting List-------------------------");

        List<Ticket> bookingList = getWaitingList();
        if (bookingList.isEmpty()) {
            System.out.println("No Tickets are booked");
            System.out.println("----------------------------------------------");
        } else {
            for (Ticket ticket : bookingList) {
                System.out.println("Ticket Number: " + ticket.ticketNumber);
                System.out.println("Passenger Id: " + ticket.passengerId);
                System.out.println("Berth Preference " + ticket.berthPreference.toString());
                System.out.println("----------------------------------------------");
            }
        }
    }

    Scanner s = new Scanner(System.in);

    private void getPassengerDetails() {

        s.nextLine();
        System.out.println("Enter your name");
        String name = s.nextLine();
        System.out.println("Enter your age");
        int age = s.nextInt();
        s.nextLine();
        System.out.println("Enter your berth preference L/M/U");
        String berth = s.nextLine();

        Berth preference = switch (berth) {
            case "L" -> Berth.LOWER;
            case "M" -> Berth.MIDDLE;
            case "U" -> Berth.UPPER;
            default -> null;
        };

        startBookingProcess(name, age, preference);

    }

    private void startBookingProcess(String name, int age, Berth preference) {
        boolean ticketAvailability = isTicketAvailable();
        if (ticketAvailability) {
            Berth availableBerth = checkBerthAvailability(preference);
            addToConfirmList(name, age, availableBerth);
        } else if (isRacAvailable()) {
            addToRac(name, age, preference);
        } else if (isWaitingListAvailable()) {
            addToWaitingList(name, age, preference);
        } else {
            showNoTickets();
        }


    }

    private void addToConfirmList(String name, int age, Berth availableBerth) {
        Ticket ticket = new Ticket(getPassengerId(), availableBerth, TicketStatus.CONFIRM, age, name, getTicketNumber(availableBerth));
        bookingList.add(ticket);
        reduceBerthCount(availableBerth);
        System.out.println("Your Ticket is Confirmed. Ticket Number " + ticket.ticketNumber);
    }

    private String getTicketNumber(Berth availableBerth) {

        if (availableBerth == Berth.LOWER) {
            return getLowerBerthNumber();
        } else if (availableBerth == Berth.MIDDLE) {
            return getMiddleBerthNumber();
        }
        return getUpperBerthNumber();
    }

    private void addToWaitingList(String name, int age, Berth preference) {
        Ticket ticket = new Ticket(getPassengerId(), preference, TicketStatus.RAC, age, name, null);
        waitingList.add(ticket);
        updateWaitingListCt();
        System.out.println("Your Ticket is added to the Waiting list");
    }

    private void addToRac(String name, int age, Berth preference) {
        Ticket ticket = new Ticket(getPassengerId(), preference, TicketStatus.RAC, age, name, null);
        racList.add(ticket);
        updateRacCt();
        System.out.println("Your Ticket is added to the Rac list");
    }

    private void showNoTickets() {
        System.out.println("----------------------------------");
        System.out.println("No Tickets available");
    }

    private boolean isTicketAvailable() {
        return isLowerAvailable() || isMiddleAvailable() || isUpperAvailable();
    }

    private boolean isRacAvailable() {
        return getRacCt() > 0;
    }

    private boolean isWaitingListAvailable() {
        return getWaitingListCt() > 0;
    }

    private Berth checkBerthAvailability(Berth preference) {

        boolean availability = switch (preference) {
            case LOWER -> isLowerAvailable();
            case MIDDLE -> isMiddleAvailable();
            case UPPER -> isUpperAvailable();
        };
        if (availability) {
            return preference;
        } else {
            return checkOtherAvailability(preference);
        }
    }


    private boolean isLowerAvailable() {
        return getLowerCt() > 0;
    }

    private boolean isMiddleAvailable() {
        return getMiddleCt() > 0;
    }

    private boolean isUpperAvailable() {
        return getUpperCt() > 0;
    }


    private Berth checkOtherAvailability(Berth choice1) {
        if (choice1 == Berth.LOWER) {
            if (isMiddleAvailable()) {
                return Berth.MIDDLE;
            }
            if (isUpperAvailable()) {
                return Berth.UPPER;
            }
            return null;
        } else if (choice1 == Berth.MIDDLE) {
            if (isLowerAvailable()) {
                return Berth.LOWER;
            }
            if (isUpperAvailable()) {
                return Berth.UPPER;
            }
            return null;
        } else {
            if (isLowerAvailable()) {
                return Berth.LOWER;
            }
            if (isMiddleAvailable()) {
                return Berth.MIDDLE;
            }
        }

        return null;
    }


    public void start() {
        System.out.println("Welcome to IXIGO Reservation System");
        while (!quit) {
            System.out.println("Please select a option");
            System.out.println("1.Book a Ticket");
            System.out.println("2.Show Confirmed Tickets");
            System.out.println("3.Show Rac Tickets");
            System.out.println("4.Show Waiting list Tickets");
            System.out.println("5.Cancel a Ticket");
            System.out.println("6.Exit");

            int option = s.nextInt();

            switch (option) {
                case 1 -> getPassengerDetails();
                case 2 -> showBookingList();
                case 3 -> showRacList();
                case 4 -> showWaitingListTicket();
                case 5 -> startCancellationProcess();
                case 6 -> quit = true;
            }


        }
    }

    private void startCancellationProcess() {

        System.out.println("Enter your passenger Id");
        int passengerId = s.nextInt();
        checkForPassengerId(passengerId);

    }

    private void checkForPassengerId(int passengerId) {

        List<Ticket> confirmTickets = getBookingList();
        List<Ticket> racList = getRacList();
        List<Ticket> waitingList = getWaitingList();

        int isConfirmedPassenger = isPassengerAvailable(confirmTickets, passengerId);
        if (isConfirmedPassenger != -1) {
            cancelTicket(confirmTickets, racList, waitingList, 1, isConfirmedPassenger);
            System.out.println("Ticket cancelled Successfully");
            return;
        }
        int racPassenger = isPassengerAvailable(racList, passengerId);
        if (racPassenger != -1) {
            cancelTicket(confirmTickets, racList, waitingList, 2, racPassenger);
            System.out.println("Ticket cancelled Successfully");
            return;
        }
        int isWaitingListPassenger = isPassengerAvailable(waitingList, passengerId);
        if (isWaitingListPassenger != -1) {
            cancelTicket(confirmTickets, racList, waitingList, 3, isWaitingListPassenger);
            System.out.println("Ticket cancelled Successfully");
            return;
        }
        System.out.println("Invalid Passenger ID");

    }

    private void cancelTicket(List<Ticket> confirmTickets, List<Ticket> racList, List<Ticket> waitingList, int flow, int index) {

        Ticket cancelledTicket;
        Ticket racTicket;

        if (flow == 1) {
            cancelledTicket = confirmTickets.get(index);
            confirmTickets.remove(index);
            if (!racList.isEmpty()) {
                racTicket = racList.get(0);
                racTicket.berthPreference = cancelledTicket.berthPreference;
                racTicket.ticketNumber = cancelledTicket.ticketNumber;
                racTicket.ticketStatus = TicketStatus.CONFIRM;
                confirmTickets.add(racTicket);
                waitingListToRac(waitingList, racList);
            } else {
                confirmTickets.remove(index);
                increaseBerthCount(cancelledTicket.berthPreference);
            }
        } else if (flow == 2) {
            waitingListToRac(waitingList, racList);
        } else {
            waitingList.remove(index);
            increaseWaitingListCt();
        }
    }

    private void waitingListToRac(List<Ticket> waitingList, List<Ticket> racList) {
        Ticket waitingListTicket;
        if (!waitingList.isEmpty()) {
            racList.remove(0);
            waitingListTicket = waitingList.get(0);
            waitingList.remove(0);
            waitingListTicket.ticketStatus = TicketStatus.RAC;
            racList.add(waitingListTicket);
            increaseWaitingListCt();
        } else {
            increaseRacCt();
            racList.remove(0);
        }
    }

    private void increaseWaitingListCt() {
        setWaitingListCt(getWaitingListCt() + 1);
    }

    private void increaseRacCt() {
        setRacCt(getRacCt() + 1);
    }

    public void setRacCt(int racCt) {
        this.racCt = racCt;
    }

    public void setWaitingListCt(int waitingListCt) {
        this.waitingListCt = waitingListCt;
    }

    private void increaseBerthCount(Berth berthPreference) {

        if (berthPreference == Berth.LOWER) {
            addLowerCt();
        } else if (berthPreference == Berth.MIDDLE) {
            addMiddleCt();
        } else {
            addUpperCt();
        }
    }

    private void addMiddleCt() {
        setMiddleCt(getMiddleCt() + 1);
    }

    private void addLowerCt() {
        setLowerCt(getLowerCt() + 1);
    }

    private void addUpperCt() {
        setUpperCt(getUpperCt() + 1);
    }


    private int isPassengerAvailable(List<Ticket> list, int passengerId) {
        if (list.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).passengerId == passengerId) {
                    return i;
                }
            }
        }

        return -1;
    }
}

