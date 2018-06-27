package lab8.pages;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import lab8.pages.classes.ElectronicThermometer;
import lab8.pages.classes.Measure;
import lab8.pages.classes.Thermometer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ali.naffaa on 14.06.2018.
 */
public class DevicePage {
    static ArrayList<ElectronicThermometer> electronicThermometers = new ArrayList<>();

    ElectronicThermometer currentDevice = null;
    Stage primaryStage;
    private GridPane grid = new GridPane();
    private TableColumn<Map, String> dataColumn_1 = new TableColumn<>("Name");
    private TableColumn<Map, String> dataColumn_2 = new TableColumn<>("State");
    private TableColumn<Map, String> dataColumn_3 = new TableColumn<>("length");
    private TableColumn<Map, String> dataColumn_4 = new TableColumn<>("height");
    private TableColumn<Map, String> dataColumn_5 = new TableColumn<>("width");
    private TableColumn<Map, String> dataColumn_6 = new TableColumn<>("weight");
    private TableView tableView = new TableView<>(generateTable());
    private static final String Column1MapKey = "A";
    private static final String Column2MapKey = "B";
    private static final String Column3MapKey = "C";
    private static final String Column4MapKey = "D";
    private static final String Column5MapKey = "E";
    private static final String Column6MapKey = "F";

    private Button back = new Button("Back");
    private Button add = new Button("Add");
    private Button remove = new Button("Remove");
    private Button save = new Button("Save");


    //Edit Pane
    private GridPane gridEdit = new GridPane();
    private TextField newFileName = new TextField("new device name");
    private TextField length = new TextField("length");
    private TextField height = new TextField("height");
    private TextField width = new TextField("width");
    private TextField weight = new TextField("weight");
    ObservableList<String> options =
            FXCollections.observableArrayList(
                    "ON",
                    "OFF",
                    "SERVICEABLE",
                    "DEFECTIVE"
            );
    ComboBox state = new ComboBox(options);
    private int selectedIndex = 0;



    public DevicePage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private void setGrid() {
        gridEdit.add(newFileName,0,0);
        gridEdit.add(length,0,1);
        gridEdit.add(height,0,2);
        gridEdit.add(width,0,3);
        gridEdit.add(weight,0,4);
        gridEdit.add(state,0,5);
        gridEdit.setVisible(false);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
    }

    public GridPane getContent() {
        setGrid();
        addElementsToGrid();
        setActions();
        addTableLectures();
        grid.add(tableView, 0, 2, 10, 10);
        grid.add(gridEdit, 0, 2, 10, 10);
        return grid;
    }

    private void setActions() {
        back.setOnAction((ActionEvent e) -> {
            tableView.setItems(generateTable());
            back.setVisible(false);
            save.setVisible(false);
            tableView.setVisible(true);
            add.setVisible(true);
            remove.setVisible(true);
            gridEdit.setVisible(false);
            tableView.getSelectionModel().clearSelection();
        });

        add.setOnAction((ActionEvent e) -> {
            ArrayList<Measure> measures = new ArrayList<Measure>();
            measures.add(new Measure(Measure.MeasureType.CELSIUS,"0","100","0.2"));
            currentDevice = new ElectronicThermometer("name");
            currentDevice.setState(Thermometer.State.OFF);
            add.setVisible(false);
            back.setVisible(true);
            remove.setVisible(false);
            save.setVisible(true);
            gridEdit.setVisible(true);
            tableView.setVisible(false);
        });
        save.setOnAction((ActionEvent e) -> {
            currentDevice.setName(newFileName.getText());
            currentDevice.setHeight(height.getText());
            currentDevice.setLength(length.getText());
            currentDevice.setWeight(weight.getText());
            currentDevice.setWidth(width.getText());
            state.getSelectionModel().getSelectedItem();
            Thermometer.State stateObj = Thermometer.State.DEFECTIVE;
            if(state.getSelectionModel().getSelectedItem()!=null){
                if(state.getSelectionModel().getSelectedItem().equals("ON"))
                    stateObj = Thermometer.State.ON;
                else if(state.getSelectionModel().getSelectedItem().equals("OFF"))
                    stateObj = Thermometer.State.OFF;
                else if(state.getSelectionModel().getSelectedItem().equals("SERVICEABLE"))
                    stateObj = Thermometer.State.SERVICEABLE;
            }
            currentDevice.setState(stateObj);
            electronicThermometers.add(currentDevice);
            tableView.setItems(generateTable());
            back.setVisible(false);
            save.setVisible(false);
            remove.setVisible(true);
            tableView.setVisible(true);
            add.setVisible(true);
            gridEdit.setVisible(false);
            tableView.getSelectionModel().clearSelection();
            if (electronicThermometers.size() > 0) {
                remove.setDisable(false);
            }

        });
        remove.setOnAction((ActionEvent e) -> {
            if (electronicThermometers.size() > selectedIndex) {
                selectedIndex = 0;
            }
            electronicThermometers.remove(selectedIndex);
            tableView.setItems(generateTable());
            tableView.getSelectionModel().clearSelection();
            selectedIndex = 0;
            if (electronicThermometers.size() == 0) {
                remove.setDisable(true);
            }
        });
    }

