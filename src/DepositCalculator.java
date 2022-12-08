import java.util.Scanner; //коммент сделан для проверки

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
        return Math.round((value * scale) / scale); //Мне кажется здесь лишние скобки поставил. В начальном коде другая формула.
    }

    void calculateDeposit() { //Название подходящее. У меня туго с названиями)
        double outAmount = 0; //Code style Практикума предлагает ставить пустую строку для разделения кода на блоки команд и блоки объявления переменных.
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
