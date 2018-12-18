package springboot.blog.domain;

/**
 * User 实体
 * @author kuangfeng
 * @date 2018-12-16 01:41
 */
public class User {
    private long id; //实体一个唯一标识
    private String name;
    private String email;

    public User(){
        //无参的构造函数
    }
    public User(long id,String name,String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
