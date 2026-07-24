/*
Definition for a Node.
class Node {
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
*/

class Solution {

    HashMap<Node, Node> mp = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        mp.clear();

        Node cloneNode = new Node(node.val);

        mp.put(node, cloneNode);

        dfs(node, cloneNode);

        return cloneNode;
    }

    private void dfs(Node node, Node cloneNode) {

        for (Node neighbour : node.neighbors) {

            if (!mp.containsKey(neighbour)) {

                Node newClone = new Node(neighbour.val);

                mp.put(neighbour, newClone);

                cloneNode.neighbors.add(newClone);

                dfs(neighbour, newClone);

            } else {

                cloneNode.neighbors.add(mp.get(neighbour));

            }
        }
    }
}