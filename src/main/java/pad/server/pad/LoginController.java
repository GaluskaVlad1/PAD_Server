package pad.server.pad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class LoginController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/login")
    public LoginAnswer loginAnswer(@RequestBody Account account) throws Exception{
        String username = account.username;
        String password = account.password;
        return login(username,password);
    }

    public LoginAnswer login(String username, String password){
        Account account = accountRepository.findAccountByUsername(username);
        if(account == null) return new LoginAnswer(false,false);
        if(account.password.equals(password)){
            if(username.contains("admin")) return new LoginAnswer(true,true);
            else return new LoginAnswer(true,false);
        }else return new LoginAnswer(false,false);
    }
}
