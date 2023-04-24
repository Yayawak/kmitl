
public class Customer implements CanPlay {
    private String name;
    private MemberType memberType;

    public Customer(String name) {
        this.name = name;
        this.memberType = MemberType.None;
    }

    public Customer(String name, MemberType memberType) {
        this.name = name;
        this.memberType = memberType;
    }

    private void promoteMemberType() {
        switch (memberType) {
            case None -> memberType = MemberType.SILVER;
            case SILVER -> memberType = MemberType.GOLD;
            case GOLD -> memberType = MemberType.PREMIUM;

            // case None:
                // memberType = MemberType.SILVER;
                // break;
            // case SILVER:
            //     memberType = MemberType.GOLD;
            //     break;
            // case GOLD:
            //     memberType = MemberType.PREMIUM;
            //     break;
            // default:
            //     break;
        }
    }

    private void demoteMemberType() {
        switch (memberType) {
            case SILVER:
                memberType = MemberType.None;
                break;
            case GOLD:
                memberType = MemberType.SILVER;
                break;
            case PREMIUM:
                memberType = MemberType.GOLD;
                break;
            default:
                break;
        }
    }

    public void showMembershipStatus() {
        // System.out.format("Your membership is %s",
        System.out.format("You are now %s\n",
            String.valueOf(memberType)
        );
    }

    @Override
    public void spend(int direction) {
        if (direction > 0) {
            promoteMemberType();
        }
        else if (direction < 0) {
            demoteMemberType();
        }
        else { // == 0 no change

        }
        showMembershipStatus();
    }
}
