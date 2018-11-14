package de.oliverpabst.adts;

import java.util.ArrayList;

public class BinaryTree<T> {

    private int size = 0;

    private BinaryTreeNode<T> root;

    public BinaryTree() {
        root = new BinaryTreeNode<T>(null, null, null, null);
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<BinaryTreeNode<T>> getPositions() {
        //new NotImplementedException();
        return null;
    }

    public ArrayList<T> getContents() {
        //new NotImplementedException();
        return null;
    }

    public boolean isRoot(BinaryTreeNode node) {
        if(node.getParent() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExternal(BinaryTreeNode node) {
        if(node.getLeftChild() == null && node.getRightChild() == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isInternal(BinaryTreeNode node) {
        if(node.getLeftChild() != null || node.getRightChild() != null) {
            return true;
        } else {
            return false;
        }
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public BinaryTreeNode<T> getParent(BinaryTreeNode node) {
        return node.getParent();
    }

    public ArrayList<BinaryTreeNode<T>> getChildren(BinaryTreeNode node) {
        ArrayList<BinaryTreeNode<T>> list = new ArrayList<>();
        if(node.getLeftChild() != null) {
            list.add(node.getLeftChild());
        }
        if(node.getRightChild() != null) {
            list.add(node.getRightChild());
        }
        return list;
    }

    public void swap(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2) {
        T temp = node1.getContent();
        node1.setContent(node2.getContent());
        node2.setContent(temp);
    }

    public T replaceAtPos(BinaryTreeNode<T> node, T content) {
        T temp = node.getContent();
        node.setContent(content);
        return temp;
    }

    public BinaryTreeNode getLeftChild(BinaryTreeNode node) {
        return node.getLeftChild();
    }

    public BinaryTreeNode getRightChild(BinaryTreeNode node) {
        return node.getRightChild();
    }

    public BinaryTreeNode getSibling(BinaryTreeNode node) {
        BinaryTreeNode<T> parent = node.getParent();
        if(parent.getLeftChild().equals(node)) {
            return parent.getRightChild();
        } else {
            return parent.getLeftChild();
        }
    }

    public void expandExternal(BinaryTreeNode node) {
        if(!isExternal(node)) {
            new IllegalAccessException();
        } else {
            node.setLeftChild(new BinaryTreeNode<T>(null, node, null, null));
            node.setRightChild(new BinaryTreeNode<T>(null, node, null, null));
            size = size + 2;
        }
    }

    public void removeAboveExternal(BinaryTreeNode node) {
        if(isRoot(node) || !isExternal(node)) {
            new IllegalAccessException();
        }

        BinaryTreeNode<T> parent = getParent(node);
        BinaryTreeNode<T> sibling = getSibling(node);

        if(isRoot(parent)) {
            root = sibling;
            sibling.setParent(null);
        } else {
            BinaryTreeNode<T> grandparent = getParent(parent);
            if(getLeftChild(grandparent).equals(parent)) {
                grandparent.setLeftChild(sibling);
            } else {
                grandparent.setRightChild(sibling);
            }
            sibling.setParent(grandparent);
        }

        size = size - 2;
    }
}
