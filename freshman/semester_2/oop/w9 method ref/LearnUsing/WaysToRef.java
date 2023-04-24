package LearnUsing;

public class WaysToRef {
    public static String staticMethodCS(String str) {
        return str + " is cS student.";
    }
    public static String staticMethodKmitl(String str) {
        return str + " is cS student.";
    }
    public String capitalizeName(Person p) {
        return p.getName().substring(0, 1)
            .toUpperCase() + p.getName().substring(1);
    }
}
