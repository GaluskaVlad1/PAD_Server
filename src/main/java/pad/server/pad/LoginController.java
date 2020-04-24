package pad.server.pad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    private String username;
    private String password;

    @GetMapping("/login")
    public Answer loginAnswer(@RequestParam Map<String,String> requestParams) throws Exception{
        this.username = requestParams.get("username");
        this.password = requestParams.get("password");
        return new Answer(true,true);
    }
}
