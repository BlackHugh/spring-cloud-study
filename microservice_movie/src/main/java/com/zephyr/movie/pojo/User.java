package com.zephyr.movie.pojo;
import lombok.Data;
//
@Data
//@Entity
//@Table(name = "tb_user")
public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private Double money;

    public User(){}

    public User(Integer id, String username, String password, String sex, Double money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.money = money;
    }
}
