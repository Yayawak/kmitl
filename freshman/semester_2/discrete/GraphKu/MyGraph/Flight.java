package MyGraph;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    String airplaneCode;
    String flightCode;
    String from;
    String to;
    boolean isOneStop;
    // List<String> stopPlaces = new ArrayList<>();
    // FlightClass class;
    // public Flight(String airplaneCode, String flightCode, String from, String to, boolean isOneStop) {
    public Flight(String from, String to) {
        // this.airplaneCode = airplaneCode;
        // this.flightCode = flightCode;
        this.from = from;
        this.to = to;
        // this.isOneStop = isOneStop;
    }
    public String getAirplaneCode() {
        return airplaneCode;
    }
    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }
    public String getFlightCode() {
        return flightCode;
    }
    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public boolean isOneStop() {
        return isOneStop;
    }
    public void setOneStop(boolean isOneStop) {
        this.isOneStop = isOneStop;
    }
}
