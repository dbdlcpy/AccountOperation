package Service;

import Bean.Account;

import java.util.List;

public interface AccountService {
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);
    Account findById(Integer id);
    List<Account> findAll();
}
