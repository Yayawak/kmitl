package NewYear.Dragon.Wing;

import java.awt.Point;

import NewYear.Dragon.Enumurations.Directions;
import NewYear.Dragon.UtilsTrigs.Node;

public class PairWing {
    Wing leftWing;
    Wing rightWing;

    // Point corePoint;
    Node coreNode;
    // public PairWing(Point corePoint)
    public PairWing(Node coreNode)
    {
        // this.corePoint = corePoint;
        this.coreNode = coreNode;

        // leftWing = new Wing(corePoint, Directions.left);
        leftWing = new Wing(coreNode, Directions.left);
        // rightWing = new Wing(corePoint);
    }

    
}