    private void addElementsToGrid() {
        if (electronicThermometers.size() == 0) {
            remove.setDisable(true);
        }
        back.setVisible(false);
        save.setVisible(false);
        grid.add(back, 0, 0, 10, 1);
        grid.add(add, 0, 0, 10, 1);
        grid.add(remove, 5, 0, 10, 1);
        grid.add(save, 5, 0, 10, 1);
    }

    private void addTableLectures() {
        dataColumn_1.setCellValueFactory(new MapValueFactory(Column1MapKey));
        dataColumn_1.setMinWidth(100);

        dataColumn_2.setCellValueFactory(new MapValueFactory(Column2MapKey));
        dataColumn_2.setMinWidth(100);

        dataColumn_3.setCellValueFactory(new MapValueFactory(Column3MapKey));
        dataColumn_3.setMinWidth(100);

        dataColumn_4.setCellValueFactory(new MapValueFactory(Column4MapKey));
        dataColumn_4.setMinWidth(100);

        dataColumn_5.setCellValueFactory(new MapValueFactory(Column5MapKey));
        dataColumn_5.setMinWidth(100);

        dataColumn_6.setCellValueFactory(new MapValueFactory(Column6MapKey));
        dataColumn_6.setMinWidth(100);

        tableView.setPrefHeight(10000);
        tableView.setEditable(false);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.setOnMouseClicked((MouseEvent e) -> {
            selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        });

        tableView.getColumns().setAll(dataColumn_1,dataColumn_2, dataColumn_3,dataColumn_4,dataColumn_5,dataColumn_6);
        Callback<TableColumn<Map, String>, TableCell<Map, String>>
                cellFactoryForMap = (TableColumn<Map, String> p) ->
                new TextFieldTableCell(new StringConverter() {
                    @Override
                    public String toString(Object t) {
                        return t.toString();
                    }

                    @Override
                    public Object fromString(String string) {
                        return string;
                    }
                });
        dataColumn_1.setCellFactory(cellFactoryForMap);
        dataColumn_2.setCellFactory(cellFactoryForMap);
        dataColumn_3.setCellFactory(cellFactoryForMap);
        dataColumn_4.setCellFactory(cellFactoryForMap);
        dataColumn_5.setCellFactory(cellFactoryForMap);
        dataColumn_6.setCellFactory(cellFactoryForMap);
    }

    private ObservableList<Map> generateTable() {
        ObservableList<Map> allData = FXCollections.observableArrayList();
        for (ElectronicThermometer electronicThermometer: electronicThermometers) {

            Map<String, String> dataRow = new HashMap<>();
            dataRow.put(Column1MapKey, checkNull(electronicThermometer.getName()));
            dataRow.put(Column2MapKey, electronicThermometer.getState().toString());
            dataRow.put(Column3MapKey, checkNull(electronicThermometer.getLength()));
            dataRow.put(Column4MapKey, checkNull(electronicThermometer.getHeight()));
            dataRow.put(Column5MapKey, checkNull(electronicThermometer.getWidth()));
            dataRow.put(Column6MapKey, checkNull(electronicThermometer.getWeight()));
            allData.add(dataRow);
        }
        return allData;
    }

    private String checkNull(String text) {
        if (text != null) {
            return text;
        } else {
            return "";
        }
    }
}
