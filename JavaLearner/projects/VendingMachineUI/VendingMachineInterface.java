package JavaLearner.projects.VendingMachineUI;

public interface VendingMachineInterface {
    void displayProduct();
    void selectProduct();
    void displayEnterCoinsMessage();
    void enterCoins(int... coins);
    void displayMessageChange();
}
