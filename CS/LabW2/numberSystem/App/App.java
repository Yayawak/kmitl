package CS.LabW2.numberSystem.App;

import CS.LabW2.numberSystem.App.Converters.*;
import CS.LabW2.numberSystem.App.UI.GuiBase;

public class App {
    public static void main(String[] args) {
        // ! Normal style initiation;
        // Dec2Bin dec2bin_converter = new Dec2Bin();
        // dec2bin_converter.toBinary(348);
    
        // ! Static style (More fast, no need multiple classes)
        // Dec2AnyBase.toNewBaseNumber(378)
        System.out.println(Dec2AnyBase.toNewBaseNumber(378, 2));

        GuiBase base = new GuiBase();
        base.setVisible(true);
    } 
}
