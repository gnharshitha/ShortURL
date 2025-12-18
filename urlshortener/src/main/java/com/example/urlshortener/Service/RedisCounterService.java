public class RedisCounterService {

//  INCR url:global:counter
// Atomic
// Thread-safe
// Distributed safe

private static final String COUNTER_KEY = "url:global:counter";
 private final StringRedisTemplate redisTemplate;

    public RedisCounterService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public long getNextId() {
        return redisTemplate.opsForValue().increment(COUNTER_KEY);
    }


}