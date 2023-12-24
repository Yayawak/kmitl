package NewYear.Dragon.Wing;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import Lab2LineAlgorithms.Drawing;
import NewYear.Dragon.Enumurations.Directions;
import NewYear.Dragon.Tail.Triangle;
import NewYear.Dragon.Tail.TriangleMesh;
import NewYear.Dragon.UtilsTrigs.Node;

public class Wing {
    public List<Node> nodes = new ArrayList<>();
    // public Point corePoint;
    Directions dir;
    public Node coreNode;

    // public Wing(Point corePoint, Directions dir)
    public Wing(Node coreNode, Directions dir)
    {
        this.dir = dir;
        // this.corePoint = corePoint;
        this.coreNode = coreNode;

        drawBeginingHalf();
    }

    private void drawBeginingHalf()
    {
        // bool isLeft = false;
        // if (this.dir == Directions.left)
        boolean isLeft = this.dir == Directions.left ? true : false;
        int xMultipler = isLeft ? -1 : 1;
        int halfSize = 6;
            
        for (int i = 0; i < halfSize; i++)
        {
            // System.out.println("k");
            // Node node = new Node(null, i)
            float t = 1 - ((float)i / (float)halfSize);
            

            if (nodes.isEmpty())
            {
                nodes.add(coreNode);
                continue;
            }

            float deg = 180;
            // if (i % 2 == 0)
            if (i <= (halfSize / 2))
            {
                // deg -= 45;
                // deg 
                // deg = deg - (70 * t);
            }
            else
            {
                // deg -= 45;
                // deg = deg + (70 * t);
                // return;
            }

            

            // Triangle triangle = TriangleMesh.extrudeAnotherTrigByClosetAngle(
            //     nodes.getLast(),
            //     (int)deg,
            //     // 0.5f
            //     1
            // );
            // if (i % 2 == 0)
            // {
            //     triangle.color = Color.GREEN;
            // }
            // else
            // {
            //     triangle.color = Color.red;
            // }
            // Drawing.drawVerticesTriangle(triangle, Color.blue);
            // triangle.drawTrig();
            // Node node = new Node(triangle, nodes.size() - 1);
            // nodes.add(node);
        }

    }
}

