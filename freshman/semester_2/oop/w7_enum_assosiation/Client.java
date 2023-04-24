public class Client implements CanPlay {

    private String name;
    private MemberTypeWithDiscount memberType;

    public Client(String name) {
        this.name = name;
        this.memberType = MemberTypeWithDiscount.None;
    }

    public Client(String name, MemberTypeWithDiscount memberType) {
        this.name = name;
        this.memberType = memberType;
    }

    private void promoteMemberType() {
        switch (memberType) {
            case None:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case SILVER:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.PREMIUM;
                break;
            default:
                break;
        }
    }

    private void demoteMemberType() {
        // memberType.SILVER.getProductDiscountRate()
        switch (memberType) {
            case SILVER:
                memberType = MemberTypeWithDiscount.None;
                break;
            case GOLD:
                memberType = MemberTypeWithDiscount.SILVER;
                break;
            case PREMIUM:
                memberType = MemberTypeWithDiscount.GOLD;
                break;
            default:
                break;
        }
    }

    public void showMembershipStatus() {
        // System.out.format("Your membership is %s",
        System.out.format("You are now %s\t %d%% discount on Product. %d%% on Service.\n",
            String.valueOf(memberType),
            (int)(memberType.getProductDiscountRate() * 10),
            (int)(memberType.getServiceDiscountRate() * 10)
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
