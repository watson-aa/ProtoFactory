package ProtoFactory;

import ProtoFactory.FileReader.OrderFileReader;
import ProtoFactory.FileReader.SpecFileReader;
import WidgetFactory.PartNotFoundException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // read the widget specification file
        SpecFileReader specFileReader = new SpecFileReader();
        WidgetSpec[] widgetSpecs = specFileReader.parse("data/example_widget.txt");

        // read the order file
        OrderFileReader orderFileReader = new OrderFileReader();
        WidgetSpec[] orderSpecs = orderFileReader.parse("data/example_order.txt", widgetSpecs);

        ArrayList<String> madeWidgets = new ArrayList<>();
        ArrayList<String> failedWidgets = new ArrayList<>();

        Boolean success;

        for (WidgetSpec ws : orderSpecs) {
            success = Boolean.TRUE;

            System.out.printf("Ordering parts for a %s...\n", ws.getId());
            WarehouseClerk.orderParts(ws.getParts());

            System.out.printf("Building a %s...\n", ws.getId());
            for (String partId : ws.getParts()) {
                try {
                    WarehouseClerk.retrievePart(partId);
                } catch (PartNotFoundException e) {
                    // Output the problem and order another part
                    System.out.printf("ERROR: %s (%s)\n", e.getMessage(), partId);
                    success = Boolean.FALSE;
                    WarehouseClerk.orderPart(partId);
                }
            }

            if (success == Boolean.TRUE) {
                madeWidgets.add(ws.getId());
            } else {
                failedWidgets.add(ws.getId());
            }
        }

        System.out.printf("Widgets made: %s\n", String.join(", ", madeWidgets.toArray(new String[madeWidgets.size()])));
        System.out.printf("Widgets failed: %s\n", String.join(", ", failedWidgets.toArray(new String[failedWidgets.size()])));
    }
}
