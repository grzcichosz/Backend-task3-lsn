import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;
    private Map<Vertex, Boolean> visited = new HashMap<>();

    Graph() {
        adjVertices = new HashMap<>();
    }

    public void addVertex(String label) {
        Vertex vertex = new Vertex(label);
        visited.putIfAbsent(vertex, false);
        adjVertices.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    private Vertex getVertexNotVisited() {
        for (Vertex vertex : visited.keySet()) {
            if (!visited.get(vertex)) {
                return vertex;
            }
        }
        return null;
    }

    public int countConnectedComponents() {
        int count = 0;
        Vertex start;
        while ((start = getVertexNotVisited()) != null) {
            dfs(start);
            count++;
        }
        return count;
    }

    private void dfs(Vertex start) {
        visited.replace(start, true);
        for (int i = 0; i < adjVertices.get(start).size(); i++) {
            Vertex destination = adjVertices.get(start).get(i);
            if (!visited.get(destination)) {
                dfs(destination);
            }
        }
    }
}
