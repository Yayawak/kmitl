// 65050669
public class Main {
    static int i = 0;
    public static void main(String[] args) {
        // Customer c1 = new Customer("hivonder", MemberType.GOLD);
        // c1.showMembershipStatus();
        System.out.println("--------------------");
        q1();
        System.out.println("--------------------");
        q2();
        System.out.println("--------------------");
        q3();
        System.out.println("--------------------");
    }

    static void q1() {
        int[] monthly = {1, 1, 1, 1, 1, -1, -1, 1, -1};
        Customer yindee = new Customer("Yindee");
        for (i = 0; i < monthly.length; i++) {
            yindee.spend(monthly[i]);
        }
    }

    static void q2() {
        int[] monthly = {1, 1, 1, 1, 1, -1, -1, 1, -1};
        Client preeda = new Client("Preeda");
        for (i = 0; i < monthly.length; i++) {
            preeda.spend(monthly[i]);
        }
    }

    static void q3() {
        MemberTypeWithDiscount p = MemberTypeWithDiscount.GOLD;
        MemberTypeWithDiscount q = MemberTypeWithDiscount.GOLD;
        // true because ordinal number is equal
        System.out.println(p == q);
    }
}
