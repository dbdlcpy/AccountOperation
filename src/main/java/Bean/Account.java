package Bean;

import java.io.Serializable;

public class Account implements Serializable {
    private Integer id;
    private String name;


    public Account(Integer id, String name, Float money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
    public Account() {

    }
    private Float money;

    public String getName() {
        return name;
    }

    public Float getMoney() {
        return money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
