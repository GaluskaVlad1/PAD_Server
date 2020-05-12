package pad.server.pad;

import org.springframework.data.annotation.Id;

import java.awt.*;

public class Location {
    @Id
    public String id;

    public String title;
    public String description;
    public Image image;
    public String category;

    public Location(String title,String description,Image image,String category){
        this.title = title;
        this.category = category;
        this.description = description;
        this.image = image;
    }
}
