package de.oliverpabst.runs;

import de.oliverpabst.adts.BinaryTree;
import de.oliverpabst.adts.BinaryTreeNode;

public class PostorderRun<T>
{
    public void postorder(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        if(tree.isExternal(startNode)) {
            System.out.println(startNode.toString());
        } else {
            postorder(tree, startNode.getLeftChild());
            postorder(tree, startNode.getRightChild());
        }
    }

    public void postorderIter(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {

    }
}
