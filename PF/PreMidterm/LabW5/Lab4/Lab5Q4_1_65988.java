package PF.PreMidterm.LabW5.Lab4;

public class Lab5Q4_1_65988 {
    public static void main(String[] args) {
        String str = "wwwwmmmmwmwmwmwmmmwwwwwm".toUpperCase();
        // System.out.println(str);
        int maleCount = 0;
        int womenCount = 0;
        for(int i=0; i<str.length(); i++) {
            // if(String.valueOf(str.charAt(i)).equals("M"))
            if(str.charAt(i) == 'M')
                maleCount++;
            if(String.valueOf(str.charAt(i)).equals("W"))
                womenCount++;
        }
        // System.out.println(str.toCharArray());
        System.out.printf("Number of male : %d\n", maleCount);
        System.out.printf("Number of women : %d\n", womenCount);
    }
}
