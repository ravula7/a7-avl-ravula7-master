package a7;

public class AVLTree<T extends Comparable<T>> implements SelfBalancingBST<T> {
    // Put your fields here.
    private T _element;
    private AVLTree<T> left;
    private AVLTree<T> right;
    //private int height;
    //private AVLTree<T> root;

    // Your code for constructor here.
    public AVLTree() { //an empty AVL Tree
        _element = null;
        left = null;
        right = null;
    }
    public AVLTree(T element) { //a non-empty AVL Tree
        _element = element;
        left = new AVLTree <T>();
        right = new AVLTree <T>();
    }
    @Override
    public int height() {
        if(isEmpty() == true){
            return 0;
        }
        return 1 + Math.max(left.height(), right.height());
    }
    @Override
    public SelfBalancingBST<T> insert(T element) {
        if (_element == null){
            new AVLTree<T>(element); //create a new non-empty tree with the element inserted
        }
        else {
            if (element.compareTo(_element) >= 0) { //recurse to the right because element is larger or the same
                this.right.insert(element); //root.right(AVLTree<T>) root.right.insert(element);
            }
            else if (element.compareTo(_element) < 0) { //recurse to the left because element is smaller
                this.left.insert(element); //root.left = (AVLTree<T>) root.left.insert(element);
            }
        }
        //check heights and re balance if necessary
        int balanceFactor = this.left.height() - this.right.height();
        //root.height = Math.max(root.left.height,root.right.height)+1;
        //int balanceFactor = root.left.height()-root.right.height();

        if(balanceFactor < -1){ //right right or right left
            //right right case - just rotate left
            if(right.getRight().height()<right.getLeft().height()){
                right = right.rotateLeft();
            }
            //right left case - rotate right, then rotate left
            else{
                this.right = rotateRight();
                right = right.rotateLeft();
            }
        }
        else if(balanceFactor > 1){ //left left or left right
            //left left case - just rotate right
            if(left.getLeft().height() < left.getRight().height()){ //root.getLeft().height() < root.getRight().height())
                left = left.rotateRight();
            }
            //left right case - rotate left, then rotate right
            else{
                this.left = rotateLeft();
                left = left.rotateRight();
            }
        }
        return this;
    }

    /**
     *
     * Rotates the tree left and returns
     * AVLTree root for rotated result.
     */
    
     private AVLTree<T> rotateLeft() {
         // You should implement left rotation and then use this 
         // method as needed when fixing imbalances.
         AVLTree<T> rightSide = this.right; //set the right tree (the root of this tree will move up to the parent's root)
         this.right = rightSide.left; //brings right's child up and sends it to the left
         rightSide.left=this; //puts the right side's left tree to the root (rotated left)

         //update the heights
         //root.height = Math.max(root.left.height(),root.right.height())+1;
         //rightSide.height = Math.max(rightSide.left.height(),rightSide.right.height())+1;
         return rightSide;
     }
    
    /**
     *
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */ 
     
     private AVLTree<T> rotateRight() {
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.
         AVLTree<T> leftSide = this.left;
         this.left = leftSide.right;
         leftSide.right = this;

         //update the height field
         //root.height = Math.max (root.left.height(),root.right.height())+1;
         //leftSide.height =Math.max (leftSide.left.height(),leftSide.right.height())+1;
         return leftSide;
     }

    // Your code for public methods here.
    @Override
    public boolean isEmpty() {
        if(this==null){
            return true;
        }
         return false;
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
        if(this == null){
            return 0;
        }
        return sizeOfLeft+sizeOfRight+1;
    }

    @Override
    public SelfBalancingBST<T> remove(T element) {
        if (element.compareTo((T) this) > 0) { //recurse to the right because element is larger
            right = (AVLTree) right.remove(element);
        }
        else if (element.compareTo((T) this) <0) { //recurse to the left because element is smaller
            left = (AVLTree) left.remove(element);
        }
        else if(left.isEmpty() && right.isEmpty()){
           // EmptyBST<T> emptyTree = new EmptyBST<T>();
            return null;
        }
        else if(!left.isEmpty() && right.isEmpty()){
            return left;
        }
        else if(left.isEmpty() && !right.isEmpty()){
            return right;
        }
        else if (!left.isEmpty() && !right.isEmpty()){
            T minimum = (T) right.findMin();
            //root = (AVLTree) minimum;
            right = (AVLTree) right.remove(minimum);
        }
        return this;
    }

    @Override
    public T findMin() {
        T minimum =  _element;
        if(!left.isEmpty()) {
            minimum =left.findMin();
        }
        else if(left.isEmpty()){
            minimum = this._element;
        }
        return minimum;
    }

    @Override
    public T findMax() {
        T maximum =  _element;
        if(!right.isEmpty()) {
            maximum =right.findMax();
        }
        else if(right.isEmpty()){
            maximum = this._element;
        }
        return maximum;
    }

    @Override
    public boolean contains(T element) {
        if(this.isEmpty()){ //when the tree is empty, it contains no elements
            return false;
        }
        else if(element.compareTo(_element) == 0){ //found the element!
            return true;
        }
        else if(element.compareTo(_element) > 0){ //need to recurse right to find the element
            return getRight().contains(element); //return true or false whether the right side contains the element or not
        }
        else if(element.compareTo(getValue()) < 0){ //need to recurse left to find the element
            return getLeft().contains(element); //return true or false whether the left side contains the element or not
        }
        return false; //otherwise
    }

    @Override
    public T getValue() {
        return (T) _element;
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
