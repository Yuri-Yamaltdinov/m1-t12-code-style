import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(pay);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period);
    }

    double round(double value) {
        double scale = Math.pow(10, 2);
        return Math.round((value * scale) / scale);
    }

    void calculateDeposit() {
        double outAmount = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int inAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println ("Выберите тип вклада: 1 - вклад с обычным процентом, 2 - вклад с капитализацией.");
        int action = scanner.nextInt();
        if (action == 1) {
            outAmount = calculateSimplePercent(inAmount, 0.06, period);
        } else if (action == 2) {
            outAmount = calculateComplexPercent(inAmount, 0.06, period);
        }
        System.out.println("Результат вклада: " + inAmount + " за " + period + " лет превратятся в " + outAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDeposit();
    }

}
