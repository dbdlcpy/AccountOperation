package DAO;

import Bean.Account;

import java.util.List;

public interface IAccountDao {
    //save Account data
    void save(Account account);

    //update Account data
    void update(Account account);

    //Delete Account by Id
    void delete(Integer id);

    //Look up Account info by id
    Account findById(Integer id);

    //Look up All Account Info
    List<Account> findAll();

}
