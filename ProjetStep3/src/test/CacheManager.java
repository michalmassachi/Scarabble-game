package test;


import java.util.HashSet;
import java.util.Set;

public class CacheManager {
    private final Set<String> cache;
    private final CacheReplacementPolicy crp;
    private final int maxSize;
    int wordCounter;

    public CacheManager(int maxSize, CacheReplacementPolicy crp) {
        this.maxSize = maxSize;
        this.crp = crp;
        this.cache = new HashSet<>();
        wordCounter = 0;
    }

    public boolean query(String word) {
        return cache.contains(word);
    }

    public void add(String word) {
        crp.add(word);
        if (cache.size() >= maxSize) {
            String victim = crp.remove();
            cache.remove(victim);
        }
        else
            wordCounter++;
        cache.add(word);
    }
}
