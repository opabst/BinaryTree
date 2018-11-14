package de.oliverpabst.runs;

import de.oliverpabst.adts.BinaryTree;
import de.oliverpabst.adts.BinaryTreeNode;

import java.util.Stack;

public class PreorderRun<T> {
    public void preOrder(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        System.out.println(startNode.toString());

        if(!tree.isExternal(startNode)) {
            preOrder(tree, startNode.getLeftChild());
            preOrder(tree, startNode.getRightChild());
        }
    }

    public void preorderIter(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        Stack<BinaryTreeNode<T>> s = new Stack<>();

        s.push(startNode);

        while(!s.isEmpty()) {
            BinaryTreeNode<T> pos = s.pop();

            if(tree.isInternal(pos)) {
                System.out.println(pos.toString());
                s.push(tree.getRightChild(pos));
                s.push(tree.getLeftChild(pos));
            }
        }
    }
}
