package PF.LabW4;

public class checkboard {
    public static void main(String[] args) {
        int startTile = 0;
        int lastTile = 80;
        int currentTile = startTile;
        // int tileCount = 0;
        while (currentTile < lastTile) {
            if(currentTile % 5 == 0) {
                System.out.print("| O | " + "\t");
            }else{
                // System.out.print("X" + "\t");
                // System.out.print(currentTile + "\t");
                // System.out.printf("| %d | \t", currentTile);
                System.out.printf("| X | \t");
            }
            currentTile++;

            // tileCount = (currentTile + 1) % 10;
            if(currentTile ==0) {
                System.out.println();
            }
        }
    }
}
