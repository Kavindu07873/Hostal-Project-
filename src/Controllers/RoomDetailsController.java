package Controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

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


    public void btnLeftRoomDetails(ActionEvent actionEvent) {
    }

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/DashBoard.fxml")));
    }

}
