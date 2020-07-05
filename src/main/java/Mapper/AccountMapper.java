package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.Account;
import org.springframework.jdbc.core.RowMapper;

public class AccountMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rownum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        account.setMoney(rs.getFloat("money"));
        return account;
    }
}

