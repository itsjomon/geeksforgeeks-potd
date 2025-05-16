class Solution {
    class Node {
        int val, row, idx;
        Node(int v, int r, int i) { val = v; row = r; idx = i; }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        int max = Integer.MIN_VALUE, start = 0, end = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            pq.add(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        while (true) {
            Node cur = pq.poll();
            int min = cur.val;
            if (max - min < end - start) {
                start = min;
                end = max;
            }
            if (cur.idx + 1 == arr[0].length) break;
            int nextVal = arr[cur.row][cur.idx + 1];
            pq.add(new Node(nextVal, cur.row, cur.idx + 1));
            max = Math.max(max, nextVal);
        }

        return new ArrayList<>(Arrays.asList(start, end));
    }
}
