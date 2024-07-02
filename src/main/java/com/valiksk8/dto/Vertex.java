package com.valiksk8.dto;

import java.util.LinkedList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private List<Vertex> adjancencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjancencyList = new LinkedList<>();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Vertex> getAdjacencyList() {
        return adjancencyList;
    }

    public void addNaighbor(Vertex vertex) {
        this.adjancencyList.add(vertex);
    }

    @Override
    public String toString() {
        return name;
    }
}
