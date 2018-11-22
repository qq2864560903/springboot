package heima.itcast.demo;


import heima.itcast.demo.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author hjj
 * @date 2018-11-2
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/findGirl")
    public Optional<Girl> findGirl(@RequestParam(value = "id",required = false)Integer id){
        return girlRepository.findById(id);
    }

    @PostMapping(value = "/insertGirl")
    public Girl insertGirl(@RequestParam(value = "age")int age,@RequestParam(value = "cupSize") String cupSize){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @PostMapping(value = "/findGirlByAge")
    public List<Girl> findGirlByAge(@RequestParam(value = "age")int age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/findByCupSizeAndAge")
    public List<Girl> findByCupSizeAndAge(@RequestParam(value = "age")Integer age,@RequestParam(value = "cupSize")String cupSize){
        return girlRepository.findByCupSizeAndAge(cupSize,age);
    }



    @GetMapping(value = "/insertTwo")
    public void insertTwo(){
        girlService.insertTwo();
    }

    public void test(){
        System.out.println("123");
    }

}
