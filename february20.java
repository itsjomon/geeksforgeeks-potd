class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minH = new PriorityQueue<>();
        ArrayList<Double> res = new ArrayList<>();

        for (int n : arr) {
            maxH.add(n);
            minH.add(maxH.poll());
            if (maxH.size() < minH.size()) maxH.add(minH.poll());
            res.add(maxH.size() > minH.size() ? (double) maxH.peek() : (maxH.peek() + minH.peek()) / 2.0);
        }
        return res;
    }
}
