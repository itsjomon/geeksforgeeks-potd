class Solution {
    public int minValue(String s, int k) {
        int n = s.length();
        int[] alphabetCount = new int[26];
        int maxi = 0;
        for (char c : s.toCharArray()) {
            alphabetCount[c - 'a']++;
            maxi = Math.max(maxi, alphabetCount[c - 'a']);
        }

        int[] freq = new int[maxi + 1];
        int maxFreq = 0;
        for (int count : alphabetCount) {
            if (count > 0) {
                freq[count]++;
                maxFreq = Math.max(maxFreq, count);
            }
        }
        while (k > 0 && maxFreq > 0) {
            int countAtMax = freq[maxFreq];
            if (countAtMax <= k) {
                k -= countAtMax;
                freq[maxFreq - 1] += countAtMax;
                freq[maxFreq] = 0;
                maxFreq--;
            } else {
                freq[maxFreq] -= k;
                freq[maxFreq - 1] += k;
                k = 0;
            }
        }
        int result = 0;
        for (int i = 1; i <= maxi; i++) {
            result += i * i * freq[i];
        }
        return result;
    }
}
