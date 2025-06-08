class Solution {
    public boolean isSumString(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = 1; i + j < n; j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, i + j);
                if ((s1.length() > 1 && s1.charAt(0) == '0') || (s2.length() > 1 && s2.charAt(0) == '0'))
                    continue;
                if (isValid(s1, s2, s.substring(i + j)))
                    return true;
            }
        }
        return false;
    }

    private boolean isValid(String s1, String s2, String rem) {
        String sum = addStrings(s1, s2);
        if (!rem.startsWith(sum))
            return false;
        if (rem.equals(sum))
            return true;
        return isValid(s2, sum, rem.substring(sum.length()));
    }

    private String addStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int d1 = i >= 0 ? a.charAt(i--) - '0' : 0;
            int d2 = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = d1 + d2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }
        return sb.reverse().toString();
    }
}
