import org.apache.commons.lang3.RandomStringUtils;

public class Account {
    private String ID;
    private int Money;

    public Account () {
        Money = 10000;
        ID = RandomStringUtils.random(7, true, false);
    }

    public String getID() {
        return ID;
    }

    public int getMoney() {
        return Money;
    }

    public void setMoney(int money) {
        Money = money;
    }
}