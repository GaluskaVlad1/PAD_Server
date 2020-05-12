package pad.server.pad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class RegisterController {
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/register")
    public RegisterAnswer register(@RequestBody Account account) throws Exception{
        if(accountRepository.findAccountByUsername(account.username) != null) return new RegisterAnswer(false);
        accountRepository.save(account);
        return new RegisterAnswer(true);
    }
}
