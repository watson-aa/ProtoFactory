package ProtoFactory;

import WidgetFactory.Part;
import WidgetFactory.PartNotFoundException;
import WidgetFactory.Warehouse;

import java.util.ArrayList;
import java.util.Arrays;

public class WarehouseClerk {
    private static WarehouseClerk warehouseClerk = null;
    private Warehouse warehouse = null;

    public static WarehouseClerk getInstance() {
        if (warehouseClerk == null) {
            warehouseClerk = new WarehouseClerk();
            warehouseClerk.warehouse = new Warehouse();
        }

        return warehouseClerk;
    }

    public Warehouse getWarehouse() {
        return this.warehouse;
    }

    public static Boolean allPartsAvailable(String[] parts) {
        // are there any widget parts that are not currently in the warehouse?
        Warehouse warehouse = WarehouseClerk.getInstance().getWarehouse();
        return !Arrays.stream(parts)
                .anyMatch(part -> warehouse.available(part) == Boolean.FALSE);
    }

    public static void orderPart(String partId) {
        Warehouse warehouse = WarehouseClerk.getInstance().getWarehouse();
        warehouse.order(partId);
    }

    public static void orderParts(String[] parts) {
        Warehouse warehouse = WarehouseClerk.getInstance().getWarehouse();
        Arrays.stream(parts)
                .forEach(partId -> warehouse.order(partId));
    }

    public static Part retrievePart(String partId) throws PartNotFoundException {
        Warehouse warehouse = WarehouseClerk.getInstance().getWarehouse();
        return warehouse.retrieve(partId);
    }

    public static Part[] retreiveParts(String[] parts) throws PartNotFoundException {
        ArrayList<Part> oParts = new ArrayList<>();

        Warehouse warehouse = WarehouseClerk.getInstance().getWarehouse();
        for (String partId : parts) {
            oParts.add(warehouse.retrieve(partId));
        }

        return (Part[]) oParts.toArray(new Part[oParts.size()]);
    }
}
