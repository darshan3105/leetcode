// https://leetcode.com/problems/restore-ip-addresses/

class SolutionA {
    
    List<String> result = new ArrayList<>();
    
    public List<String> restoreIpAddresses(String s) {
        List<String> cur = new ArrayList<>();
        calculate(s, cur, 0);
        return result;
    }
    
    private void calculate(String s, List<String> cur, int start) {
        if(cur.size()==4) {
            if(start>=s.length()) {
                String val = cur.get(0) + "." + cur.get(1) + "." + cur.get(2) + "." + cur.get(3);
                result.add(val);
            }
            return;
        }
        
        for(int end=start;end<start+3 && end<s.length();end++) {
            if(!isValid(s, start, end)) {
                continue;
            }
            
            cur.add(s.substring(start, end+1));
            calculate(s, cur, end+1);
            cur.remove(cur.size()-1);
        }
    }
    
    private boolean isValid(String s, int start, int end) {
        if(end-start+1==1) {
            return true;
        }
        else if(end-start+1==2) {
            if(s.charAt(start)=='0') {
                return false;
            }
            else {
                return true;
            }
        }
        else {
            if(s.charAt(start)=='0' || s.charAt(start)>'2') {
                return false;
            }
            else if(s.charAt(start)=='1') {
                return true;
            }
            else {
                if(s.charAt(start+1)=='5' && s.charAt(end)>'5') {
                    return false;
                } 
                else if(s.charAt(start+1)>'5') {
                    return false;
                }
                else {
                    return true;
                }
            }
        }        
    }
}