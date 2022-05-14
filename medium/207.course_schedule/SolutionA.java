// https://leetcode.com/problems/course-schedule/
// TC: O(n)
// SC: O(E) where n = number of nodes, E = number of edges in the graph

class SolutionA {
    public boolean canFinish(int numCourses, int[][] pre) {
        Graph g = new Graph(numCourses);
        for(int i=0;i<pre.length;i++) {
            g.addEdge(pre[i][0], pre[i][1]);
        }
        
        boolean vis[] = new boolean[numCourses];
        boolean done[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++) {
            if(!done[i]) {
                if(isCyclic(g, i, vis, done)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isCyclic(Graph g, int node, boolean[] vis, boolean[] done) {
        if(vis[node]) {
            return true;
        }
        if(done[node]) {
            return false;
        }
        
        vis[node] = true;
        for(int next : g.getNext(node)) {
            if(isCyclic(g, next, vis, done)) {
                return true;
            }
        }
        
        vis[node] = false;
        done[node] = true;
        return false;
    }
}

class Graph {
    List<Integer> adjList[];
    
    public Graph(int size) {
        adjList = new ArrayList[size];
        for(int i=0;i<size;i++) {
            adjList[i] = new ArrayList<>();
        }
    }
    
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }
    
    public List<Integer> getNext(int node) {
        return adjList[node];
    }
}