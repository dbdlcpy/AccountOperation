package Run;

import Bean.Account;
import DAO.IAccountDao;
import Service.AccountService;
import Service.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "bean.xml");// 初始化spring
        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("AccountDao");// 初始化userDao这个数据库接口类

        // userDao.updatePassword(1, "cc");这样就能修改id=1的password字段，让其变成cc，这里不作展示

        /* 查询整张表的内容将其打印出来 */
        List<Account> accountList = new ArrayList<Account>();
        AccountService accountService = new AccountServiceImpl();
        Account testAccount = new Account(3,"testName", (float) 66.6);
        accountService.saveAccount(testAccount);
        accountList = accountDao.findAll();
        for (Account account : accountList) {// jdk1.5+的foreach打印，省事，不用写这么多代码了
            System.out.println(account.getId() + "\t" +account.getName() + "\t"
                    + account.getMoney());
        }

        ((ConfigurableApplicationContext) applicationContext).close();// 关闭Spring避免警告
    }
}
