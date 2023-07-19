import java.util.HashMap;
import java.util.Map;

public class CSTravel {
    private Map<String, FlightsReservation> catalog = new HashMap<>();
    private Flights cs6003 = new Flights("cs6003", City.BNK, City.ICN, DayOfWeek.Mon, Time.pm1);
    private Flights cs6004 = new Flights("cs6004", City.BNK, City.ICN, DayOfWeek.Tue, Time.pm2);
    private Flights cs6005 = new Flights("cs6005", City.BNK, City.NRT, DayOfWeek.Wed, Time.pm3);
    private Flights cs6006 = new Flights("cs6006", City.BNK, City.SIN, DayOfWeek.Thr, Time.pm4);
    private Flights cs6007 = new Flights("cs6007", City.ICN, City.BNK, DayOfWeek.Fri, Time.pm5);
    // executed when using "new"
    {
        catalog.put("cs6003", new FlightsReservation(cs6003));
        catalog.put("cs6004", new FlightsReservation(cs6004));
        catalog.put("cs6005", new FlightsReservation(cs6005));
        catalog.put("cs6006", new FlightsReservation(cs6006));
        catalog.put("cs6007", new FlightsReservation(cs6007));
    }
    public FlightsReservation getFlight(String code) {
        return catalog.get(code);
    }
}
