import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L133 {
    /**
     * 给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
     *
     * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
     *
     * class Node {
     *     public int val;
     *     public List<Node> neighbors;
     * }
     */
    public static void main(String[] args) {

        Node node = new Node(1);
        node.neighbors.add(new Node(2));
        node.neighbors.add(new Node(3));
        node.neighbors.add(new Node(4));
        System.out.println(cloneGraph(node));
    }
    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // 使用哈希表来存储已经克隆过的节点
        Map<Node, Node> visited = new HashMap<>();
        return clone(node, visited);
    }
    public static Node clone(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            // 如果已经克隆过该节点，则直接返回
            return visited.get(node);
        }
        // 创建新节点
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        // 遍历原节点的所有邻居，并递归克隆
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(clone(neighbor, visited));
        }

        return cloneNode;
    }
// Definition for a Node.
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
