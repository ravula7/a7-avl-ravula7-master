package a7;

public class Main {
    public static void main(String[] args) {

        // Create a new empty tree.
        SelfBalancingBST<Integer> avl = new AVLTree<Integer>();
        avl.insert(20);
        avl.insert(11);
        avl.insert(50);
        avl.insert(4);
        avl.insert(6);
        avl.insert(15);
        avl.insert(3);
        avl.insert(16);
        avl.insert(17);
        avl.insert(2);
        avl.remove(20);
        avl.remove(4);
        avl.remove(3);


        /*
 avl.insert(47);
        avl.insert(52);
        avl.insert(60);
        avl.insert(3);
        avl.insert(7);
        avl.insert(10);
        avl.insert(58);
        // Insert 50 random integers.
        // Note how we need to capture the result of insert back into
        // the variable avl_bst because the post insertion root that is
        // returned might change because of the insertion

        for (int i=0; i<50; i++) {
            avl_bst = avl_bst.insert((int) (Math.random()*100));
        }

        System.out.println(avl_bst.height());

        // Now insert 50 integers in increasing order which would
        // cause a simple BST to become very tall but for our
        // self-balancing tree won't be too bad.

        for (int i=0; i<50; i++) {
            avl_bst = avl_bst.insert(i);
        }

        System.out.println(avl_bst.height());

         */
    }
}
