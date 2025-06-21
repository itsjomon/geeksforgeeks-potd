class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        int count = 0;

        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thief = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thief.add(i);
            }

            while (!police.isEmpty() && !thief.isEmpty()) {
                int pol = police.peek();
                int thi = thief.peek();

                if (Math.abs(pol - thi) <= k) {
                    count++;
                    police.poll();
                    thief.poll();
                } else if (thi < pol) {
                    thief.poll();
                } else {
                    police.poll();
                }
            }
        }

        return count;
    }
}
