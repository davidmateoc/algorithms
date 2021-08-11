package algorithms.trees;

/**
 * Created by davidmateo on 2021-07-06
 */

public class BinarySearchNode {
    int data;
    BinarySearchNode left;
    BinarySearchNode right;

    public BinarySearchNode(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if(value <= data) {
            if(left == null) {
                left = new BinarySearchNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if(right == null) {
                right = new BinarySearchNode(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if(value == data) {
            return true;
        } else if(value < data) {
            if(left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if(right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public static int height(BinarySearchNode root) {
        if(root == null) {
            return 0;
        }
        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        return Math.max(heightLeft, heightRight) + 1;
    }

    public static void topView(BinarySearchNode root) {
        top_left(root.left);
        System.out.print(root.data + " ");
        top_right(root.right);
    }

    public static void top_left(BinarySearchNode root) {
        if(root == null) {
            return;
        }
        top_left(root.left);
        System.out.print(root.data + " ");
    }

    public static void top_right(BinarySearchNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        top_right(root.right);
    }

    public void printInOrder() {
        if(left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if(right != null) {
            right.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.println(data);
        if(left != null) {
            left.printPreOrder();
        }
        if(right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if(left != null) {
            left.printPostOrder();
        }
        if(right != null) {
            right.printPostOrder();
        }
        System.out.println(data);
    }

    public void printReverse() {
        if(right != null) {
            right.printReverse();
        }
        System.out.println(data);
        if(left != null) {
            left.printReverse();
        }
    }
}
