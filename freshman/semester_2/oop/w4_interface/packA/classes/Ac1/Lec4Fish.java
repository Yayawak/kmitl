package packA.classes.Ac1;

import packA.interfaces.CanSwimIntf;

public class Lec4Fish implements CanSwimIntf {
    @Override
    public void swim() {
        System.out.println("Flexing my tail back and forth");
    }

    public void fishMethod() {
        System.out.println("do i?");
    }
}
