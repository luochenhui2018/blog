package springboot.blog.repository;



import org.springframework.stereotype.Repository;
import springboot.blog.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;




/**
 * User Repository的实现
 * @author kuangfeng
 * @date 2018-12-16 16:41
 */
@Repository
public class UserRepositoryImol implements UserRepository {
    private static AtomicLong counter = new AtomicLong();//计数器
    private final ConcurrentMap<Long,User> userMap = new ConcurrentHashMap<>();

    @Override
    public User saveOrUpdateUser(User user) {
        Long id = user.getId();
        if(id==null){
            id=counter.incrementAndGet();
            user.setId(id);
        }
        this.userMap.put(id,user);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        this.userMap.remove(id);
    }

    @Override
    public User getUserById(long id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> listUsers() {
        return new ArrayList<User>(this.userMap.values());
    }
}
