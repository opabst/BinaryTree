package de.oliverpabst.runs;

import de.oliverpabst.adts.BinaryTree;
import de.oliverpabst.adts.BinaryTreeNode;
import de.oliverpabst.adts.KeyValue;

import java.util.Stack;

public class InorderRun<T> {
    public void inorder(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        if(!tree.isExternal(startNode)) {
            inorder(tree, tree.getLeftChild(startNode));
        }
        System.out.println(startNode.toString());
        if(!tree.isExternal(startNode)) {
            inorder(tree, tree.getRightChild(startNode));
        }
    }

    public void inorderIter(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        Stack<KeyValue<BinaryTreeNode<T>, InorderDirection>> s = new Stack();
        s.push(new KeyValue<>(startNode, InorderDirection.DOWN));
        while(!s.empty()) {
            KeyValue<BinaryTreeNode<T>, InorderDirection> item = s.pop();

            if(item.getValue().equals(InorderDirection.DOWN) && tree.isInternal(item.getKey())) {
                s.push(new KeyValue<>(tree.getRightChild(item.getKey()), InorderDirection.DOWN));
                s.push(new KeyValue<>(item.getKey(), InorderDirection.UP));
                s.push(new KeyValue<>(tree.getLeftChild(item.getKey()), InorderDirection.DOWN));
            } if(item.getValue().equals(InorderDirection.UP)) {
                System.out.println(item.getKey().toString());
            } else if (tree.isExternal(item.getKey())) {
                System.out.println(item.getKey().toString());
            }
        }
     }
}
