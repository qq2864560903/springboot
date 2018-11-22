package heima.itcast.demo;

import heima.itcast.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hjj
 * @date 2018-11-13
 */
@Service
public class HelloService {
    @Autowired
    private HelloRepository helloRepository;

    public boolean ifUserAndPassword(String userName,String passWord){
        List<User> list = helloRepository.findByUserNameAndPassWord(userName,passWord);
        if(list != null && list.size()>0){
            return true;
        }
        return false;
    }
}
