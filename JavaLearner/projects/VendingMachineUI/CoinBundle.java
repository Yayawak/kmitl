package JavaLearner.projects.VendingMachineUI;

public class CoinBundle {
    public int number5CentsCoins;
    public int number10CentsCoins;
    public int number20CentsCoins;
    public int number50CentsCoins;
    public int number100CentsCoins;

    public CoinBundle(int... enterdCoins) {
        this.number5CentsCoins = enterdCoins[0];
        this.number10CentsCoins = enterdCoins[1];
        this.number20CentsCoins = enterdCoins[2];
        this.number50CentsCoins = enterdCoins[3];
        this.number100CentsCoins = enterdCoins[4];
    }
}
