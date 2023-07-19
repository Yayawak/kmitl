import java.util.List;
import java.util.Set;

// public class FlightsReservation extends PlaneSeating {
// public class FlightsReservation extends Plane22Seating {
public class FlightsReservation {
    private Flights flight;
    private PlaneSeating seating;
    // private Plane22Seating seating;

    public FlightsReservation(Flights flight) {
        this.flight = flight;
        this.seating = new Plane22Seating(
            "xx_xx,xx_x^,^x_xx,x^_xx,xx_^x"
        );
    }

    public void showSeating() {
        System.out.println(flight);
        seating.showSeating();
    }

    public boolean reserveSeat(int row, int col) {
        boolean bool = seating.reserveSeat(row, col);
        seating.showSeating();
        return bool;
    }


}
