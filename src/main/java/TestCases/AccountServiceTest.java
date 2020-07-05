package TestCases;
import static org.junit.Assert.assertEquals;

import Bean.Account;
import DAO.IAccountDao;
import Service.AccountService;
import Service.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceTest {
    @Test
    public void testAccountService() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");// 初始化spring
        IAccountDao accountDao = (IAccountDao) applicationContext.getBean("AccountDao");// 初始化userDao这个数据库接口类
        AccountService accountService = (AccountService)applicationContext.getBean("AccountService");
        Account testAccount = new Account();

        System.out.println("testAccount创建后的地址："+testAccount);
        System.out.println("AccountService创建后的地址："+testAccount);

//            testAccount.setId(12);
            testAccount.setName("testNameUpdate");
            testAccount.setMoney((float) 66.4);
            testAccount.setId(0);

            accountService.updateAccount(testAccount);
            accountService.deleteAccount(12);
                List<Account> accountList = new ArrayList<Account>();
//                System.out.println(accountService.findById(1).toString());

                accountList = accountDao.findAll();
                for (Account account : accountList) {
                    System.out.println(account.getId() + "\t" +account.getName() + "\t"
                            + account.getMoney());
                }

        ((ConfigurableApplicationContext) applicationContext).close();
    }
}