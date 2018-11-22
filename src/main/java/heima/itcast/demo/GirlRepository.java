package heima.itcast.demo;


import heima.itcast.demo.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author hjj
 * @date 2018-11-2
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //通过年龄查询女生
    public List<Girl> findByAge(int age);

    //通过罩杯和年龄查询女生
    List<Girl> findByCupSizeAndAge(String cupSize, int age);
}
