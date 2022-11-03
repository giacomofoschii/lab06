package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

public class GraphImpl<N> implements Graph<N> {
    Map<N, Set<N>> graph = new HashMap<>();

    public void addNode(N node) {
        if (node != null && !graph.containsKey(node)) {
            Set<N> edge = new HashSet<>();
            graph.put(node, edge);
        }
    }

    public void addEdge(N source, N target) {
        if (source != null && target != null) {
            graph.get(source).add(target);
        }
    }

    public Set<N> nodeSet() {
        return graph.keySet();
    }

    public Set<N> linkedNodes(Object node) {
        return graph.get(node);
    }

    public List<N> getPath(N source, N target) {
        List<N> path = new LinkedList<>();
        if (source.equals(target)) {
            path.add(source);
        } else {
            for (N node : graph.get(source)) {
                path = getPath(node, target);
                if (path != null) {
                    path.add(0, source);
                    break;
                }
            }
        }
        return path;
    }
    
}
