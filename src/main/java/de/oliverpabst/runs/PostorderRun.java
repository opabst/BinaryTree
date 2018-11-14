package de.oliverpabst.runs;

import de.oliverpabst.adts.BinaryTree;
import de.oliverpabst.adts.BinaryTreeNode;
import de.oliverpabst.adts.KeyValue;

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

    public void postorderIter(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        Stack<KeyValue<BinaryTreeNode<T>, PostorderDirection>> s = new Stack<>();
        s.push(new KeyValue<>(startNode, PostorderDirection.DOWN));
        while(!s.isEmpty()) {
            KeyValue<BinaryTreeNode<T>, PostorderDirection> item = s.pop();
            if(item.getValue().equals(PostorderDirection.UP)) {
                System.out.println(item.getKey().toString());
            } else if (tree.isInternal(item.getKey())){
                s.push(new KeyValue<>(item.getKey(), PostorderDirection.UP));
                s.push(new KeyValue<>(tree.getRightChild(item.getKey()), PostorderDirection.DOWN));
                s.push(new KeyValue<>(tree.getLeftChild(item.getKey()), PostorderDirection.DOWN));
            } else if (tree.isExternal(item.getKey())) {
                System.out.println(item.getKey().toString());
            }
        }
    }
}
