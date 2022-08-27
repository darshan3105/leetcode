// https://leetcode.com/problems/repeated-string-match/

class SolutionA {
    
    private static final int prime = 31;
    
    public int repeatedStringMatch(String a, String b) {
        String s = "";
        int cnt=0;
        while(s.length() < b.length()) {
            s+=a;
            cnt++;
        }
        if(isPresent(s, b)) {
            return cnt;
        }
        else {
            cnt++;
            s+=a;
            if(isPresent(s, b)) {
                return cnt;
            }
            return -1;
        }
    }
    
    private boolean isPresent(String s, String b) {
        int n = b.length();
        long hash_b = getHash(b);
        long hash_s = getHash(s.substring(0, n));
        if(hash_b==hash_s) {
            if(b.equals(s.substring(0, n))) {
                return true;
            }
            return false;
        }
        
        long adder = (long)Math.pow(prime, n-1);
        for(int i=n;i<s.length();i++) {
            hash_s = ((hash_s - (int)(s.charAt(i-n)))/prime) + ((long)s.charAt(i)*adder);
            if(hash_b==hash_s) {
                if(b.equals(s.substring(i-n+1, i+1))) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    
    private long getHash(String s) {
        long mult = 1, hash=0;
        for(int i=0;i<s.length();i++) {
            hash+=((long)(s.charAt(i))*mult);
            mult*=prime;
        }
        return hash;
    }
}