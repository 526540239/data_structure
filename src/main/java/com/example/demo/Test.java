package com.example.demo;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Tree tree = Tree.createDemoTree();
        preOrderTravel(tree);
        System.out.println();
        inOrderTravel(tree);
        System.out.println();
        nextOrderTravel(tree);
        System.out.println();
        levelOrderTravel(tree);
        System.out.println();
        printTree(tree, 0, "");
        System.out.println();
        Tree t = null;
        for (int i = 0; i < 20; i++) {
            int num = (int) (Math.random() * 100) + 1;
            t = createTree(t, num);
        }
        printTree(t, 0, "");
    }

    /**
     * 前序遍历
     */
    public static void preOrderTravel(Tree tree) {
        if (tree == null) {
            return;
        }
        String value = tree.getValue();
        System.out.print(value);
        Tree leftLeaf = tree.getLeftLeaf();
        preOrderTravel(leftLeaf);
        Tree rightLeaf = tree.getRightLeaf();
        preOrderTravel(rightLeaf);
    }

    /**
     * 中序遍历
     */
    public static void inOrderTravel(Tree tree) {
        if (tree == null) {
            return;
        }
        String value = tree.getValue();
        Tree leftLeaf = tree.getLeftLeaf();
        Tree rightLeaf = tree.getRightLeaf();

        inOrderTravel(leftLeaf);
        System.out.print(value);
        inOrderTravel(rightLeaf);
    }

    /**
     * 后序遍历
     */
    public static void nextOrderTravel(Tree tree) {
        if (tree == null) {
            return;
        }
        String value = tree.getValue();
        Tree leftLeaf = tree.getLeftLeaf();
        Tree rightLeaf = tree.getRightLeaf();

        nextOrderTravel(leftLeaf);
        nextOrderTravel(rightLeaf);
        System.out.print(value);
    }

    /**
     * 层序遍历
     */
    public static void levelOrderTravel(Tree tree) {
        if (tree == null) {
            return;
        }
        List<Tree> list = new LinkedList<>();
        list.add(tree);
        while (!list.isEmpty()) {
            Tree first = ((LinkedList<Tree>) list).getFirst();
            ((LinkedList<Tree>) list).removeFirst();
            String value = first.getValue();
            System.out.print(value);
            Tree leftLeaf = first.getLeftLeaf();
            if (leftLeaf != null) {
                list.add(leftLeaf);
            }
            Tree rightLeaf = first.getRightLeaf();
            if (rightLeaf != null) {
                list.add(rightLeaf);
            }
        }
    }

    /**
     * 打印数结构
     */
    public static void printTree(Tree tree, int level, String desc) {
        if (tree == null) {
            return;
        }
        level++;
        String value = tree.getValue();
        Tree leftLeaf = tree.getLeftLeaf();
        Tree rightLeaf = tree.getRightLeaf();
        for (int i = 1; i < level; i++) {
            System.out.print("——");
        }
        System.out.print(desc);
        System.out.print(value);
        System.out.println();

        printTree(leftLeaf, level, "L:");
        printTree(rightLeaf, level, "R:");
    }

    public static Tree createTree(Tree tree, int num) {
        if (tree == null) {
            tree = new Tree(String.valueOf(num), null, null);
            return tree;
        }
        String value = tree.getValue();
        if (num < Integer.parseInt(value)) {
            Tree leftLeaf = tree.getLeftLeaf();
            if (leftLeaf == null) {
                tree.setLeftLeaf(new Tree(String.valueOf(num), null, null));
            } else {
                createTree(leftLeaf, num);
            }
        } else {
            Tree rightLeaf = tree.getRightLeaf();
            if (rightLeaf == null) {
                tree.setRightLeaf(new Tree(String.valueOf(num), null, null));
            } else {
                createTree(rightLeaf, num);
            }
        }
        return tree;
    }
}
