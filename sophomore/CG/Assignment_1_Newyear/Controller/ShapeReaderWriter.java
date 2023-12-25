package Assignment_1_Newyear.Controller;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Assignment_1_Newyear.Model.PrimaryShape;
import Lab2LineAlgorithms.Line;

public class ShapeReaderWriter {
    private static String pathToMemFile = "Assignment_1_Newyear/data/Memory.csv";
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
            System.out.println("Writing Line to Memory");
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
                "line, %d, %d, %d, %d, %d",
                    id,
                    l.start.x, l.start.y,
                    l.end.x, l.end.y);
            appendToFile(s);
        } else {
            System.out.println("unknow shape -> don't write to file");
        }
    }

    // private static PrimaryShape decoder(String encodedString)
    // {
    //     int start_type_index = encodedString.indexOf("type");
    //     String remainding = encodedString.substring(start_type_index, encodedString.length());
    //     // System.out.println(remainding);
    //     int after_type_tildIndex = remainding.indexOf("~");
    //     // System.out.println(after_type_tildIndex);
    //     // String typeName = encodedString.substring(start_type_index, after_type_tildIndex);
    //     // System.out.println(start_type_index);
    //     // System.out.println(after_type_tildIndex);
    //     String x = encodedString.substring(start_type_index, start_type_index + after_type_tildIndex);
    //     x = x.split(":")[1].strip();
    //     String typeName = x;
    //     //     .split(":")[0];
    //     // System.out.println(typeName);
    //     System.out.println(typeName);


    //     if (typeName.equals("line"))
    //     {
    //         int start_points_idx = encodedString.indexOf("points");
    //         int count_closeSqaureBracket = 0;
    //         int second_csb_index = start_points_idx;
    //         while (start_points_idx < encodedString.length())
    //         {
    //             if (count_closeSqaureBracket == 2)
    //             {
    //                 break;
    //             }
    //             if (encodedString.charAt(second_csb_index) == ']')
    //             {
    //                 count_closeSqaureBracket++;
    //             }
    //             second_csb_index++;
    //         }
    //         // System.out.println("second csb index = " + second_csb_index);

    //         String interestingS = encodedString.substring(start_points_idx, second_csb_index);
    //         interestingS = interestingS.split(":")[1].strip();
    //         System.out.println(interestingS);

    //         // Pattern p = Pattern.compile("\\d+");
    //         Pattern p0 = Pattern.compile("\\[(\\d+),(\\d+)\\]");
    //         // Matcher m = p.matcher("string1234more567string890");
    //         Matcher m0 = p0.matcher(interestingS);
    //         int coords[] = new int[4];
    //         int i = 0;
    //         while (m0.find()) 
    //         {
    //             // output of outter while is [124,150] somthing likethat -> so we want to extract 124 and 150 using innner loop
    //             var p1 = Pattern.compile("\\d+");
    //             var m1 = p1.matcher(m0.group());
    //             while (m1.find())
    //             {
    //                 // System.out.println(m1.group());
    //                 coords[i++] = Integer.valueOf(m1.group());
    //             }
    //             // System.out.println("g -> " + m0.group());
    //         }

    //         return new Line(
    //             new Point(coords[0], coords[1]),
    //             new Point(coords[2], coords[3])
    //         );
    //     } 
    //     else if (typeName.equals("triangle")) 
    //     {

    //     } else 
    //     {
    //         System.err.println("Invalid Type readed from Memory.txt");
    //         System.exit(1);
    //     }

    //     return null;
    // }

    public static PrimaryShape decoder(String encodedS)
    {
        String arr[] = encodedS.split(",");
        String type = arr[0];
        int id = Integer.valueOf(arr[1].strip());
        if (type.equals("line"))
        {
            int coords[] = new int[4];
            for (int i = 0; i < 4; i++)
            {
                coords[i] = Integer.valueOf(arr[2 + i].strip());
            }
            var l = new Line(
                            new Point(coords[0], coords[1]),
                            new Point(coords[2], coords[3])
            );
            l.id = id;

            return l;
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
            // System.out.println(line);
            while (line != null) {
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
                // rowIndex++;
                // System.out.println("");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
