package NewYear.Dragon.Old;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import Lab2LineAlgorithms.LineAlgorithms;


public class DBody {
    public List<DRing> nodes = new LinkedList<>();
    public DHead head;

    public DBody(DHead head)
    {
        this.head = head;

        int noiseY = 30;
        int startX = 300;
        for (int i = 0; i < 3; i++)
        {
            int y = 300 + (int)(Math.sin(i) * noiseY);

            DRing n = new DRing(
                new Point(startX + 30 * i, y)
            );
            // n.point = new Point(30 * i, y);

            nodes.add(n);
            n.drawBody();
            if (i != 0)
            {
                // connectNodeToPrev(nodes.get(i - 1), nodes.get(i));
            }
        }
    }

    private void connectNodeToPrev(DRing prev, DRing curr)
    {
        // System.out.println("connect");
        // ! malfuntion
        // for (int i = 0; i < 4; i++)
        // {
        //     // if (i == 4) return;
        //     LineAlgorithms.bshLine(
        //         prev.circums[i].x, prev.circums[i].y,
        //         curr.circums[i].x, curr.circums[i].y
        //     );
        // }
    }
}
