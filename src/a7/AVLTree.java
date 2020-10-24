package a7;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Put your fields here.
    AVLTree root;
    AVLTree left;
    AVLTree right;

    public AVLTree() {
        // Your code for constructor here.
        SelfBalancingBST<T> avlTree = new AVLTree<T>();
        this.root = root;
        this.left = root.left;
        this.right = root.right;
    }
    /*
    private T _element;
	private BST<T> _left;
	private BST<T> _right;

	public NonEmptyBST(T element) {
		_left = new EmptyBST<T>(); //empty left bst created -- left child
		_right = new EmptyBST<T>(); //empty right bst created -- right child
		_element = element; //element created T
	}
     */

    /**
     *
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
    
     private AVLTree<T> rotateLeft() {
         // You should implement left rotation and then use this 
         // method as needed when fixing imbalances.
     }
    
    /**
     *
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */ 
     
     private AVLTree<T> rotateRight() {
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
         return size()-1;
    }

    @Override
    public int size() {
        int sizeOfLeft=0;
        int sizeOfRight=0;
        if(this.left !=null){
            sizeOfLeft = this.left.size();
        }
        if(this.right != null){
            sizeOfRight=this.right.size();
        }
        if(root == null){
            return 0;
        }
        return sizeOfLeft+sizeOfRight+1;
    }

    @Override
    public SelfBalancingBST<T> insert(T element) {
        if (element.compareTo((T) root) >= 0) { //recurse to the right because element is larger or the same
            right = (AVLTree) right.insert(element);
        }
        else if (element.compareTo((T) root) < 0) { //recurse to the left because element is smaller
            left = (AVLTree) left.insert(element);
        }
        //check for imbalances and rotate if necessary
        if(left.height()-right.height() != 1 ||left.height()-right.height() != 0 || left.height()-right.height() != -1){

        }
        return this;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
        if (element.compareTo(root) > 0) { //recurse to the right because element is larger
            right = (AVLTree) right.remove(element);
        }
        else if (element.compareTo(root) <0) { //recurse to the left because element is smaller
            left = (AVLTree) left.remove(element);
        }
        else if(left.isEmpty() && right.isEmpty()){
            EmptyBST<T> emptyTree = new EmptyBST<T>();
            return emptyTree;
        }
        else if(!left.isEmpty() && right.isEmpty()){
            return left;
        }
        else if(left.isEmpty() && !right.isEmpty()){
            return right;
        }
        else if (!left.isEmpty() && !right.isEmpty()){
            T minimum = (T) right.findMin();
            root = (AVLTree) minimum;
            right = (AVLTree) right.remove(minimum);
        }
        return this;
    }

    @Override
    public T findMin() {
        T minimum = (T) root;
        if(!left.isEmpty()) {
            minimum = (T) left.findMin();
        }
        else if(left.isEmpty()){
            minimum = (T) this.root;
        }
        return minimum;
    }

    @Override
    public T findMax() {
        T maximum =  (T) root;
        if(!right.isEmpty()) {
            maximum = (T) right.findMax();
        }
        else if(right.isEmpty()){
            maximum = (T) this.root;
        }
        return maximum;
    }

    @Override
    public boolean contains(T element) {
        if(this.isEmpty()){ //when the tree is empty, it contains no elements
            return false;
        }
        else if(element.compareTo((T) root) == 0){ //found the element!
            return true;
        }
        else if(element.compareTo((T) root) > 0){ //need to recurse right to find the element
            return getRight().contains(element); //return true or false whether the right side contains the element or not
        }
        else if(element.compareTo(getValue()) < 0){ //need to recurse left to find the element
            return getLeft().contains(element); //return true or false whether the left side contains the element or not
        }
        return false; //otherwise
    }

    @Override
    public T getValue() {
        return (T) root; //or is it null as it was originally?
    }

    @Override
    public SelfBalancingBST<T> getLeft() {
        return left;
    }

    @Override
    public SelfBalancingBST<T> getRight() {
        return right;
    }

}
