// package PF.LabW5.PerfectNumber;
package PF.LabW4.RealLab4.PerfectNumber;

public class App {
    public static void main(String[] args) {
        int numberOfPerfect = 25;
        // ? Bad performance
        // VanilaMethodFindPerfectNumber.getFirstNPerfectNumber(numberOfPerfect);
        // * Better performance
        EuclidMethodPerfectNumber.getFirstNPerfectNumber(numberOfPerfect);
    }
}
