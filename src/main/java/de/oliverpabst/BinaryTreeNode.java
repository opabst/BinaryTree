package de.oliverpabst;

public class BinaryTreeNode<T> {

    private T content;
    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode(T content, BinaryTreeNode<T> parent, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild)  {

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
}
