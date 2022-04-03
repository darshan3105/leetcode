// https://leetcode.com/problems/group-anagrams/
// TC: O(n)
// SC: O(n) 
// where n is the size of strs

class SolutionA {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        
        for(String str : strs) {
            char[] arr = str.toCharArray();
            int[] freq = new int[26];
            
            for(int i=0;i<arr.length;i++) {
                freq[arr[i]-'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++) {
                sb.append(String.valueOf(freq[i]));
                sb.append("#");
            }
            
            List<String> bucket = mp.getOrDefault(sb.toString(), new ArrayList<>());
            bucket.add(str);
            mp.put(sb.toString(), bucket);
        }
        
        return mp.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
        
    }
}