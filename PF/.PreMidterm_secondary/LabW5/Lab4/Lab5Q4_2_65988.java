package PF.PreMidterm.LabW5.Lab4;

public class Lab5Q4_2_65988 {
    public static void main(String[] args) {
        // String s1 = "I am happy";
        String s2 = "xyz"; //-1

        // XXX.displayFirstVowel(s1);
        XXX.displayFirstVowel(s2);
    }
    // static void
    private class XXX {
        // String strToCheck;
        final static char[] vowelCharArr = "aeiou".toCharArray();

        // public XXX(String strToCheck) {
        //     this.strToCheck = strToCheck.toLowerCase();
        // }
        // public <T> T getFirstVowelOrNull (T t) {
        //     if(hasVowel())
        //         return
        //     return t;
        // }

        // private <T> T getFirstVowel(T t) {
        // private char getFirstVowel() {
        // private void displayFirstVowel(String strToCheck) {

        public static void displayFirstVowel(String strToCheck) {
            boolean hasVowel = false;
            // * Loop for word
            for (char c : strToCheck.toCharArray()) {
                // * Loop for checking is in vowel
                for (char vowelChar : vowelCharArr) {
                    if (c == vowelChar) {
                        // return c;
                        hasVowel = true;
                        System.out.println(c);
                        break ;
                        // return T
                        // return true;
                    }
                }
                if (hasVowel) break;
            }
            // hasVowel = false;
            if(!hasVowel) {
                System.out.println(-1);
            }
            // return false;
        }
    }
}
