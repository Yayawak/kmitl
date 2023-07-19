package FlightRequirement;

public abstract class PlaneSeating {
    protected char[][] seating;

    // ! assosiation -> การเชื่อมโยง
    public abstract void showSeating();
    public abstract void reserveSeat();
}
