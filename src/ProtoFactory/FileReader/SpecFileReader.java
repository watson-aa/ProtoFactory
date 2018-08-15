package ProtoFactory.FileReader;

import ProtoFactory.WidgetSpec;

import java.io.IOException;
import java.util.ArrayList;

public class SpecFileReader extends FileReaderSuper {
    public WidgetSpec[] parse(String filename) {
        ArrayList<WidgetSpec> widgetSpecs = new ArrayList<>();

        try {
            for (String line : read(filename)) {
                // what we are building is to the left of the colon
                String id = line.substring(0, line.indexOf(':'));

                // +1 to get past the colon.  Regex accounts for careless spacing on the parts
                String[] parts = line.substring(id.length()+1).split("\\s*,\\s*");

                widgetSpecs.add(new WidgetSpec(id, parts));
            }

            return (WidgetSpec[]) widgetSpecs.toArray(new WidgetSpec[widgetSpecs.size()]);
        } catch (IOException e) {
            return new WidgetSpec[0];
        }
    }
}
