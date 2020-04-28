package pad.server.pad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class LoginController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/login")
    public LoginAnswer loginAnswer(@RequestParam Map<String,String> requestParams) throws Exception{
        String username = requestParams.get("username");
        String password = requestParams.get("password");
        return login(username,password);
    }

    public LoginAnswer login(String username, String password){
        Account account = accountRepository.findAccountByUsername(username);
        if(account == null) return new LoginAnswer(false,false);
        if(account.password.equals(password)){
            if(username.equals("admin")) return new LoginAnswer(true,true);
            else return new LoginAnswer(true,false);
        }else return new LoginAnswer(false,false);
    }
}
