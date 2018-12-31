package springboot.blog.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User 实体
 * @author kuangfeng
 * @date 2018-12-16 01:41
 */
@Data
@Entity //@Entity 进行实体改造，标识User是个实体
public class User {
    @Id //标示为一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增策略
    private Long id; //实体一个唯一标识
    private String name;
    private String email;

    protected User(){ //无参的构造函数,设为protectde,是为了防止直接使用（public）

    }
    public User(Long id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
    @Override  //重写
    public String toString(){ //重写toString方法
        return String.format("user[id=%id,name='%name',email='%email']",id,name,email);
    }
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
