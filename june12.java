class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                int d1 = Math.abs(a - x), d2 = Math.abs(b - x);
                return d1 != d2 ? d2 - d1 : a - b;
            }
        );
        for (int num : arr) if (num != x) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }
        List<Integer> res = new ArrayList<>(pq);
        res.sort((a, b) -> {
            int d1 = Math.abs(a - x), d2 = Math.abs(b - x);
            return d1 != d2 ? d1 - d2 : b - a;
        });
        return res.stream().mapToInt(i -> i).toArray();
    }
}
