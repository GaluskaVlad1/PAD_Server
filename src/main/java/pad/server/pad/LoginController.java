package pad.server.pad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class LoginController {

    @PostMapping("/login")
    public LoginAnswer loginAnswer(@RequestBody Account account) throws Exception{
        String url = "http://localhost:8090/login?username="+account.username+
                "&password="+account.password;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        if(result.contains("true")){
            if(account.username.equals("admin")) return new LoginAnswer(true,true);
            return new LoginAnswer(true,false);
        }
        return new LoginAnswer(false,false);
    }
}
