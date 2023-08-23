public class Vertex {
    String label;

    Vertex(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        return label.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return label.equals(o.toString());
    }
}
