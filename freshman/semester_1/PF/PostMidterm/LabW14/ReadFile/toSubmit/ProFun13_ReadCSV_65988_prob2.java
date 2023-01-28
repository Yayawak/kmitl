// package PF.PostMidterm.LabW14.ReadFile.Prob1;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

class Employee {
    private int empId;
    private String firstName, lastName;
    private double salary;
    public Employee() {
        this(0, "","", 0.0);
    }
    public Employee(int empId, String firstName, String lastName, double salary) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public int getEmpId() {
        return empId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
    public String getEmployeeInfo() {
        return empId + " " + firstName + " " + lastName + " " + salary;
    }
}

class ProFun13_ReadCSV_65988_prob2 {
    public static void main(String[] args) {
        // printAllEmployee();
        Employee[] empList = getEmpList();
        printAllEmployee(empList);
    }

    private static void printAllEmployee(Employee[] empList)
    {
        System.out.println("Id " + "First Name " + "Last Name "+ "Salary");
        for (int i = 0; i < empList.length; i++)
        {
            if (empList[i] != null)
                System.out.printf("%d %s %s %.2f\n",
                    empList[i].getEmpId(),
                    empList[i].getFirstName(),
                    empList[i].getLastName(),
                    empList[i].getSalary()
                );
        }
    }

    private static Employee[] getEmpList()
    {
        String path = "../employee.csv";
        Employee[] empList = new Employee[2];
        try (Scanner input = new Scanner(Paths.get(path)))
        {
            int i = 0;
            while (input.hasNext())
            {
                String row = input.nextLine();
                String[] dataFields = row.split(",");
                try {
                    int col_0 = (int)Integer.parseInt(dataFields[0]);
                    double col_3 = Double.parseDouble(dataFields[3]);
                    String data = "";
                    Employee emp = new Employee(
                        col_0, dataFields[1], dataFields[2], col_3
                    );
                    empList[i] = emp;

                }
                catch (IndexOutOfBoundsException e)
                {
                    System.out.println("Array is full - cannot load remaining rows");
                    System.exit(0);
                }
                catch (NumberFormatException e) {
                    // System.out.printf("Number format wrong " + e);
                    String err = "Data format error at line " +
                        String.valueOf(i) +
                        "; " +
                        String.valueOf(e);
                } catch (Exception e) {
                    System.out.println("Common Exception " + e);
                }
                i++;
            }
        }
        catch(NoSuchFileException e) {
            System.out.println("File not found : " + e);
        }
        catch(IOException e)
        {
            System.out.println("Unknown I/O error : " + e);
            e.printStackTrace();
        }
        return empList;
    }

}

