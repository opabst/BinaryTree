package de.oliverpabst.runs;

import de.oliverpabst.adts.BinaryTree;
import de.oliverpabst.adts.BinaryTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class LevelorderRun<T> {

    public void levelorder(BinaryTree<T> tree) {
        BinaryTreeNode<T> v;

        Queue<BinaryTreeNode<T>> queue = new ArrayDeque<>();

        queue.offer(tree.getRoot());
        while(!queue.isEmpty()) {
            v = queue.poll();

            System.out.println(v.toString());

            for(BinaryTreeNode<T> w: tree.getChildren(v)) {
                queue.offer(w);
            }
        }
    }
}
