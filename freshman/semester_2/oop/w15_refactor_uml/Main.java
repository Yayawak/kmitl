public class Main {
    public static void main(String[] args) {
        CSTravel csTravel = new CSTravel();
        FlightsReservation flight6003 = csTravel.getFlight("cs6003");
        flight6003.showSeating();
        System.out.println("--------------");

        boolean isSuccess;
        isSuccess = flight6003.reserveSeat(2, 3);
        System.out.println("reserving (2,3) result = " + isSuccess + "..no change.");
        System.out.println("--------------");

        isSuccess = flight6003.reserveSeat(3, 1);
        System.out.println("reserving (3,1) result = " + isSuccess);
        System.out.println("--------------");

    }
}
