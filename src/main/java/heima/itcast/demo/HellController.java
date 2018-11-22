package heima.itcast.demo;

import heima.itcast.demo.model.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author hjj
 * @date   2018-10-31
 */
@RestController
public class HellController {
    @Value("${cupSize}")
    private String cupSize;

//    @Value("${content}")
//    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "有个"+girlProperties.getAge()+"岁"+girlProperties.getCupSize()+"罩杯的女孩";
    }

    @GetMapping(value = "/demo1")
    public String demo1(@RequestParam(value = "id",required = false,defaultValue = "0") int myId){
        return "id="+myId;
    }

    @PostMapping(value = "/ifUserAndPassword")
    public boolean ifUserAndPassword(@RequestParam(value = "username",required = true,defaultValue = "") String username,
                                     @RequestParam(value = "password",required = true,defaultValue = "") String password){

        return helloService.ifUserAndPassword(username,password);
    }

}
