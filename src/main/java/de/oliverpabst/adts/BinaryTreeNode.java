package de.oliverpabst.adts;

public class BinaryTreeNode<T> {

    private T content;
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T _content, BinaryTreeNode<T> _parent, BinaryTreeNode<T> _leftChild, BinaryTreeNode<T> _rightChild)  {
        content = _content;
        parent = _parent;
        leftChild = _leftChild;
        rightChild = _rightChild;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T _content) {
        content = _content;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTreeNode node) {
        parent = node;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode node) {
        leftChild = node;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode node) {
        rightChild = node;
    }

    public String toString() {
        if (content != null) {
            return content.toString();
        } else {
            return "none";
        }
    }
}
