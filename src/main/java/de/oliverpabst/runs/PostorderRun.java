package de.oliverpabst.runs;

import de.oliverpabst.adts.BinaryTree;
import de.oliverpabst.adts.BinaryTreeNode;

import java.util.ArrayList;

public class PostorderRun<T>
{
    public void postorder(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        ArrayList<BinaryTreeNode<T>> children = tree.getChildren(startNode);
        for(BinaryTreeNode<T> child: children) {
            postorder(tree, child);
        }
        System.out.println(startNode.toString());
    }

    public void postorderIter(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {

    }
}
