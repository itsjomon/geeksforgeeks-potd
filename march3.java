class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        Deque<Integer> minQ = new ArrayDeque<>(), maxQ = new ArrayDeque<>();
        int n = arr.length, start = 0, resStart = 0, resLen = 0;
        for (int end = 0; end < n; end++) {
            while (!minQ.isEmpty() && arr[minQ.peekLast()] > arr[end]) minQ.pollLast();
            while (!maxQ.isEmpty() && arr[maxQ.peekLast()] < arr[end]) maxQ.pollLast();
            minQ.addLast(end);
            maxQ.addLast(end);
            while (arr[maxQ.peekFirst()] - arr[minQ.peekFirst()] > x) {
                if (minQ.peekFirst() == start) minQ.pollFirst();
                if (maxQ.peekFirst() == start) maxQ.pollFirst();
                start++;
            }
            if (end - start + 1 > resLen) {
                resStart = start;
                resLen = end - start + 1;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = resStart; i < resStart + resLen; i++) res.add(arr[i]);
        return res;
    }
}
