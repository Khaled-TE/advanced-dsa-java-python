public class AVLTree {
    public static class node{
        int data;
        int height;
        node left;
        node right;

        public node(int data){
            this.data = data;
            this.height = 1;
            left = right = null;
        }
    }

    static int heightof(node x){
        return x == null ? 0 : x.height;
    }

    static void updateHeight(node x){
        x.height = 1 + Math.max(heightof(x.left), heightof(x.right));
    }

    static int getbalance(node x){
        return x == null ? 0 : heightof(x.left) - heightof(x.right);
    }

    static node Rrotate(node x){
        node newRoot = x.left;
        x.left = newRoot.right;
        newRoot.right = x;
        updateHeight(x);
        updateHeight(newRoot);
        return newRoot;
    }

    static node Lrotate(node x){
        node newRoot = x.right;
        x.right = newRoot.left;
        newRoot.left = x;
        updateHeight(x);
        updateHeight(newRoot);
        return newRoot;
    }

    public static node Insert(node root, int x){
        if(root == null) return new node(x);
        if(x < root.data) root.left = Insert(root.left, x);
        else if(x > root.data) root.right = Insert(root.right, x);
        else return root;

        updateHeight(root);
        int balance = getbalance(root);

        if (balance > 1 && x < root.left.data) {
            return Rrotate(root);
        }
        if (balance > 1 && x > root.left.data) {
            root.left = Lrotate(root.left);
            return Rrotate(root);
        }
        if (balance < -1 && x > root.right.data) {
            return Lrotate(root);
        }
        if (balance < -1 && x < root.right.data) {
            root.right = Rrotate(root.right);
            return Lrotate(root);
        }
        return root;
    }

    public static void printTree(node root) {
        printHelper(root, 0);
    }
    private static void printHelper(node node, int level) {
        if (node == null) {
            return;
        }

        printHelper(node.right, level + 1);

        String spaces = "";
        for(int i=0; i<level; i++) spaces += "    ";
        System.out.println(spaces + "-> " + node.data);

        printHelper(node.left, level + 1);
    }

    public static void main(String[] args) {
        node root = null;

        int[] values = {10, 20, 30, 40, 50, 25};

        for (int val : values) {
            root = Insert(root, val);
        }

        System.out.println("Final Tree: ");
        printTree(root);
    }
}
