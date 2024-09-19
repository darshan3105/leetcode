// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

class SolutionA {
    public List<String> letterCombinations(String digits) {
        final Map<Character, String> mp = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> result =  compute(digits, 0, mp);
        return result.size() == 1 ? Collections.emptyList() : result;
    }

    private List<String> compute(String digits, int index, Map<Character, String> mp) {
        if (index==digits.length()) {
            return Arrays.asList("");
        }

        char currChar = digits.charAt(index);
        List<String> strs = compute(digits, index+1, mp);
        List<String> result = new ArrayList<>();

        String charStr = mp.get(currChar);
        for (int i=0;i<charStr.length();i++) {
            for (int j=0;j<strs.size();j++) {
                result.add(charStr.charAt(i) + strs.get(j));
            }
        }

        return result;
    }
}
