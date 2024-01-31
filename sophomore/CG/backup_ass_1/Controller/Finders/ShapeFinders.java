package backup_ass_1.Controller.Finders;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

import Assignment_1_Newyear.Controller.ShapeReaderWriter;
import Assignment_1_Newyear.Model.Curve;
import Assignment_1_Newyear.Model.Line;
import Assignment_1_Newyear.Model.PrimaryShape;

public class ShapeFinders {
    private static boolean isFinishingWriteData = true;
    // public static int findRowIndexByLine(Line line)
    public static int findRowIndexByShape(PrimaryShape shape)
    {
        System.out.println("finding shape from memory");
        int rowIndex = 0;
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(ShapeReaderWriter.pathToMemFile));
            String l = reader.readLine();
            while (l != null) 
            {
                String arr[] = l.split(",");
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = arr[i].strip();
                }
                if (arr[0].equals("line") && shape instanceof Line)
                {
                    Line line = (Line)shape;
                    // line
                    int x1 = Integer.valueOf(arr[4]);
                    int y1 = Integer.valueOf(arr[5]);
                    int x2 = Integer.valueOf(arr[6]);
                    int y2 = Integer.valueOf(arr[7]);

                    if (
                        line.start.x == x1 &&
                        line.start.y == y1 &&
                        line.end.x == x2 &&
                        line.end.y == y2
                    )
                    {
                        System.out.println("Found Line Mathced At Row = " + rowIndex);
                        return rowIndex;
                    }
                }
                rowIndex++;
                l = reader.readLine();
            }
            reader.close();
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -2;
    }

    // public static void findRowByShapeAndDelete(PrimaryShape shape)
    public static void findRowByShapeAndDelete(PrimaryShape shape)
    {
        if (!isFinishingWriteData)
            return;
        System.out.println("finding shape from memory");
        StringBuilder newMemString = new StringBuilder("");
        // StringBuilder newMemString = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(ShapeReaderWriter.pathToMemFile));
            String l = reader.readLine();
            newMemString.append(l + "\n");
            // int k = 0;
            // String l = "";
            while (l != null) 
            {
                boolean isSkipThisLine = false;
                String arr[] = l.split(",");
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = arr[i].strip();
                }
                if (arr[0].equals("line") && shape instanceof Line)
                {
                    Line line = (Line)shape;
                    // line
                    int x1 = Integer.valueOf(arr[4]);
                    int y1 = Integer.valueOf(arr[5]);
                    int x2 = Integer.valueOf(arr[6]);
                    int y2 = Integer.valueOf(arr[7]);

                    if (
                        line.start.x == x1 &&
                        line.start.y == y1 &&
                        line.end.x == x2 &&
                        line.end.y == y2
                    )
                    {
                        // System.out.println("Found Line Mathced At Row = " + rowIndex);
                        // System.out.println("skipping thie line founded row -> write with out this line " + line);
                        // return rowIndex;
                        System.out.println(Math.random());
                        // continue; // for -> skip append l to newMemString
                        isSkipThisLine = true;
                    }
                }
                else if (arr[0].equals("curve") && shape instanceof Curve)
                {
                    System.out.println("test curve");
                    Curve c = (Curve)shape;

                    int[] coords = new int[8];
                    Point[] ps = {c.start, c.control1, c.control2, c.end};
                    for (int i = 0; i < 4; i++)
                    {
                        Point p = ps[i];
                        coords[(2 * i) + 0] = p.x;
                        coords[(2 * i) + 1] = p.y;
                    }
                    boolean isIdentical = false;
                    for (int i = 0; i < 8; i++)
                    {
                        // if (coords[i] != )
                        int fromMemCoord = Integer.valueOf(arr[4 + i]);
                        int fromInputCoord = coords[i];
                        if (fromInputCoord != fromMemCoord)
                        {
                            isIdentical = true;
                            break;
                        }
                    }
                    if (isIdentical)
                        isSkipThisLine = true;
                }
                else
                {
                    System.out.println("unknown type finding ...");
                }
                if (l != null && !isSkipThisLine) // * eof
                    newMemString.append(l + "\n");
                l = reader.readLine();
            }
            reader.close();
            isFinishingWriteData = true;

            deleteAllContentFromFileAndReWriteByString(newMemString.toString());
            // System.out.println("new mem ...");
            // System.out.println(newMemString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        isFinishingWriteData = false;
    }

    // public static void deleteAllContentFromFile() {
    public static void deleteAllContentFromFileAndReWriteByString(String newContent) {
        System.out.println("Rewriting All Content In Mem due to data altered.");
        System.out.println("##########");
        System.out.println(newContent);
        System.out.println("**********");
        try {
            FileWriter writerObj = new FileWriter(
                ShapeReaderWriter.pathToMemFile,
                 false);
            writerObj.write(newContent.strip());
            writerObj.close();
            // System.out.println("================================\n"
            //         + "File successfully overwritten.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
