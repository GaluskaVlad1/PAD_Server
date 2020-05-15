package pad.server.pad;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

public class Comment {
    @Field
    public ArrayList<String> comments;
    @Id
    @Field
    public String title;
}
