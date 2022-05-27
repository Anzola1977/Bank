import java.time.ZonedDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank {

    private AtomicInteger money = new AtomicInteger();

    int getMoney() {
        return money.get();
    }

    void take(int money) {
        // безопасно уменьшаем
        this.money.addAndGet(-money);
    }

    void repay(int money) {
        //безопасно увеличиваем
        this.money.addAndGet(money);
    }

    class Client extends Thread{
        @Override
        public void run() {
            while(true) {
                // выдаем кредит, только если
                // есть свободные средства
                if (getMoney() >= 1000) {
                    take(1000);
                    repay(1000);
                }
            }
        }
    }

    public Bank() {
        //устанавливаем начальное значение
        money.set(10000);
        for (int i = 0; i < 5; i++)
            new Client().start();

    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        while(true) {
            ZonedDateTime.now();
            System.out.println(bank.getMoney());
            Thread.sleep(1000);
        }
    }
}