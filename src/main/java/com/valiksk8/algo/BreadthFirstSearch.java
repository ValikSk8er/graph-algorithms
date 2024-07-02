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

            for (Vertex v : actualVertex.getAdjacencyList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    vertexQueue.add(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Vertex root = createGraph();

        BreadthFirstSearch.traverse(root);
    }

    private static Vertex createGraph() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addNaighbor(b);
        a.addNaighbor(g);
        a.addNaighbor(f);

        b.addNaighbor(a);
        b.addNaighbor(c);
        b.addNaighbor(d);

        c.addNaighbor(b);

        d.addNaighbor(b);
        d.addNaighbor(e);

        f.addNaighbor(a);

        g.addNaighbor(a);
        g.addNaighbor(h);

        h.addNaighbor(g);

        return a;
    }
}

