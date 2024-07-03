package com.valiksk8.algo;

import com.valiksk8.dto.Vertex;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch {

    public static void traverse(Vertex root) {
        Deque<Vertex> stack = new LinkedList<>();
        root.setVisited(true);
        stack.push(root);

        while (!stack.isEmpty()) {
            Vertex actualVertex = stack.pop();

            //action
            System.out.println("Actual visited vertex: " + actualVertex);

            for (Vertex v : actualVertex.getNeighbors()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.push(v);
                }
            }
        }
    }

    public static void traverseRecursive(Vertex root) {
        root.setVisited(true);
        System.out.println(root);
        for (Vertex v : root.getNeighbors()) {
            if (!v.isVisited()) {
                v.setVisited(true);
                traverseRecursive(v);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch.traverse(Graph.create());
        System.out.println("---");
        DepthFirstSearch.traverseRecursive(Graph.create());
    }
}
