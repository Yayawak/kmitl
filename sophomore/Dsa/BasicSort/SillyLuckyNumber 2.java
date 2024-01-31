package BasicSort;

public class SillyLuckyNumber {
    private String breed;
    private int luckyNumber;
    private int threeDigit; // 0 to 999

    public SillyLuckyNumber(String s) {
        setBreed(s);
    }

    // getters
    @Override
    public String toString() {
        return "<<" + breed + " "
                + luckyNumber + " " + threeDigit + ">>";
    }

    public String getBreed() {
        return breed;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    public int getThreeDigit() {
        return threeDigit;
    }
    public void setBreed(String newBread)
    {
        breed = newBread;
        for (int i = 0; i < breed.length(); i++)
            luckyNumber += breed.charAt(i);
        threeDigit = luckyNumber % 1000;
    }

}