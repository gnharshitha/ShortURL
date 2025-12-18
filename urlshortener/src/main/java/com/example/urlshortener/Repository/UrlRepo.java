@Repository
public interface ShortnerRepo extends JpaRepository<UrlEntity, Long> {
    UrlEntity findByShortUrl(String shortUrl);
}