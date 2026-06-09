package binary_tree;

public class BinaryTree {
    class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public void insertInbinaryTree(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            while (temp != null) {
                if (temp.val > newNode.val) {
                    if (temp.left == null) {
                        temp.left = newNode;
                        return;
                    } else {
                        temp = temp.left;
                    }
                } else if (temp.val < newNode.val) {
                    if (temp.right == null) {
                        temp.right = newNode;
                        return;
                    } else {
                        temp = temp.right;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean conTains(int x) {
        if (root == null)
            return false;
        else {
            Node temp = root;
            while (temp != null) {
                if (temp.val == x)
                    return true;
                else if (temp.val < x) {
                    temp = temp.right;
                } else {
                    temp = temp.left;
                }
            }
        }
        return false;
    }
    public boolean removeNode(int x){
        if(root==null) return false;
        else{
            Node temp=root;
            while(temp!=null){
                if(temp.val==x) return true;
                else if(temp.val<x){
                 if(temp.right!=null && temp.right.val==x){
                    temp.right=null;
                    return true;
                 } else{
                    temp=temp.right;
                 }
                }
                else{
                    if(temp.left!=null && temp.left.val==x){
                    temp.left=null;
                    return true;
                 } else{
                    temp=temp.left;
                 }
                }
            }
        }
        return false;
    }

    public void printTree() {
        System.out.print("Sorted BST Elements: ");
        inOrderHelper(root);
        System.out.println(); // Just prints a new line at the very end
    }

    // 2. The private recursive helper that does the heavy lifting
    private void inOrderHelper(Node node) {
        // Base Case: If we hit a null pointer, turn back!
        if (node == null) {
            return;
        }

        // Step 1: Recurse down the LEFT subtree
        inOrderHelper(node.left);

        // Step 2: Print the CURRENT node's value
        System.out.print(node.val + " ");

        // Step 3: Recurse down the RIGHT subtree
        inOrderHelper(node.right);
    }

    public static void main(String[] args) {
        BinaryTree obj = new BinaryTree();
        obj.insertInbinaryTree(1);
        obj.insertInbinaryTree(-60);
        obj.insertInbinaryTree(23);
        obj.printTree();
        System.out.println("The element 23 is tere: " + obj.conTains(23));
        System.out.println("Removed the element is: "+obj.removeNode(-60));
        obj.printTree();
    }
}