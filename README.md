# ProtoFactory

## Widget Factory Exercise - Java

### Files:
#### Data:
**data/example_order.txt:** sample order file  
**data/example_widget.txt:** sample widget specification file  
#### Library:
**libs/WidgetFactory.jar:** provided warehouse simulator
#### FileReader:
**src/ProtoFactory/FileReader/FileReaderSuper.java:** parent file reader class, containing generic _read_ method 
**src/ProtoFactory/FileReader/OrderFileReader.java:** order file reader class that parses order files
**src/ProtoFactory/FileReader/SpecFileReader.java:** order file reader class that parses widget specification files
#### WarehouseClerk:
**src/ProtoFactory/WarehouseClerk.java:** singleton class to interact with the warehouse simulator
#### WidgetSpec:
**src/ProtoFactory/WidgetSpec.java:** widget specification class, containing widget ID and required parts array

---
### Assumptions:
- There is only one warehouse.  The _WarehouseClerk_ class could be refactored to handle multiple warehouses.
- While we do order missing parts, we report on failed widgets, rather than attempting to make them again.

### Requirements:
Java 1.8+

### TODO:
- Unit tests
- Robust input file validation

### HOWTO:  
1. Clone the repository
2. _cd ProtoFactory_
3. _mkdir out_
4. _javac -d out -sourcepath src -cp libs/WidgetFactory.jar src/ProtoFactory/Main.java_
5. _java -cp out:libs/WidgetFactory.jar ProtoFactory.Main_

User is prompted for the widget specification and order data files.  If no input is given, the default files in the _data_ folder will be used.
