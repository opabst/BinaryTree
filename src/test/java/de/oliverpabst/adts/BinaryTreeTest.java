package de.oliverpabst.adts;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private BinaryTree<String> setup() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.getRoot().setContent("A");

        tree.expandExternal(tree.getRoot());

        tree.expandExternal(tree.getRoot().getLeftChild());
        tree.expandExternal(tree.getRoot().getRightChild());

        tree.getRoot().getLeftChild().setContent("B");

        tree.getRoot().getRightChild().setContent("C");

        tree.expandExternal(tree.getRoot().getRightChild().getLeftChild());

        tree.getRoot().getRightChild().getLeftChild().setContent("D");

        return tree;
    }

    @Test
    public void size() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void getPositions() {
    }

    @Test
    public void getContents() {
    }

    @Test
    public void isRoot() {
    }

    @Test
    public void isExternal() {
    }

    @Test
    public void isInternal() {
    }

    @Test
    public void getRoot() {
    }

    @Test
    public void getParent() {
    }

    @Test
    public void getChildren() {
    }

    @Test
    public void swap() {
    }

    @Test
    public void replaceAtPos() {
    }

    @Test
    public void getLeftChild() {
    }

    @Test
    public void getRightChild() {
    }

    @Test
    public void getSibling() {
    }

    @Test
    public void expandExternal() {
    }

    @Test
    public void removeAboveExternal() {
    }
}