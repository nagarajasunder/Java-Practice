public class BST {

    public static void main(String[] args) {
        Tree root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);


        System.out.println("Inorder");
        inOrder(root);
        System.out.println();
        System.out.println("Preorder");
        preOrder(root);
        System.out.println();
        System.out.println("Post Order");
        postOrder(root);
        System.out.println();
        System.out.println("Search Result");
        System.out.println(treeSearch(root,4).key);
    }

    public static void inOrder(Tree root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    public static void preOrder(Tree root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void postOrder(Tree root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    public static Tree treeSearch(Tree root, int search) {
        if (root == null || root.key == search) {
            return root;
        }
        if (root.key < search) {
            return treeSearch(root.left, search);
        }
        return treeSearch(root.right, search);
    }


}

class Tree {
    Tree left;
    Tree right;
    int key;

    public Tree(int value) {
        this.key = value;
        left = null;
        right = null;
    }


}
