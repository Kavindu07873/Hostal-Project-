package Controllers;

import Entity.Rooms;
import TM.RoomTM;
import Utill.FactoryConfiguration;
import bo.impl.RoomBOImpl;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class RoomsController {
    public TableColumn colRoomType;
    public TableColumn ColRoomNo;
    public TableColumn colKeyMoney;
    public TableColumn colDescription;
    public TableColumn colPrice;
    public TableColumn colStatus;
    public Button btnAddNewRooms;
    public TextField txtRoom_Type;

    RoomBOImpl roomBO = new RoomBOImpl();

    public Label lblTime;
    public AnchorPane root;
    public Button btnAddNewStudent;
    public JFXTextField txtStuAddress;
    public Button btnDelete;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtPrice;
    public ComboBox cmbRoomType;
    public TextField txtRoomNo;
    public Button btnSave;
    public JFXTextField txtDescription;
    public TableView tblRoom;

    public void initialize() {

        colRoomType.setCellValueFactory(new PropertyValueFactory("Room_type"));
        ColRoomNo.setCellValueFactory(new PropertyValueFactory("Type_Id"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory("keyMoney"));
        colDescription.setCellValueFactory(new PropertyValueFactory("Description"));
        colPrice.setCellValueFactory(new PropertyValueFactory("Price"));
        colStatus.setCellValueFactory(new PropertyValueFactory("btn"));

        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("");
        obList.add("RM-1324(Non-Ac)");
        obList.add("RM-5467(Non-Ac/Food)");
        obList.add("RM-7896(Ac)");
        obList.add("RM-0093(Ac/Food)");

        cmbRoomType.setItems(obList);
        cmbRoomType.getSelectionModel().select(0);

        time();
        loadAllRooms();
    }

    private void loadAllRooms() {
        tblRoom.getItems().clear();

        try {
            List<Rooms> allRooms = roomBO.getAllRooms();
            Button btn = new Button("Available");
            for (Rooms room : allRooms
            ) {
                tblRoom.getItems().add(
                        new RoomTM(
                                room.getRoom_type(),
                                room.getType_Id(),
                                room.getDescription(),
                                room.getPrice(),
                                room.getKyMoney(),
                                btn
                        )

                );

                btn.setOnAction((e)->{

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,

                            "Are You Sure?"
                            ,ButtonType.YES,ButtonType.NO);
                    Optional<ButtonType> buttonType = alert.showAndWait();
                    if(buttonType.get().equals(ButtonType.YES)) {

                    }
                });



            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void time() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd  \n  HH:mm:ss");

            lblTime.setText(LocalDateTime.now().format(formatter));

        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void Search() throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

try(Rooms resultset = session.get(Rooms.class,txtRoomNo.getText())) {
    System.out.println(resultset);
    txtDescription.setText(resultset.getDescription());
    txtKeyMoney.setText(resultset.getKyMoney());
    txtPrice.setText(String.valueOf(resultset.getPrice()));
    txtRoom_Type.setText(resultset.getRoom_type());
}
        transaction.commit();
        session.close();

    }
    public void btnOnActionDelete(ActionEvent actionEvent) {
        String No = txtRoomNo.getText();
        tblRoom.refresh();

        try {
            if(roomBO.deleteStudent(No)){
                new Alert(Alert.AlertType.CONFIRMATION,"Deleted!..").showAndWait();
            }else {
                new Alert(Alert.AlertType.WARNING,"Not").showAndWait();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        txtRoom_Type.clear();
//        txtPrice.clear();
//        txtKeyMoney.clear();
//        txtDescription.clear();
//        txtRoomNo.clear();
loadAllRooms();
    }

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/DashBoard.fxml")));
    }

    public void BtnONUpdate(ActionEvent actionEvent) {
    }

    public void btnAddNewRooms(ActionEvent actionEvent) {
        String type = (String) cmbRoomType.getValue();
        String RoomNo = txtRoomNo.getText();
        String keyMoney = txtKeyMoney.getText();
        String Description = txtDescription.getText();
        double price = Double.parseDouble(txtPrice.getText());

        try {
            if (
                    roomBO.saveRoom(
                            new Rooms(type, RoomNo, keyMoney, Description, price))
            ) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").showAndWait();
            }

            tblRoom.getItems().add(
                    new Rooms(
                            type, RoomNo, keyMoney, Description, price
                    )
            );
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        loadAllRooms();
    }

    public void btnOnActionSearch(ActionEvent actionEvent) throws SQLException {
        Search();
    }


}
