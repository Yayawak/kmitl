public class Flights {
    private String code;
    private City source;
    private City destination;
    private DayOfWeek day;
    private Time departTme;
    public Flights(String code, City source, City destination, DayOfWeek day, Time departTme) {
        this.code = code;
        this.source = source;
        this.destination = destination;
        this.day = day;
        this.departTme = departTme;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public City getSource() {
        return source;
    }
    public void setSource(City source) {
        this.source = source;
    }
    public City getDestination() {
        return destination;
    }
    public void setDestination(City destination) {
        this.destination = destination;
    }
    public DayOfWeek getDay() {
        return day;
    }
    public void setDay(DayOfWeek day) {
        this.day = day;
    }
    public Time getDepartTme() {
        return departTme;
    }
    public void setDepartTme(Time departTme) {
        this.departTme = departTme;
    }
    @Override
    public String toString() {
        return "Flights [code=" + code + ", source=" + source + ", destination=" + destination + ", day=" + day
                + ", departTme=" + departTme + "]";
    }


}
