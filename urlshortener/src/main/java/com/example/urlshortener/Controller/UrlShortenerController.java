
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlShortenerController 
{
    @Autowired
    Service  Urlservice;

    @PostMapping("/Compress")
    @ResponseEntity 
    public ResponseEntity postURL(@RequestBody String Url){
           StringShortUri=Urlservice.encodeUrl(Url);
            return ResponseEntity.ok("short URI " +StringShortUri);
    } 

    
      public ResponseEntity findURL(@RequestBody String key)
        {
               String longURI=Urlservice.findUrl(key);
                return ResponseEntity.ok("Long URI " +longURI);
        }


}