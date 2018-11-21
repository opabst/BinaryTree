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

            // Neu erreichter interner Knoten - linkes Kind und aktuellen Knoten für Rückkehr einfügen
            if(e.getValue().equals(EulerDirection.LEFT) && tree.isInternal(e.getKey())) {
                s.push(new KeyValue<>(e.getKey(), EulerDirection.DOWN));
                s.push(new KeyValue<>(tree.getLeftChild(e.getKey()), EulerDirection.LEFT));
            } // nach Rückkehr in rechten Teilbaum einfügen
            else if (e.getValue().equals(EulerDirection.DOWN)) {
                System.out.println(e.getKey().toString());
                s.push(new KeyValue<>(tree.getRightChild(e.getKey()), EulerDirection.LEFT));
                s.push(new KeyValue<>(e.getKey(), EulerDirection.RIGHT));
            }
            // Von rechts aufsteigen in Baum
            else if(e.getValue().equals(EulerDirection.RIGHT)) {
                // nichts machen
            }
            // linkes Blatt - ausgeben
            else if (e.getValue().equals(EulerDirection.RIGHT) && tree.isExternal(e.getKey())) {
                System.out.println(e.getKey().toString());
            }

        }
    }
}
