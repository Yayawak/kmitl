import java.util.List;

public abstract class PlaneSeating {
    protected char[][] seating;
    protected String planeType;

    public void showSeating() {
        // throw new UnsupportedOperationException("Unimplemented method 'showSeating'");
        for (int i = 0; i < seating.length; i++) {
            // String str = List.of(seating.seating[i])
            //     .stream().reduce((a, b) -> a + b).get().toString();
            System.out.format("row %d --> ",
                i + 1);
            List.of(seating[i]).stream()
                .forEach(c -> System.out.print(c));
            System.out.println();
            // System.out.print();
        }
        // System.out.println(seating);
    }
    public abstract boolean reserveSeat(int row, int col);
}
