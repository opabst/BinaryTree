package de.oliverpabst.runs;

import de.oliverpabst.adts.BinaryTree;
import de.oliverpabst.adts.BinaryTreeNode;
import de.oliverpabst.adts.KeyValue;

import java.util.Stack;

public class EulerRun<T> {

    public void eulerrun(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        if(tree.isExternal(startNode)) {
            System.out.println(startNode.toString());
        } else {
            eulerrun(tree, tree.getLeftChild(startNode));
            System.out.println(startNode.toString());
            eulerrun(tree, tree.getRightChild(startNode));
        }
    }

    public void eulerrunIter(BinaryTree<T> tree, BinaryTreeNode<T> startNode) {
        Stack<KeyValue<BinaryTreeNode<T>, EulerDirection>> s = new Stack();
        KeyValue<BinaryTreeNode<T>, EulerDirection> item = new KeyValue<>(startNode, EulerDirection.LEFT);
        s.push(item);
        while(!s.isEmpty()) {
            KeyValue<BinaryTreeNode<T>, EulerDirection> e = s.pop();

            if(e.getValue().equals(EulerDirection.LEFT) && tree.isInternal(e.getKey())) {
                s.push(new KeyValue<BinaryTreeNode<T>, EulerDirection>(tree.getRightChild(e.getKey()), EulerDirection.LEFT));
                s.push(new KeyValue<BinaryTreeNode<T>, EulerDirection>(e.getKey(), EulerDirection.UP));
                s.push(new KeyValue<BinaryTreeNode<T>, EulerDirection>(tree.getLeftChild(e.getKey()), EulerDirection.LEFT));
            } else if (e.getValue().equals(EulerDirection.LEFT) && tree.isExternal(e.getKey())) {
                System.out.println(e.getKey().toString());
            } else if(e.getValue().equals(EulerDirection.RIGHT) && tree.isExternal(e.getKey())) {
                System.out.println(e.getKey().toString())
;           } else if (e.getValue().equals(EulerDirection.UP)) {
                System.out.println(e.getKey().toString());
            } else if (e.getValue().equals(EulerDirection.RIGHT)) {
                System.out.println(e.getKey().toString());
                s.push(new KeyValue<BinaryTreeNode<T>, EulerDirection>(tree.getParent(e.getKey()), EulerDirection.RIGHT));
            }

        }
    }
}
