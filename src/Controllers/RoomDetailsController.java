package Controllers;

import Entity.Reserved;
import Entity.Rooms;
import TM.ReservedTM;
import TM.RoomTM;
import bo.impl.RoomDetailsBoimpl;
import com.jfoenix.controls.JFXTextField;
import dao.impl.RoomDetailsDaoimpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RoomDetailsController {

    public Button btnLeftRoomDetails;
    public AnchorPane root;
    public JFXTextField txtDescription;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtPrice;
    public TableView tblRoom;
    public JFXTextField txtRoomPrice;
    public JFXTextField txtRoomType;
    public JFXTextField txtRoomNo;
    public TableColumn colReceived;
    public TableColumn ColStudentId;
    public TableColumn colStudentName;
    public TableColumn colRoomNo;
    public TableColumn colRoomType;
    public TableColumn colDate;
    public TableColumn colRoomPrice;
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtReceivedId;
    public JFXTextField txtDate;
    public TableView tblRoomDetails;
    RoomDetailsBoimpl roomDetailsBoimpl = new RoomDetailsBoimpl();
    public void initialize(){
        colReceived.setCellValueFactory(new PropertyValueFactory("Reserved_id"));
        ColStudentId.setCellValueFactory(new PropertyValueFactory("Stu_id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory("Stu_Name"));
        colRoomNo.setCellValueFactory(new PropertyValueFactory("Room_No"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("Room_Type"));
        colDate.setCellValueFactory(new PropertyValueFactory("Date"));
        colRoomPrice.setCellValueFactory(new PropertyValueFactory("Price"));

        loadAllRoomsDetails();
    }


    public void btnLeftRoomDetails(ActionEvent actionEvent) {


    }

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/DashBoard.fxml")));
    }


    private void loadAllRoomsDetails() {
        tblRoomDetails.getItems().clear();

        try {
            List<Reserved> allReserved = roomDetailsBoimpl.getAllRoomsDetails();
//            Button btn = new Button("Available");
            for (Reserved reserved : allReserved
            ) {
                tblRoomDetails.getItems().add(
                        new ReservedTM(
                             reserved.getReserved_id(),
                                reserved.getRoom_No(),
                                reserved.getStu_id(),
                                reserved.getStu_Name(),
                                reserved.getRoom_Type(),
                                reserved.getPrice(),
                                reserved.getDate()
                                )

                );

//                btn.setOnAction((e)->{
//
//                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
//
//                            "Are You Sure?"
//                            , ButtonType.YES,ButtonType.NO);
//                    Optional<ButtonType> buttonType = alert.showAndWait();
//                    if(buttonType.get().equals(ButtonType.YES)) {
//
//                    }
//                });



            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
