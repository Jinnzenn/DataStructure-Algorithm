package Chapter202SpecificProblemsAndAlgorithm.BigData;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DynamicGraph<T> {
    private int numOfNodes;
    private Set<Node<T>> graph;
    
    public DynamicGraph() {
        graph = new HashSet<>();
        this.numOfNodes = 0;
    }
    public void add(Node<T> a){
        graph.add(a);
    }
    public void connect(Node<T> a, Node<T> b){
        a.adjNodes.add(b);
    }
    
    public boolean isConnected(Node<T> a, Node<T> b) {
        Set<Node<T>> seen = new HashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();
        for (Node<T> adj : a.adjNodes) {
            queue.offer(adj);
        }
        while (!queue.isEmpty()) {
            Node<T> cur = queue.poll();
            if (cur.equals(b)) {
                return true;
            }
            for (Node<T> adj : cur.adjNodes) {
                if (!seen.contains(adj)) {
                    queue.offer(adj);
                }
            }
            seen.add(cur);
        }
        return false;
    }
    
    static class Node<T> {
        Set<Node<T>> adjNodes;
        T val;
        
        public Node(T val) {
            this.val = val;
            adjNodes = new HashSet<>();
        }
    }
    public static void main(String[] args){
        DynamicGraph<Integer> dynamicGraph = new DynamicGraph<>();
        Node<Integer> node1 = new Node(1);
        Node<Integer> node2 = new Node(2);
        dynamicGraph.add(node1);
        dynamicGraph.add(node2);
        dynamicGraph.connect(node1, node2);
        System.out.println(dynamicGraph.isConnected(node1, node2));
    }
}
