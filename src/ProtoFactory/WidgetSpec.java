package ProtoFactory;

public class WidgetSpec {
    private String[] parts;
    private String id;

    public WidgetSpec(String id, String[] parts) {
        this.id = id;
        this.parts = parts;
    }

    public String getId() {
        return this.id;
    }
    public String[] getParts() { return this.parts; }

    public String toString() {
        return this.id + " (" + this.parts.length + "):" + String.join(",", this.parts);
    }
}
