package backup_ass_1.Controller;


public class SoundFactory {
    public enum SoundOptions{
        shortNoti
    }

    public static void play(SoundOptions opt)
    {
        switch (opt) {
            case shortNoti:
                SoundApi.playSound("Assignment_1_Newyear/Assets/sounds/shortNoti.wav");
                break;
        
            default:
                break;
        }
    }
}
