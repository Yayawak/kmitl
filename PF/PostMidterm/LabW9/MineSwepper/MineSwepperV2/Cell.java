// package MineSwepperV2;
package MineSwepperV2;

import java.util.ArrayList;

public class Cell {
    private final int xPos;
    private final int yPos;
    private final boolean isMineExist;

    private Cell[][] board;
    private ArrayList<Cell> surroundingCells;

    public Cell(int x, int y, boolean isMineExist
        , Cell[][] board
    )
    {
        this.xPos = x;
        this.yPos = y;
        this.isMineExist = isMineExist;
        this.board = board;
        surroundingCells = new ArrayList<>();

    }


}
