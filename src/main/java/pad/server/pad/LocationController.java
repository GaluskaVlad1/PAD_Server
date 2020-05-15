package pad.server.pad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class LocationController {
    @Autowired
    private LocationRepository locationRepository;


    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/addLocation")
    public RegisterAnswer addLocation(@RequestBody Location location){
        locationRepository.save(location);
        return new RegisterAnswer(true);
    }

    @GetMapping("/getLocations")
    public Collection<Location> getLocationsBy(@RequestParam String filter){
        if(filter.contains("all")) return locationRepository.findAll();
        else return locationRepository.getAllByCategory(filter);
    }

    @DeleteMapping("/delete")
    public RegisterAnswer deleteLocation(@RequestParam String title){
        Location delete = locationRepository.getByTitle(title);
        if(delete!=null){
            locationRepository.delete(delete);
            return new RegisterAnswer(true);
        }else return new RegisterAnswer(false);
    }

    @PostMapping("/addComment")
    public RegisterAnswer addComment(@RequestParam String title,@RequestParam String comment,@RequestParam String username){
        Location location = locationRepository.getByTitle(title);
        location.comment = username + ": " + comment;
        locationRepository.save(location);
        Comment comments = commentRepository.getCommentByTitle(title);
        if(comments==null) {
            Comment c = new Comment();
            c.title = title;
            c.comments = new ArrayList<String>();
            c.comments.add(username+": "+comment);
            commentRepository.save(c);
        }
        else{
            comments.comments.add(username + ": " + comment);
            commentRepository.save(comments);
        }
        return new RegisterAnswer(true);
    }

    @GetMapping("/getComments")
    public ArrayList<String> getComments(@RequestParam String title){
        Comment comments = commentRepository.getCommentByTitle(title);
        return comments.comments;
    }

    @GetMapping("/viewLocation")
    public Location viewLocation(@RequestParam String title){
         return locationRepository.getByTitle(title);
    }
}
