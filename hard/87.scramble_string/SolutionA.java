// https://leetcode.com/problems/scramble-string/

class SolutionA {
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> mp = new HashMap<>();
        return solve(s1, s2, mp);
    }
    
    private boolean solve(String s1, String s2, Map<String, Boolean> mp) {
        String key = s1+"*"+s2;
        if(s1.length() == 1) {
            if(s1.equals(s2)) {
                mp.put(key, true);
                return true;
            }
            else {
                mp.put(key, false);
                return false;
            }
        }
        
        if(s1.equals(s2)) {
            mp.put(key, true);
            return true;
        }
     
        if(mp.containsKey(key)) {
            return mp.get(key);
        }
        
        int len = s1.length();
        for(int i=0;i<len-1;i++) {
            if(solve(s1.substring(0, i+1), s2.substring(0, i+1), mp) &&
              solve(s1.substring(i+1, len), s2.substring(i+1, len), mp)) {
                mp.put(key, true);
                return true;
            }
            if(solve(s1.substring(0, i+1), s2.substring(len-i-1, len), mp) &&
              solve(s1.substring(i+1, len), s2.substring(0, len-i-1), mp)) {
                mp.put(key, true);
                return true;
            }
        }
        
        mp.put(key, false);
        return false;
    }
}