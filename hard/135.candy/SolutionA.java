import java.util.Stack;

// https://leetcode.com/problems/candy/
// TC: O(n)
// SC: O(n)

class SolutionA {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++) {
            if(i==0) {
                if(i+1==n || ratings[i+1]>=ratings[i]) {
                    stack.push(i);
                }    
            }
            else if(i==n-1) {
                if(i-1==-1 || ratings[i]<=ratings[i-1]) {
                    stack.push(i);
                }
            }
            else if(ratings[i]<=ratings[i-1] && ratings[i]<=ratings[i+1]) {
                stack.push(i);
            }
        }
        
        while(!stack.isEmpty()) {
            int index = stack.pop();
            candies[index]=1;
            for(int i=index+1;i<n;i++) {
                int curCandies = ratings[i] == ratings[i-1] ? 1 : candies[i-1]+1;
                candies[i]=Math.max(candies[i], curCandies);
                if(i!=n-1 && ratings[i]>ratings[i+1]) {
                    break;
                }
            }
            for(int i=index-1;i>=0;i--) {
                int curCandies = ratings[i]==ratings[i+1] ? 1 : candies[i+1]+1;
                candies[i]=Math.max(candies[i], curCandies);
                if(i!=0 && ratings[i]>ratings[i-1]) {
                    break;
                }
            }
        }
        
        int result=0;
        for(int i=0;i<n;i++) {
            result+=candies[i];
        }
        
        return result;
    }
}