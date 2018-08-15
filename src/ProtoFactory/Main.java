package ProtoFactory;

import ProtoFactory.FileReader.SpecFileReader;

public class Main {

    public static void main(String[] args) {
        SpecFileReader specFileReader = new SpecFileReader();
        WidgetSpec[] widgetSpecs = specFileReader.parse("data/example_widget.txt");
        for (WidgetSpec ws : widgetSpecs) {
            System.out.println(ws.toString());
        }
    }
}
