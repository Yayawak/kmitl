import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Plane22Seating extends PlaneSeating {

    public Plane22Seating(String seatingStringFormat) {
        super();
        String[] tokens = seatingStringFormat.split(",");
        int numRow = tokens.length;
        int numCol = tokens[0].length();
        seating = new char[numRow][numCol];
        for (int i = 0; i < tokens.length; i++) {
            seating[i] = tokens[i].toCharArray();
            // System.out.format("Seating %d array = %s\n",
            //     i, Arrays.toString(seating[i])
            // );
        }
        // System.out.println();
    }

    private boolean isFull() {
        for (int i = 0; i < seating.length; i++) {
            for (int j = 0; j < seating[i].length; j++) {
                if (j == 2) continue;
                if (seating[i][j] == '^') return false;
            }
        }
        return true;
    }

    @Override
    public boolean reserveSeat(int row, int col) {
        if (isFull()) {
            System.out.println("full seat.");
            return false;
        }
        row--;
        col--;
        // if (col == 2) col++;
        switch (seating[row][col]) {
            case 'x':
                System.out.format("This seat position (%d,%d) is already reserved.\n",
                    row + 1, col + 1
                );
                return false;

            case '_':
                System.out.format("This seat position (%d,%d) is aisle, and can not be reserved.\n",
                    row + 1, col + 1
                );
                return false;

            case '^':
                System.out.format("seat (%d,%d) symbol is ^. Latest seat map is "
                    , row, col
                );
                seating[row][col] = 'x';
                System.out.format("Sucessly reserved seat (%d,%d).\n",
                    row + 1, col + 1
                );
                return true;
            default:
                return false;
        }
    }
}
