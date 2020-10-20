package a7;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Put your fields here.
    
    public AVLTree() {
        // Your code for constructor here.
    }

    /**
     *
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
    
     private void rotateLeft() {//AVLTree<T>
         // You should implement left rotation and then use this 
         // method as needed when fixing imbalances.
     }
    
    /**
     *
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */ 
     
     private void rotateRight() {//AVLTree<T>
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.
     }

    // Your code for public methods here.
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int height() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
        return null;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
        return null;
    }

    @Override
    public T findMin() {
        return null;
    }

    @Override
    public T findMax() {
        return null;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public T getValue() {
        return null;
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        return null;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        return null;
    }



}
