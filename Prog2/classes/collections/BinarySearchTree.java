package generics.tutorial.kartenspiel;

public class BinarySearchTree<T> {

    private boolean isEmpty;
    private int key;
    private T data;
    private BinarySearchTree<T> rightChild;
    private BinarySearchTree<T> leftChild;

    public BinarySearchTree(int key, T data) {
        this.isEmpty = false;
        this.key = key;
        this.data = data;
    }

    public BinarySearchTree() {
        this.isEmpty = true;
    }
    public boolean isEmpty() {
        return isEmpty;
    }
    public boolean isLeaf() {
        return rightChild == null && leftChild == null;
    }
    public void insert(int key, T data) {
        if(key < this.key) {
            if(leftChild != null) {
                leftChild.insert(key, data);
            }
            else {
                this.leftChild = new BinarySearchTree<T>(key, data);
            }
        }

        else if(key > this.key) {
            if(rightChild != null) {
                rightChild.insert(key, data);
            }
            else {
                this.rightChild = new BinarySearchTree<T>(key, data);
            }
        }
        else throw new Error();
    }

    public T search(int key) {
        if(key == this.key) return data;
        else if(key < this.key && leftChild != null) {
           return leftChild.search(key);
        }
        else if (key > this.key && rightChild != null) {
            return rightChild.search(key);
        }
        return null;
    }
}
