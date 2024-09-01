class SolutionA {
    public int romanToInt(String s) {
        final Map<String, Integer> mp = new HashMap<>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }};

        int result = 0;
        int i=0;
        while(i<s.length()) {
            String ch = "" + s.charAt(i);
            if (i < s.length()-1) {
                String ch2 = ch + s.charAt(i+1);
                if (mp.containsKey(ch2)) {
                    result += mp.get(ch2);
                    i += 2;
                    continue;
                }
            }
            result += mp.get(ch);
            i++;
        }

        return result;
    }
}
