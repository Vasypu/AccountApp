import org.apache.log4j.Logger;

import java.util.Random;

public class Transfer {
    static final Logger logger = Logger.getLogger(Transfer.class);

    public static void main(String[] args) {
        Account firstAcc = new Account();
        Account secondAcc = new Account();
        Account thirdAcc = new Account();
        Account forthAcc = new Account();

        Runnable firstTask = () -> {
            try {
                Thread.currentThread().sleep(getSleepTime());
                int money = getMoneyForTransfer(firstAcc.getMoney());
                firstAcc.setMoney(firstAcc.getMoney() - money);
                secondAcc.setMoney(secondAcc.getMoney() + money);
                logger.info("Money for transfer from firstAcc " + money);
                logger.info("Money on firstAcc " + firstAcc.getMoney());
                logger.info("Money on secondAcc " + secondAcc.getMoney());

            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        };

        Runnable secondTask = () -> {
            try {
                Thread.currentThread().sleep(getSleepTime());
                int money = getMoneyForTransfer(thirdAcc.getMoney());
                thirdAcc.setMoney(thirdAcc.getMoney() - money);
                forthAcc.setMoney(forthAcc.getMoney() + money);
                logger.info("Money for transfer from thirdAcc " + money);
                logger.info("Money on thirdAcc " + thirdAcc.getMoney());
                logger.info("Money on forthAcc " + forthAcc.getMoney());

            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        };

        for (int i = 0; i < 15; i++) {
            Thread firstThread = new Thread(firstTask);
            firstThread.start();
            Thread secondThread = new Thread(secondTask);
            secondThread.start();
        }
    }

    public static int getSleepTime() {
        Random random = new Random();
        return random.ints(1000, 2000)
                .findFirst()
                .getAsInt();
    }

    public static int getMoneyForTransfer(int money) {
        Random random = new Random();
        return random.ints(0, money)
                .findFirst()
                .getAsInt();
    }
}
