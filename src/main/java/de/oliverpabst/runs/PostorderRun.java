package de.oliverpabst.runs;

import de.oliverpabst.adts.BinaryTree;
import de.oliverpabst.adts.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderRun<T>
{
    public void postorder(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        ArrayList<BinaryTreeNode<T>> children = tree.getChildren(startNode);
        for(BinaryTreeNode<T> child: children) {
            postorder(tree, child);
        }
        System.out.println(startNode.toString());
    }

    // TODO: fixme
    public void postorderIter(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        Stack<BinaryTreeNode<T>> s = new Stack<>();
        s.push(startNode);
        while(s.isEmpty()) {
            BinaryTreeNode<T> node = s.pop();
            if(tree.isExternal(node)) {
                System.out.println(node.toString());
            }
            s.push(node);
            s.push(tree.getRightChild(node));
            s.push(tree.getLeftChild(node));

        }

    }
}
