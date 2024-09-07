// TC: O(nlogn)
// SC: O(n)

class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) {
            return s;
        }

        int row=0,col=0;
        boolean dir = false; // 0 means down and 1 means right
        final List<Node> nodes = new ArrayList<Node>();
        for (int i=0;i<s.length();i++) {
            nodes.add(new Node(row, col, s.charAt(i)));
            int nextRow = dir ? row-1 : row+1;
            int nextCol = dir ? col+1 : col;
            if (nextRow>=0 && nextRow<numRows) {
                row=nextRow;
                col=nextCol;
            } else {
                dir = !dir;
                row = dir ? row-1 : row+1;
                col = dir ? col+1 : col;
            }
        }

        Collections.sort(nodes, (node1, node2) -> {
            if (node1.row==node2.row) {
                return node1.col < node2.col ? -1 : 1;
            }

            return node1.row < node2.row ? -1 : 1;
        });

        final StringBuilder sb = new StringBuilder();
        nodes.forEach(node -> sb.append(node.val));
        return sb.toString();
    }
}

class Node {
    int row;
    int col;
    char val;

    public Node(int row, int col, char val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
