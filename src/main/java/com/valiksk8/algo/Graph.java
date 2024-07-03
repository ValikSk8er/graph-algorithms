package com.valiksk8.algo;

import com.valiksk8.dto.Vertex;

public class Graph {

    /*
     *                         A
     *                      /  |  \
     *                     B   F   G
     *                    / \     /
     *                   C   D   H
     *                      /
     *                     E
     **/

    public static Vertex create() {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.addNeighbor(b);
        a.addNeighbor(f);
        a.addNeighbor(g);

        b.addNeighbor(a);
        b.addNeighbor(c);
        b.addNeighbor(d);

        c.addNeighbor(b);

        d.addNeighbor(b);
        d.addNeighbor(e);

        e.addNeighbor(d);

        f.addNeighbor(a);

        g.addNeighbor(a);
        g.addNeighbor(h);

        h.addNeighbor(g);

        return a;
    }
}
