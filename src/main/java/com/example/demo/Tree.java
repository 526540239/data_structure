package com.example.demo;

import lombok.Data;

@Data
public class Tree {
    private String value;
    private Tree leftLeaf;
    private Tree rightLeaf;

    public Tree(String value, Tree leftLeaf, Tree rightLeaf) {
        this.value = value;
        this.leftLeaf = leftLeaf;
        this.rightLeaf = rightLeaf;
    }

    public static Tree createDemoTree() {
        Tree I = new Tree("I", null, null);
        Tree H = new Tree("H", null, null);
        Tree G = new Tree("G", H, I);
        Tree F = new Tree("F", null, null);
        Tree E = new Tree("E", null, null);
        Tree D = new Tree("D", F, G);
        Tree C = new Tree("C", null, null);
        Tree B = new Tree("B", D, E);
        Tree A = new Tree("A", B, C);
        return A;
    }
}
