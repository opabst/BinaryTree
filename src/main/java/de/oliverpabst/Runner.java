package de.oliverpabst;

import de.oliverpabst.adts.BinaryTree;
import de.oliverpabst.runs.EulerRun;
import de.oliverpabst.runs.LevelorderRun;
import de.oliverpabst.runs.PostorderRun;
import de.oliverpabst.runs.PreorderRun;

public class Runner {
    public static void main(String[] args) {

        BinaryTree<String> tree = new BinaryTree<>();
        tree.getRoot().setContent("A");

        tree.expandExternal(tree.getRoot());

        tree.expandExternal(tree.getRoot().getLeftChild());
        tree.expandExternal(tree.getRoot().getRightChild());

        tree.getRoot().getLeftChild().setContent("B");

        tree.getRoot().getRightChild().setContent("C");

        tree.expandExternal(tree.getRoot().getRightChild().getLeftChild());

        tree.getRoot().getRightChild().getLeftChild().setContent("D");

        System.out.println("Stufendurchlauf");
        LevelorderRun<String> lr = new LevelorderRun<>();
        lr.levelorder(tree);

        System.out.println("Preorder-Durchlauf");
        PreorderRun<String> pr = new PreorderRun<>();
        pr.preOrder(tree, tree.getRoot());

        System.out.println("Preorder-Iter-Durchlauf");
        pr.preorderIter(tree, tree.getRoot());

        System.out.println("Euler-Durchlauf");
        EulerRun<String> er = new EulerRun<>();
        er.eulerrun(tree, tree.getRoot());

        System.out.println("Euler-Iter-Durchlauf");
        er.eulerrunIter(tree, tree.getRoot());

        System.out.println("Postorder-Durchlauf");
        PostorderRun<String> por = new PostorderRun<>();
        por.postorder(tree, tree.getRoot());

        System.out.println("Postorder-Iter-Durchlauf");
        por.postorderIter(tree, tree.getRoot());
    }
}
