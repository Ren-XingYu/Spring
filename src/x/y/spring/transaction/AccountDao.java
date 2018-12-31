package x.y.spring.transaction;

public interface AccountDao {
    void outMoney(String from,Double money);
    void inMoney(String to,Double money);
}
