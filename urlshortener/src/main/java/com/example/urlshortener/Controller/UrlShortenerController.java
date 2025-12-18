
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlShortenerController 
{
    @Autowired
    ServiceURL  Urlservice;

    @PostMapping("/Compress")
    @ResponseEntity 
    public ResponseEntity postURL(@RequestBody String Url){
           StringShortUri=Urlservice.encodeUrl(Url);
            return ResponseEntity.ok("short URI " +StringShortUri);
    } 

        @GetMapping("/Expand")
        @ResponseEntity
      public ResponseEntity findURL(@RequestBody String key)
        {
                 if(key.contains("http://short.url/") && key!=null)
                 {
                        String longURI=Urlservice.findUrl(key);
                       return ResponseEntity.ok("Long URI " +longURI);
                     
                 }
                        else
                        {
                                return ResponseEntity.ok("Invalid Short URI key");
                        }   
               
        }


}