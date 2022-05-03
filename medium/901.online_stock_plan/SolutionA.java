// https://leetcode.com/problems/online-stock-span/
// TC: O(n)
// SC: O(n)

class StockSpanner {
    
    Stack<Integer> stack;
    int[] price;
    int cur_ptr = 0;

    public StockSpanner() {
        stack = new Stack<>();
        price = new int[100001];
    }
    
    public int next(int pr) {
        int result;
        while(!stack.isEmpty() && price[stack.peek()] <= pr) {
            stack.pop();
        }
        if(stack.isEmpty()) {
            result = cur_ptr + 1;
        }
        else {
            result = cur_ptr - stack.peek();
        }
        stack.push(cur_ptr);
        price[cur_ptr] = pr;
        cur_ptr++;
        
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */