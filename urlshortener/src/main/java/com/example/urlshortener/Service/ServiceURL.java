@Service
public class ServiceURL{


    @Autowired
    ShortnerRepo urlRepository;



   //Approach using Hex encoding
    // public String encodeUrl(String longUrl){
    //     UrlEntity urlEntity=new UrlEntity();
    //     urlEntity.setLongUrl(longUrl);
    //     urlRepository.save(urlEntity);
    //     String shortUrl="http://short.url/" + Long.toHexString(urlEntity.getId());
    //     return shortUrl;
    // }


    //Approach using Base62 encoding and Redis for unique ID generation

     
        @Autowired
        RedisCounterService redisCounterService;
        @Autowired
        Base62Encoder base62Encoder;
               
        //    Long id=redisCounterService.getNextId();
        //    String shortUrl = base62Encoder.encode(id);

     public String encodeUrl(String longUrl){
           Long id=redisCounterService.getNextId();
           String shortUrl = base62Encoder.encode(id);
            UrlEntity urlEntity=new UrlEntity(shortUrl, longUrl);
            urlRepository.save(urlEntity);
        return shortUrl;
    }


    public String findUrl(String shortUrlKey){
        long id=Long.parseLong(shortUrlKey,16);
        UrlEntity urlEntity=urlRepository.findById(id).orElse(null);
        if(urlEntity!=null){
            return urlEntity.getLongUrl();
        }else{
            return "URL not found";
        }
    }
    
    


}