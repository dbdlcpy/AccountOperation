package DAO;

import Bean.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class IAccountDaoImpl implements IAccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    @Override
    public void save(final Account account) {
      this.getJdbcTemplate().update("Insert INTO account (id,name,money) values(?,?,?) ", account.getId(),account.getName(),account.getMoney());
    }

    @Override
    public void update(Account account) {
        String sql ="UPDATE ACCOUNT set id=?, name=?, money=? where id = ?";
        this.jdbcTemplate.update(sql,account.getId(),account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM account WHERE ID =('"+id+"')";
        this.getJdbcTemplate().update(sql);
    }

    @Override
    public Account findById(Integer id) {
       String sql = "select * from account where id = ?";
       RowMapper myRowMapper = new BeanPropertyRowMapper<Account>(Account.class);
       return (Account) this.jdbcTemplate.queryForObject(sql,myRowMapper,"1");
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
        return this.jdbcTemplate.query(sql, rowMapper);
    }
}

