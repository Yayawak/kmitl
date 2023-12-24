package NewYear.Dragon.Tail;

import java.awt.Color;
import java.awt.Point;

import Lab2LineAlgorithms.Drawing;
import Lab2LineAlgorithms.LineAlgorithms;
import NewYear.Dragon.UtilsTrigs.Node;

public class TriangleMesh
{
    // public ArrayList<ArrayList<Triangle>>
    public TriangleMesh()
    {

    }

    // public void connectOtherTriangleByClosestAngle(Triangle t1, Triangle t2)
    // {

    // }
    
    // public static double distLineSegmentToPoint(Point p1, Point p2, Point p3)
    // {
    //     double divider = (
    //         (p2.x - p1.x)*(p2.x - p1.x) *
    //         (p2.y - p1.y)*(p2.y - p1.y)
    //     );
    //     if (divider == 0)
    //         divider = 0.00000000000000000000000000000000000000000000000001d;
    //         // divider = 1;
    //     double u = (
    //         (p3.x - p1.x)*(p2.x - p1.x) + (p3.y - p1.y)*(p2.y - p1.y)
    //     ) / divider;
    //     Point p = new Point(
    //         (int)(p1.x + u * (p2.x - p1.x)),
    //         (int)(p1.y + u * (p2.y - p1.y))
    //     );
    //     return Math.pow(p.x - p3.x, 2) + Math.pow(p.y - p3.y, 2);
    // }

    public static Point createPointFromPointLengthDegree(Point point, double length, double degree)
    {
        // if (degree < 0) degree = (int)(360 - degree) % 360;
        // if (degree < 0) degree = (int)(360 - degree) % 360;

        double tan = Math.tan(Math.toRadians(degree));
        // double x = Math.sqrt((length * length) / (1 + tan * tan));
        double h = Math.sqrt((length * length) / (1 + tan * tan));
        double x = point.x + h;
        double y = point.y + h * tan;
        // double y = x * tan;

        return new Point((int)x, (int)y);
    }

    // * distLineSegmentToPoint v2 but better
    public static float  pDistance(float x, float y, float x1, float y1, float x2, float y2) {

        float A = x - x1; // position of point rel one end of line
        float B = y - y1;
        float C = x2 - x1; // vector along line
        float D = y2 - y1;
        float E = -D; // orthogonal vector
        float F = C;
  
        float dot = A * E + B * F;
        float len_sq = E * E + F * F;
  
        return (float) Math.abs(dot) / (float)Math.sqrt(len_sq);
    }

    // public static Triangle extrudeAnotherTrigByClosetAngle(Triangle t, int deg, int extrudeScaleRadius)
    public static Triangle extrudeAnotherTrigByClosetAngle(
        // Node tail, int deg, float extrudeScaleNormalize0to1)
        Triangle t, int deg, float extrudeScaleNormalize0to1, int index)
    {
        return extrudeAnotherTrigByClosetAngle(
            t, deg, extrudeScaleNormalize0to1, index, t.getArea()
        );
    }

