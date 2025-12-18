@Repository
public interface ShortnerRepo extends JpaRepository<Url, Long> {
    Url findByShortKey(String shortKey);
}