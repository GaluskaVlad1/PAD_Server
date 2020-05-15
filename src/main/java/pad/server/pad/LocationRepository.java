package pad.server.pad;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface LocationRepository extends MongoRepository<Location,String> {
    public Collection<Location> getAllByCategory(String category);
    public Location getByTitle(String title);
}
