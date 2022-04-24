// https://leetcode.com/problems/minimum-window-substring/
// TC: O(m+n) where m = length of s, n = length of t
// SC: O(1)

class SolutionA {
    public String minWindow(String s, String t) {
        int start=-1, end=-1;
        int l=0,r=0;
        
        Map<Character, Integer> mp = new HashMap<>();
        
        for(int i=0;i<t.length();i++) {
            int freq = mp.getOrDefault(t.charAt(i), 0);
            mp.put(t.charAt(i), ++freq);
        }
        
        remove(mp, s.charAt(r));
        while(r<s.length()) {
            if(l>r) {
                r++;
            }
            else {
                if(found(mp)) {
                    if(start==-1 || r-l<end-start) {
                        start = l;
                        end = r;
                    }
                    
                    add(mp, s.charAt(l));
                    l++;
                }
                else {
                    r++;
                    if(r==s.length()) {
                        break;
                    }
                    
                    remove(mp, s.charAt(r));
                }
            }
        }
        
        if(start==-1) {
            return "";
        }
        else {
            return s.substring(start, end+1);
        }
    }
    
    private void add(Map<Character, Integer> mp, char ch) {
        if(!mp.containsKey(ch)) {
            return;
        }
        
        int freq = mp.get(ch);
        mp.put(ch, ++freq);
    }
    
    private void remove(Map<Character, Integer> mp, char ch) {
        if(!mp.containsKey(ch)) {
            return;
        }
        
        int freq = mp.get(ch);
        mp.put(ch, --freq);
    }
    
    private boolean found(Map<Character, Integer> mp) {
        for(char ch : mp.keySet()) {
            if(mp.get(ch)>0) {
                return false;
            }
        }
        return true;
    }
}