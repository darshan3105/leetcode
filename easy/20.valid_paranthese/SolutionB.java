class SolutionB {
    public boolean isValid(String s) {
        final Stack st = new Stack<Character>();
        for (int i=0;i<s.length();i++) {
            final char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (isValidBrac(st, ch)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        return st.empty();
    }

    private boolean isValidBrac(final Stack<Character> st, final char ch) {
        if (st.empty()) {
            return false;
        }

        char top = st.peek();
        return (ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[');
    }
}
