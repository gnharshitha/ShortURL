@Service
public class ServiceURL{


    @Autowired
    UrlRepository urlRepository;

    public String encodeUrl(String longUrl){
        UrlEntity urlEntity=new UrlEntity();
        urlEntity.setLongUrl(longUrl);
        urlRepository.save(urlEntity);
        String shortUrl="http://short.url/" + Long.toHexString(urlEntity.getId());
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