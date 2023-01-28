// package PF.PostMidterm.LabW14.ReadFile.Prob1;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import javax.xml.catalog.Catalog;


class Main {
    public static void main(String[] args) {
        printAllEmployee();
    }


    private static void printAllEmployee()
    {
        String path = "../employee.csv";
        try (Scanner input = new Scanner(Paths.get(path)))
        {
            String[] error_list = new String[2];
            String[] cleaned_data_list = new String[2];
            int i = 0;
            while (input.hasNext())
            {
                String row = input.nextLine();
                String[] dataFields = row.split(",");
                try {
                    int col_0 = (int)Integer.parseInt(dataFields[0]);
                    double col_3 = Double.parseDouble(dataFields[3]);
                    String data = "";
                    for (int j = 0; j < dataFields.length; j++)
                        data += dataFields[j] + " ";
                    cleaned_data_list[i] = data;

                } catch (NumberFormatException e) {
                    String err = "Data format error at line " +
                        String.valueOf(i) +
                        "; " +
                        String.valueOf(e);
                    error_list[i] = err;
                }
                catch (IndexOutOfBoundsException e)
                {
                    // System.out.println("Index out of bound : " + e);
                    System.out.println("Array is full - cannot load remaining rows");
                    System.exit(0);
                }
                catch (Exception e) {
                    System.out.println("Common Exception " + e);
                }
                i++;
            }
            printArrContent(error_list);
            System.out.println("Id " + "First Name " + "Last Name "+ "Salary");
            printArrContent(cleaned_data_list);
        }
        catch(NoSuchFileException e) {
            System.out.println("File not found : " + e);
        }
        catch(IOException e)
        {
            System.out.println("Unknown I/O error : " + e);
            e.printStackTrace();
        }
    }

    static void printArrContent(String[] a)
    {
        for (int i = 0; i < a.length; i++)
            if (a[i] != null)
                System.out.println(a[i]);
    }
}

