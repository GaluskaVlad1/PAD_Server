package pad.server.pad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.HttpURLConnection;
import java.net.URL;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class RegisterController {
    @PostMapping("/register")
    public RegisterAnswer register(@RequestBody Account account) throws Exception{
        String url = "http://localhost:8090/register?username="+account.username+
                "&password="+account.password;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url,String.class);
        if(result.contains("true")){
            return new RegisterAnswer(true);
        }
        return new RegisterAnswer(false);
    }
}
