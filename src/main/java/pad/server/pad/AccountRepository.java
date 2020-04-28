package pad.server.pad;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    public Account findAccountByUsername(String username);
}
