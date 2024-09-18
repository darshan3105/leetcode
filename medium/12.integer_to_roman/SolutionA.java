// https://leetcode.com/problems/integer-to-roman/

class SolutionA {
    public String intToRoman(int num) {
        final Map<Integer, String> mp = new LinkedHashMap<>() {{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};
        final List<Integer> keys = new ArrayList<>(mp.keySet());
        final StringBuilder sb = new StringBuilder();
        while(num>0) {
            int m = getLargetsNum(num, keys);
            sb.append(mp.get(m));
            num = num - m;
        }

        return sb.toString();
    }

    private int getLargetsNum(int num, List<Integer> keys) {
        for (int i=keys.size()-1;i>=0;i--) {
            if (keys.get(i)<=num) {
                return keys.get(i);
            }
        }

        return keys.get(0);
    }
}
