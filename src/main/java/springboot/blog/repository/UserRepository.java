package springboot.blog.repository;

import org.springframework.data.repository.CrudRepository;
import springboot.blog.domain.User;

import java.util.List;

/**
 * User Repository接口.
 * @author kuangfeng
 * @date 2018-12-16 01:57
 */
public interface UserRepository extends CrudRepository<User,Long> {
//    //创建或修改用户接口
//    User saveOrUpdateUser(User user);
//    //删除用户接口
//    void deleteUser(long id);
//    //根据id来查询用户
//    User getUserById(long id );
//    //批量查询用户(列表)
//    List<User> listUsers();

//    CrudRepository接口提供了上面的这些方法，把自己的接口删除掉
}
