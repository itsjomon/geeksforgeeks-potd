class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        Map<String, ArrayList<String>> umap = new HashMap<>();
        for (String s : arr) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted_s = new String(chars);
            umap.computeIfAbsent(sorted_s, k -> new ArrayList<>()).add(s);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>(umap.values());
        return result;
    }
}
