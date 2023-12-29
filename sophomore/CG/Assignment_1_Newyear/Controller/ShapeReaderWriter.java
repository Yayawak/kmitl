package Assignment_1_Newyear.Controller;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Assignment_1_Newyear.Model.Curve;
import Assignment_1_Newyear.Model.FloodModel;
import Assignment_1_Newyear.Model.Line;
import Assignment_1_Newyear.Model.LineWidthState;
import Assignment_1_Newyear.Model.PrimaryShape;
import Assignment_1_Newyear.View.Center.Center;

public class ShapeReaderWriter {
    public static String pathToMemFile = "Assignment_1_Newyear/data/Memory.csv";
    static File file = new File(pathToMemFile);

    private static void appendToFile(String message) {
        try (FileWriter fr = new FileWriter(file, true)) {
            fr.write(message + "\n");
            fr.close();
        } catch (IOException e) {
            System.out.println("Error of writing customer file to path of " + pathToMemFile);
            e.printStackTrace();
        }
    }

    public static void writeNewShapeDataToMemory(PrimaryShape shape) {
        int id = 99;
        if (shape instanceof Line) {
            Line l = (Line) shape;
            System.out.println("Writing Line to Memory\n");
            // appendToFile(pathToMemFile);
            // String s = String.format(
            //         "id : %d~ type : line~ points : p0[%d,%d], p1[%d,%d]",
            //         id,
            //         l.start.x, l.start.y,
            //         l.end.x, l.end.y);
// id : 99~ type : line~ points : p0[547,219], p1[219,300]
// id : 99~ type : line~ points : p0[124,150], p1[458,366]
// id : 99~ type : line~ points : p0[512,104], p1[248,368]
            String s = String.format(
                "line, %d, %s, %s, %d, %d, %d, %d",
                    id,
                    ColorUtils.rgbToHex(shape.color),
                    shape.widthState.toString(),
                    l.start.x,
                     l.start.y,
                    l.end.x,
                     l.end.y);
            appendToFile(s);
        } 
        else if (shape instanceof Curve)
        {
            Curve c = (Curve)shape;
            System.out.println("Writing Curve to Memory\n");
            String s = String.format(
                "curve, %d, %s, %s, %d, %d, %d, %d, %d, %d, %d, %d",
                    id,
                    ColorUtils.rgbToHex(shape.color),
                    shape.widthState.toString(),
                    c.start.x, c.start.y,
                    c.end.x, c.end.y,
                    c.control1.x, c.control1.y,
                    c.control2.x, c.control2.y
                );
            appendToFile(s);

        }
        else if (shape instanceof FloodModel)
        {
            FloodModel f = (FloodModel)shape;
            System.out.println("Writing Flood-data to Memory\n");
            String s = String.format(
                "flood, %d, %s, %s, %d, %d",
                    id,
                    ColorUtils.rgbToHex(f.oldColor),
                    ColorUtils.rgbToHex(f.replacementColor),
                    f.targetPos.x,
                    f.targetPos.y
                );
            appendToFile(s);

        }
        else {
            System.out.println("unknow shape -> don't write to file");
        }
    }


    public static PrimaryShape decoder(String encodedS)
    {
        assert (encodedS != null);
        String arr[] = encodedS.split(",");
        assert arr.length > 1;
        // System.out.println(Arrays.toString(arr));
        // System.out.println(encodedS);

        for (int i = 0; i < arr.length; i++)
        {
            // arr[i] = arr[i].strip();
            arr[i] = arr[i].trim();
            // arr[i].replaceAll("\\p{C}", "?");
        }
        String type = arr[0];
        // System.out.println(type);
        // System.out.println(arr[1]);
    // int id = Integer.parseInt(arr[1]);
        int id = Integer.parseInt(arr[1]);
        // Color color = Color.decode(arr[2]);
        // LineWidthState lineWidthState = LineWidthState.valueOf(arr[3]);

        if (type.equals("line"))
        {
            Color color = Color.decode(arr[2]);
            LineWidthState lineWidthState = LineWidthState.valueOf(arr[3]);
            int coords[] = new int[4];
            for (int i = 0; i < 4; i++)
            {
                coords[i] = Integer.valueOf(arr[4 + i]);
            }
            var l = new Line(
                            new Point(coords[0], coords[1]),
                            new Point(coords[2], coords[3])
            );
            l.id = id;
            l.color = color;
            l.widthState = lineWidthState;

            return l;
        }
        else if (type.equals("curve"))
        {
            Color color = Color.decode(arr[2]);
            LineWidthState lineWidthState = LineWidthState.valueOf(arr[3]);
            int coords[] = new int[8];
            for (int i = 0; i < 8; i++)
            {
                coords[i] = Integer.valueOf(arr[4 + i]);
            }
            var c = new Curve(
                new Point(coords[0], coords[1]),
                new Point(coords[2], coords[3]),
                new Point(coords[4], coords[5]),
                new Point(coords[6], coords[7])
            );
            c.id = id;
            c.color = color;
            c.widthState = lineWidthState;

            return c;
        }
        else if (type.equals("flood"))
        {
            int coords[] = new int[2];
            for (int i = 0; i < 2; i++)
            {
                coords[i] = Integer.valueOf(arr[4 + i]);
            }
            // new FloodModel(null, null, color, color)
            var f = new FloodModel(
                new Point(
                    Integer.valueOf(arr[4]),
                    Integer.valueOf(arr[5])
                ),
                // null,
                // Center.getInstance().buffer,
                // Center.buffer,
                Color.decode(arr[2]),
                Color.decode(arr[3])
            );
            f.id = id;
            f.color = null;
            f.widthState = null;

            return f;
        }
        else
        {
            System.err.println("Invalid Type readed from Memory.txt");
            System.exit(1);
        }

        return null;
    }

    public static ArrayList<PrimaryShape> readShapesFromMemory() {
        ArrayList<PrimaryShape> ret = new ArrayList<>();

        System.out.println("Reading Shapes Data From Memory");
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(pathToMemFile));
            String line = reader.readLine();
            // line.replaceAll("\\p{C}", "?");
            // System.out.println(line);
            // while (line != null) { // * this work for multiple line -> but the below line prevents only one character existed in Memory.csv but it's can not used to decode data
            // while (line != null && line.length() != 1) {
            while (line != null) {
                // if (line.length() != 1) // * only remain 1 char at first line -> must delete all
                // {
                //     return ret;
                // }
                
                // if (rowIndex == 0) {
                // rowIndex++;
                // columns = line.split(",");
                // } else {
                // System.out.println(line);

                // CustomerModel cust = decodeRowCommaToSingleCustomer(line, columns);
                // System.out.println(cust);
                // ret.add(cust);
                // }

                ret.add(decoder(line));

                // read next line
                line = reader.readLine();
                // line.replaceAll("\\p{C}", "?");
                // rowIndex++;
                // System.out.println("");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }
    
    public static void deleteLastLine() {
        // var p = "Assignment_1_Newyear/data/mock.txt";
        var p = pathToMemFile;

        try {
            RandomAccessFile f = new RandomAccessFile(p, "rw");
            long length = f.length() - 1;
            byte b = 0;
            // while (b != 10 && length > 0) {
            while (b != 10 && length >= 0) { // ? prevent removing first line 
                length -= 1;
                f.seek(length);
                b = f.readByte();
            }
            f.setLength(length + 1);
            f.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