    public static Triangle extrudeAnotherTrigByClosetAngle(
        Triangle t, int deg, float extrudeScaleNormalize0to1
        ,int index
        , int oldArea)
    {
        // System.out.println(t.toString());
        // Triangle t = tail.triangle;
        Point c = t.getCenter();

        double longestDistToVertices = Float.MIN_VALUE;
        for (int i = 0; i < 3 ; i++)
        {
            double d = c.distance(t.points[i]);
            if (d > longestDistToVertices)
            {
                longestDistToVertices = d;
            }
        }
        double noise = 0.08 * (Math.sin(extrudeScaleNormalize0to1) + 0.5);
        // longestDistToVertices *= 0.6 + extrudeScaleNormalize0to1 - noise;
        // longestDistToVertices += 10;
        // longestDistToVertices *= 1.1;
        // longestDistToVertices *= 1.3;
        longestDistToVertices *= 1.7;
        // System.out.println("extrude final lenght = " + longestDistToVertices);
        double radian = Math.toRadians(deg);
        Point longlongTestPoint = new Point(
            c.x + (int)(longestDistToVertices * Math.cos(radian)),
            c.y + (int)(longestDistToVertices * -Math.sin(radian))
        );
        // System.out.println("longlong test point = "+ longlongTestPoint);
        Drawing.getG().setColor(Color.green);
        Drawing.drawGeneralDot(longlongTestPoint, 10);

        int minDistIndexSide = -1;
        // int secondaryMinDistIndexSide = minDistIndexSide;

        double minDist = Double.MAX_VALUE;
        Point doubleBases[] = new Point[2];
        for (int i = 0; i < 3; i++)
        {
            var p = t.points[i];
            var q = t.points[(i + 1) % 3];
            var mid = new Point((p.x + q.x) / 2, (p.y + q.y) / 2);
            // double dist = pDistance(
            //     p.x, p.y, 
            //     q.x, q.y, 
            //     longlongTestPoint.x, longlongTestPoint.y
            // );
            double dist = mid.distance(longlongTestPoint);
            // System.out.println("dist = " + dist);
            if (dist < minDist)
            {
                minDist = dist;
                minDistIndexSide = i;
                doubleBases[0] = p;
                doubleBases[1] = q;
            }
            // if (i == 2)
            //     break;
            // secondaryMinDistIndexSide = minDistIndexSide;
        }
        // minDistIndexSide = (minDistIndexSide + 1) % 3;
        // secondaryMinDistIndexSide = (secondaryMinDistIndexSide + 1) % 3;

        // System.out.printf("Primary Index = %d, Secondary Index = %d\n", minDistIndexSide, secondaryMinDistIndexSide);

        // if (t.isOppositeSideConnected[minDistIndexSide])
        // {
        //     minDistIndexSide = secondaryMinDistIndexSide;
        // }
        // else
        // {
        //     t.isOppositeSideConnected[minDistIndexSide] = true;
        // }
        System.out.printf("Min Opposite Selected Point is %s\n", t.points[minDistIndexSide]);
        // Point baseNewPoint1 = t.points[(minDistIndexSide + 2) % 3];
        // Point baseNewPoint2 = t.points[(minDistIndexSide + 3) % 3];

        // Point baseNewPoint1 = t.points[(minDistIndexSide + 1) % 3];
        // Point baseNewPoint2 = t.points[(minDistIndexSide + 2) % 3];

        // Point baseNewPoint1 = t.points[(minDistIndexSide + 0) % 3];
        // Point baseNewPoint2 = t.points[(minDistIndexSide + 1) % 3];
        // Point baseNewPoint1 = t.points[(minDistIndexSide + 1) % 3];
        // Point baseNewPoint2 = t.points[(minDistIndexSide + 2) % 3];

        Point baseNewPoint1 = doubleBases[0];
        Point baseNewPoint2 = doubleBases[1];

        var retT = new Triangle(baseNewPoint1, baseNewPoint2, longlongTestPoint);

        Drawing.getG().setColor(Color.cyan);
        Drawing.drawGeneralDot(baseNewPoint1, 8);
        Drawing.drawGeneralDot(baseNewPoint2, 8);
        // System.out.println(retT.getArea());

        float areaOffsetPersentage = 0.3f;
        float oldTrigArea = t.getArea();
        float lowerBound = oldTrigArea * (1 - areaOffsetPersentage);
        float upperBound = oldTrigArea * (1 + areaOffsetPersentage);

        // if (retT.getArea() < lowerBound || retT.getArea() > upperBound)
        // if (retT.getArea() < 300)
        // if (retT.getArea() < 100)
        System.out.printf("old,new = [%d, %d] \n",
         oldArea, retT.getArea());
        // if (retT.getArea() < oldArea)
        // if (retT.getArea() < oldArea && retT.getArea() > 300)
        // if (false && retT.getArea() < 100 || retT.getArea() > 300)
        // {
            
        //     System.out.println("recursive lock");

        //     int area = (int)(retT.getArea() * (2 * Math.random()));

        //     // int _deg = (int)(deg * ((Math.random() - 0.5) * 45));
        //     // System.out.println("deg new -> " + _deg);
        //     int _deg = (int)(deg * ((Math.random() - 0.5) * 45));

        //     double newSlope = Triangle.getSlopeFrom2Point(baseNewPoint1, baseNewPoint2);
        //     double orthogonalSlope = newSlope * -1;
        //     // double newY = (orthogonalSlope * longlongTestPoint.x + c.y) - longlongTestPoint.y;
            
        //     // System.out.println("deg new -> " + _deg);

        //     // int _deg = (int)(deg * ((Math.random() - 0.5) * 15));
        //     // int _deg = (int)(deg * ((Math.random() - 0.5) * 5));

        //     // throw new Error("area = " + area);
        //     System.out.println(area);
        //     return extrudeAnotherTrigByClosetAngle(
        //         tail, 
        //         _deg,
        //         // deg,
        //         extrudeScaleNormalize0to1,
        //         // 1,
        //         retT.getArea()
        //     );
        // }
        // if (true)
        // if (retT.getArea() < 100 || retT.getArea() > 300)
        // if (retT.getArea() < 50 || retT.getArea() > 200)
        if (retT.getArea() < lowerBound || retT.getArea() > upperBound)
        {
            System.out.println("Enter Remaking Condition...\n\n");
            // System.out.println(retT.getArea());
            Point midPoint = new Point(
                (baseNewPoint1.x + baseNewPoint2.x) / 2,
                (baseNewPoint1.y + baseNewPoint2.y) / 2
            );
            double baseSlope = Triangle.getSlopeFrom2Point(baseNewPoint1, baseNewPoint2);
            // double orthogonalSlope = newSlope * -1;
            System.out.println("slope = " + baseSlope);
            double degreeOfEdge = Math.toDegrees(Math.atan(baseSlope));
            double degreeOrtho1 = degreeOfEdge + 90;
            // double degreeOrtho1 = degreeOfEdge - 45;
            double degreeOrtho2 = degreeOfEdge - 90;
            System.out.printf("Deg 0 A B = %f, %f, %f\n", degreeOfEdge, degreeOrtho1, degreeOrtho2);

            Point testP1 = createPointFromPointLengthDegree(midPoint, longestDistToVertices, degreeOrtho1);
            Point testP2 = createPointFromPointLengthDegree(midPoint, longestDistToVertices, degreeOrtho2);

            LineAlgorithms.bshLine(midPoint, testP1);
            LineAlgorithms.bshLine(midPoint, testP2);


            Drawing.getG().setColor(Color.yellow);
            Drawing.drawGeneralDot(testP1, 8);
            Drawing.drawGeneralDot(testP2, 8);

            Drawing.getG().drawString("D 1", testP1.x, testP1.y);
            Drawing.getG().drawString("D 2", testP2.x, testP2.y);

            double distFromTestP1_to_longTestPoint = testP1.distance(longlongTestPoint);
            double distFromTestP2_to_longTestPoint = testP2.distance(longlongTestPoint);
            System.out.printf("double dist = [%f,%f]\n", distFromTestP1_to_longTestPoint, distFromTestP2_to_longTestPoint);

            System.out.println("longlongtestpoit" + longlongTestPoint);
            // System.out.println("longlong len = " + longestDistToVertices);
            Point useThisPoint = distFromTestP1_to_longTestPoint < distFromTestP2_to_longTestPoint
                ? testP1 : testP2;
            System.out.println("Point Used new = " + useThisPoint);
            
            retT = new Triangle(baseNewPoint1, baseNewPoint2, useThisPoint);
        }
        Color realOrange = Color.decode("#FF5C01");
        retT.color = index % 2 == 0 ? realOrange : Color.orange;

        return retT;
    }
}