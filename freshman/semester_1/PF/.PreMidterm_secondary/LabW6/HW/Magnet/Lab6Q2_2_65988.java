package PF.LabW6.HW.Magnet;


public class Lab6Q2_2_65988 {
    private enum State {
        push, pull
    }
    public static void main(String[] args) {
        String input = "10 10 10 01 10 10";
        int segments = 1;

        String[] arr = input.split(" ");
        String prevElem = arr[0];
        String curElem = arr[0];


        State prevState;
        if (curElem.charAt(0) != prevElem.charAt(1)) {
            prevState = State.pull;
        }
        else prevState = State.push;

        State curState = prevState;
        for(int i=0; i<arr.length; i++) {
            prevElem = arr[i];
            try {
                curElem = arr[i+1];
            } catch (Exception e) {
                break;
            }
            if (curElem.charAt(0) != prevElem.charAt(1)) {
                curState = State.pull;
            }else{
                curState = State.push;
            }

            if(prevState != curState) segments++;
            prevState = curState;
        }
        System.out.println("Number of Segments = " + segments);
    }
}
