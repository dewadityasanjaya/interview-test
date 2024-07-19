import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CacheSizeCalculator {

    public static int minimumCacheSize(int n, List<String> requests, int k) {
        for (int cacheSize = 1; cacheSize <= n; cacheSize++) {
            if (canAchieveKHits(cacheSize, requests, k)) {
                return cacheSize;
            }
        }
        return -1;
    }

    private static boolean canAchieveKHits(int cacheSize, List<String> requests, int k) {
        Set<String> cache = new LinkedHashSet<>();
        int hitCount = 0;

        for (String request : requests) {
            if (cache.contains(request)) {
                // Cache hit
                hitCount++;
                cache.remove(request);
            } else if (cache.size() == cacheSize) {
                // Cache miss and cache is full, remove the least recently used item
                String firstKey = cache.iterator().next();
                cache.remove(firstKey);
            }
            cache.add(request);
        }

        return hitCount >= k;
    }

    public static void main(String[] args) {
        List<String> requests = List.of("item1", "item1", "item3", "item1", "item3");
        int k = 1;
        int n = requests.size();
        System.out.println(minimumCacheSize(n, requests, k));  // Output: 1
    }
}
