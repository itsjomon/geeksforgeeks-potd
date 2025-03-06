class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    LRUCache(int cap) {
        this.capacity = cap;
        this.cache = new LinkedHashMap<>(cap, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        cache.put(key, value);
    }
}
