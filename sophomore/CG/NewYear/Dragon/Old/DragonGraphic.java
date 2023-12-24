package NewYear.Dragon.Old;

import java.awt.Graphics;
import java.awt.Point;

import Lab3CurveTrigFloodFill.BazierAlgorithm;

public class DragonGraphic {
    DHead head;
    DBody body;

    public DragonGraphic()
    {
        head = new DHead(new Point(300, 300));
        body = new DBody(head);
    }

    public void moveDragon()
    {

    }

    public void shift(Point offset)
    {
        // head
        head.pos.translate(offset.x, offset.y);
        // Utils.ShiftPoints(body.nodes, offset);
        // body.shi
        // head.pos.translate(offset.x, offset.y);
    }
}
