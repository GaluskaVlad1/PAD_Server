package pad.server.pad;

import org.springframework.data.annotation.Id;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Location {
    @Id
    public String id;

    public String title;
    public String description;
    public String category;
    public String comment;

    public Location(String title,String description,String category){
        this.title = title;
        this.category = category;
        this.description = description;
    }
}
