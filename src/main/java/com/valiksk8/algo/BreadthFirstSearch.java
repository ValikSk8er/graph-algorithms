package com.valiksk8.algo;

import com.valiksk8.dto.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void traverse(Vertex root) {
        Queue<Vertex> vertexQueue = new LinkedList<>();
        root.setVisited(true);
        vertexQueue.add(root);
        while (!vertexQueue.isEmpty()) {
            Vertex actualVertex = vertexQueue.remove();

            //action
            System.out.println("Actual visited vertex: " + actualVertex);

            for (Vertex v : actualVertex.getNeighbors()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch.traverse(Graph.create());
    }
}

