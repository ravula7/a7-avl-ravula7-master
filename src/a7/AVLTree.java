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
    public boolean isEmpty() {
        if(this._element == null) {
          return true;
        }
        return false;
    }
    public int balanceFactor(){
        if(left == null || left.isEmpty()){
            return 0 - right.height();
        }
        if(right == null||right.isEmpty()){
            return left.height()-0;
        }
        if(left.isEmpty() && right.isEmpty()){
            return 0;
        }
            return left.height()-right.height();
    }
    public AVLTree rebalance(int balanceFactor) {
        if (balanceFactor > 1) {
            if (left.left.height() < left.right.height()) {
                left = left.rotateLeft();
            }
            return rotateRight();
        }
        else {
            if (right.left.height() > right.right.height()) {
                right = right.rotateRight();
            }
            return rotateLeft();
        }
    }




        /*if(balanceFactor < -1){ //right right or right left
            //right right case - just rotate left
            if(right.right.height()<right.left.height()){
                right = right.rotateLeft();
            }
            //right left case - rotate right, then rotate left
            else{
                this.right = rotateRight();
                right = right.rotateLeft();
                // right = right.rotateLeft();
            }
        }
        else if(balanceFactor > 1){ //left left or left right
            //left left case - just rotate right
            if(left.left.height() < left.right.height()){ //root.getLeft().height() < root.getRight().height())
                left = left.rotateRight();
            }
            //left right case - rotate left, then rotate right
            else{
                this.left = rotateLeft();
                left = left.rotateRight();
            }
        }
         */


    @Override
    public SelfBalancingBST<T> insert(T element) {
        if(_element == null){
            _element = element;
            return new AVLTree<T>(element);
        }
        else {
            if(element.compareTo(_element)>=0){ //recurse right
              if(right == null){ //if there is nothing in the right, create a new tree with this element
                   right = new AVLTree<T>(element);
                }
                else{ //if there is something in the right, call insert method again
                    right = (AVLTree<T>) right.insert(element);
                }
            }
            else{ // in the other case, recurse left
               if(left == null){ //nothing in the left --> create a new tree with this element
                   left = new AVLTree<T>(element);
               }
              else { //if there is something in the left, call insert method again
                    left = (AVLTree<T>) left.insert(element);
                }
            }
        }
       int balanceFactor = balanceFactor();

        if(balanceFactor <-1 || balanceFactor >1){
        return rebalance(balanceFactor);
        }


        /*

        if (_element == null) { //_element == null{
           _element = element;
           new AVLTree<T>(element);
           return this;
            // new AVLTree<T>(element); //create a new non-empty tree with the element inserted
        }
        else {
            /*if(element.compareTo(getValue())<0) {
                if (left == null){
                    left = new AVLTree<>();
                }
                left = (AVLTree) left.insert(element);
            }
            else if (element.compareTo(getValue())>=0){
                if(right == null){
                    right = new AVLTree<>();
                }
                right = (AVLTree) right.insert(element);
            }

            if (element.compareTo(_element) >= 0) { //recurse to the right because element is larger or the same
                if(right == null){
                    right = new AVLTree<>(element);
                    return this;
                }
                right.insert(element);
                        //(AVLTree<T>) this.getRight().insert(element);
                //this.right.insert(element); //root.right(AVLTree<T>) root.right.insert(element);
            }
            else if (element.compareTo(_element) < 0) { //recurse to the left because element is smaller
                if (left == null){
                    left = new AVLTree<>(element);
                    return this;
                }
                left.insert(element);
                        //(AVLTree<T>) this.getLeft().insert(element);
                //this.left.insert(element); //root.left = (AVLTree<T>) root.left.insert(element);
            }

        }
         */
        //check heights and re balance if necessary
        //int balanceFactor = root.left.height()-root.right.height();

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
            AVLTree y = this;
            AVLTree x = y.right;
            AVLTree z = x.left;
            x.left = y;
            y.right = z;
            return x;
            /*
            AVLTree<T> rightSide = this.right; //set the right tree (the root of this tree will move up to the parent's root)
            this.right = rightSide.left; //brings right's child up and sends it to the left
            rightSide.left=this;//puts the right side's left tree to the root (rotated left)
            AVLTree <T> main = this;
            AVLTree <T> rightSide = main.right;
            AVLTree <T> leftSide = rightSide.left;
            rightSide.left = main;
            main.right = leftSide;
          */
     }
    
    /**
     *
     * Rotates the tree right and returns
     * AVLTree root for rotated result.
     */ 
     
     private AVLTree<T> rotateRight() {
         // You should implement right rotation and then use this 
         // method as needed when fixing imbalances.
         AVLTree y = this;
         AVLTree x = y.left;
         AVLTree z = x.right;
         x.right = y;
         y.left = z;
         return x;

         /*AVLTree<T> leftSide = this.left;
         this.left = leftSide.right;
         leftSide.right = this;
         AVLTree <T> main = this;
         AVLTree <T> leftSide = main.left;
         AVLTree <T> rightSide = leftSide.left;
         leftSide.right = main;
         main.left = rightSide;
         return leftSide; */
     }

    // Your code for public methods here.


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
         if (isEmpty()) { //remove from empty tree
            return this;
        }
        SelfBalancingBST<T> original = this;
        if (element.compareTo(getValue()) > 0) { //recurse to the right because element is larger
            right = (AVLTree<T>) right.remove(element);
        }
        else if (element.compareTo(getValue()) < 0) { //recurse to the left because element is smaller
            left = (AVLTree<T>) left.remove(element);
        }
        //different cases
        else{
            if(getLeft().isEmpty() && getRight().isEmpty()){ //no children
                original = new AVLTree<T>();
            }
            else if (getLeft().isEmpty()){ //only right child
                original = getRight();
            }
            else if (getRight().isEmpty()){ //only left child
                original = getLeft();
            }
            else { //2 children so take last - right's min
                T minimum = getRight().findMin();
                original = original.remove(element);
                _element = minimum;
            }
        }
        return original;
    }
/*
        //remove leaf --> has no children
        else if (!left.isEmpty() && !right.isEmpty()) {
            original = new AVLTree<T>();
        }
        //remove when one child
        //only right child exists
        else if (getLeft().isEmpty()) {
            original = (AVLTree<T>) getLeft();
        }
        //only left child exists
        else if (getRight().isEmpty()) {
            original = (AVLTree<T>) getRight();
        }
        //remove when two children exist
        else if (!left.isEmpty() && !right.isEmpty()) {
            T minimum = right.findMin(); //take the last
            original = (AVLTree<T>) original.remove(minimum);
            _element = minimum;

         /*else if(left.isEmpty() && right.isEmpty()){
             // EmptyBST<T> emptyTree = new EmptyBST<T>();
             return null;
         }
         else if(!left.isEmpty() && right.isEmpty()){
            return left;
        }
        else if(left.isEmpty() && !right.isEmpty()){
            return right;
        }
          */


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
