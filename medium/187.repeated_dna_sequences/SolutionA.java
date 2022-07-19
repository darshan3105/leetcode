// https://leetcode.com/problems/repeated-dna-sequences/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length()-10+1;i++) {
            String cur = s.substring(i, i+10);
            if(set.contains(cur)) {
                result.add(cur);
            }
            set.add(cur);
        }
        
        return new ArrayList<>(result);
    }
}