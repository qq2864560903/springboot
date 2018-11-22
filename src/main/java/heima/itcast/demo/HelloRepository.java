package heima.itcast.demo;

import heima.itcast.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author hjj
 * @date 2018-11-13
 */
public interface HelloRepository extends JpaRepository<User,Integer> {
    List<User> findByUserNameAndPassWord(String userName, String passWord);
}
