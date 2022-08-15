package JavaLearner.projects.VendingMachineUI;

public interface CalculatorInterface {
    int calculateTotal(CoinBundle enteredCoins);
    CoinBundle calculateChange(int amountMoneyToReturn); 
}
