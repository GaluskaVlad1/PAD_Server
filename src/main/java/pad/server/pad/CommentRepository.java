package pad.server.pad;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String> {
    public Comment getCommentByTitle(String title);
}
