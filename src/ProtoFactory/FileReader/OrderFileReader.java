package ProtoFactory.FileReader;

import ProtoFactory.WidgetSpec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class OrderFileReader extends FileReaderSuper {
    public WidgetSpec[] parse(String filename, WidgetSpec[] widgetSpecs) {
        ArrayList<WidgetSpec> oWidgetSpecs = new ArrayList<>();

        try {
            for (String id : read(filename)) {
                Optional<WidgetSpec> optWS = Arrays.stream(widgetSpecs).filter(widgetSpec -> id.equals(widgetSpec.getId())).findFirst();
                if (((Optional) optWS).isPresent()) {
                    oWidgetSpecs.add(optWS.get());
                }
            }

            return (WidgetSpec[]) oWidgetSpecs.toArray(new WidgetSpec[oWidgetSpecs.size()]);
        } catch (IOException e) {
            return new WidgetSpec[0];
        }
    }
}
