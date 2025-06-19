class Solution {
    public static String caseSort(String s) {
        char[] chars = s.toCharArray();
        List<Character> upper = new ArrayList<>(), lower = new ArrayList<>();
        for (char c : chars) {
            if (Character.isUpperCase(c)) upper.add(c);
            else lower.add(c);
        }
        Collections.sort(upper);
        Collections.sort(lower);
        StringBuilder res = new StringBuilder();
        int u = 0, l = 0;
        for (char c : chars) {
            if (Character.isUpperCase(c)) res.append(upper.get(u++));
            else res.append(lower.get(l++));
        }
        return res.toString();
    }
}
