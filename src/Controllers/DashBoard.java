package Controllers;

import Entity.Reserved;
import bo.ReservedBo;
import bo.impl.ReservedBoimpl;
import dao.impl.ReservedDaoImpl;
import dao.impl.RoomDaoImpl;
import dao.impl.StudentDaoImpl;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class DashBoard {

    public TextField texts;
    public TextField txtids;
    ReservedDaoImpl reservedDao = new ReservedDaoImpl();
    ReservedBoimpl reservedBoimpl = new ReservedBoimpl();

    public TextField txtRoomNo;
    public TextField txtDate;
    public TextField txtTime;
    public ComboBox cmbRoomType;
    public TextField txtDescription;
    public TextField txtPrice;
    public Label lblDate;
    public Label lblRime;
    public TextField txtAvailable;
    public Label lblRime1;
    public Button btnLeft;
    public Button btnReserved;
    StudentDaoImpl studentDao = new StudentDaoImpl();
    RoomDaoImpl roomDao = new RoomDaoImpl();
    public AnchorPane root;
    public ComboBox cmbStu_id;
    public TextField txtStuName;

    public void initialize() {
        Date();
        time();
//        genarateRoomNo();
        setStudentId();
        cmbStu_id.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            setStudentDetails((String) newValue);
        }));
//genarateRoomNo();
//        setRoomIds();
//        cmbRoomType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
//
//            obList.add("");
//            obList.add("RM-1324(Non-Ac)");
//            obList.add("RM-5467(Non-Ac/Food)");
//            obList.add("RM-7896(Ac)");
//            obList.add("RM-0093(Ac/Food)");
//
//
//            setRoomDetails((String) newValue);
//            genarateRoomNo((String) newValue);
//        } );

        setRoomIds();

        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("");
        obList.add("RM-1324(Non-Ac)");
        obList.add("RM-5467(Non-Ac/Food)");
        obList.add("RM-7896(Ac)");
        obList.add("RM-0093(Ac/Food)");

        cmbRoomType.setItems(obList);
        cmbRoomType.getSelectionModel().select(0);
        cmbRoomType.getSelectionModel().selectedItemProperty().addListener(((observable, oldValue, newValue) -> {
            try {
                setRoomDetails((String) newValue);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }));
    }

    private void setRoomDetails(String selectRoomtype) throws SQLException, ClassNotFoundException {
        List R = RoomDaoImpl.getRoomDetails(selectRoomtype);

        if (R != null) {
//            System.out.println("Addddddddddddddd");
            System.out.println("R =  "+R);
//            txtAvailable.setText(String.valueOf(R));
        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
       generateNewReservationID();

        txtids.setText(generateNewReservationID());
    }

    private void setRoomIds() {

        ObservableList<String> roomObList;

        try {
            roomObList = FXCollections.observableArrayList(roomDao.getRoomIds());
//            if (txtAvailable.getText().equals("[Available]")) {
//            txtids.setText(String.valueOf(roomObList));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void setStudentDetails(String selectedStudentId) {
        List<String> S = StudentDaoImpl.getStudentDetails(selectedStudentId);

        if (S != null) {
            System.out.println(S + "\b");
            txtStuName.setText(String.valueOf(S + "\b"));

        } else {
            new Alert(Alert.AlertType.WARNING, "Empty Result").show();
        }
    }

    private void setStudentId() {
        try {
            ObservableList<String> stuidObList = FXCollections.observableArrayList(studentDao.getStudentIds());
            cmbStu_id.setItems(stuidObList);
            System.out.println(stuidObList);
//            System.out.println(stuidObList.stream().sorted());


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void Date() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd");

            lblDate.setText(LocalDateTime.now().format(formatter));

        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void time() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblRime.setText(currentTime.getHour() + ":" +
                    currentTime.getMinute() + ":" +
                    currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }


    public void AddStudentbtnOnAction(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/Student.fxml")));
    }

    public void AddRoomsbtnOnAction(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/Rooms.fxml")));
    }

    public void btnOnActionReservedRoom(ActionEvent actionEvent) {
        String Stu_id = (String) cmbStu_id.getValue();
        String Stu_Name = txtStuName.getText();
        String Room_Type = (String) cmbRoomType.getValue();
        String Room_No = txtRoomNo.getText();
        String Date = lblDate.getText();
        double Price = Double.parseDouble(txtPrice.getText());
        String Reserved_id = generateNewReservationID();

        System.out.println(generateNewReservationID());

//        if(txtRoomNo.getText().equals())
        try {
            if (reservedBoimpl.saveReserved(
                    new Reserved(
                            Reserved_id,Room_No,Stu_id,Stu_Name,Room_Type,Price,Date
                    )
            ) ) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved").showAndWait();

            } else {
                System.out.println("ane  mnda");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public String generateNewReservationID() {
        return ReservedBoimpl.generateNewReservationID();
    }

    private void genarateRoomNo(String w) {
        List K = RoomDaoImpl.getKeyWords(w);
        if (K != null) {
            System.out.println("ADOOO");
            System.out.println(K);
            txtRoomNo.setText(String.valueOf(K));
        }
        if (cmbRoomType.getValue().equals("RM-1324(Non-Ac)")) {
        }
    }

    public void btnOnActionRoom_Details(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/RoomDetails.fxml")));

    }

    public void btnOnActionleftRoom(ActionEvent actionEvent) {
    }

    public void cmbActionRoom_Type(ActionEvent actionEvent) {

        if (cmbRoomType.getSelectionModel().getSelectedItem().equals("RM-1324(Non-Ac)")) {
            txtPrice.setText("3100");
            btnReserved.setDisable(true);
            //  texts.setText("[R001]");
            Random r = new Random();
            //35Rooms
            for (int i = 0; i < 35; i++) {
                int rand = r.nextInt(35);
                System.out.println("rand      " + rand);
                txtRoomNo.setText(String.valueOf("N" + rand));
                i++;
                //          txtAvailable.setText("Ok");
                btnReserved.setDisable(false);
            }


        }


        if (cmbRoomType.getSelectionModel().getSelectedItem().equals("RM-5467(Non-Ac/Food)")) {
            txtPrice.setText("6500");
            //       texts.setText("R001");

            Random r = new Random();

            btnReserved.setDisable(true);

            for (int i = 0; i < 20; i++) {
                //   System.out.println(i);
                int rand = r.nextInt(20);

                txtRoomNo.setText(String.valueOf("NF" + rand));
                //       txtAvailable.setText("NOT Available");
                btnReserved.setDisable(false);
            }


        }
        if (cmbRoomType.getSelectionModel().getSelectedItem().equals("RM-7896(Ac)")) {
            txtPrice.setText("8100");
            //    texts.setText("R001");

            Random r = new Random();
            btnReserved.setDisable(true);

            for (int i = 0; i < 14; i++) {
                //     System.out.println(i);
                int rand = r.nextInt(14);

                txtRoomNo.setText(String.valueOf("A" + rand));

                //  txtAvailable.setText("NOT Available");
                btnReserved.setDisable(false);
            }


        }
        if (cmbRoomType.getSelectionModel().getSelectedItem().equals("RM-0093(Ac/Food)")) {
            txtPrice.setText("16000");
            //     txtids.setText("R001");

            Random r = new Random();

            btnReserved.setDisable(true);

            for (int i = 0; i < 10; i++) {
                //  System.out.println(i);
                int rand = r.nextInt(10);
                txtRoomNo.setText(String.valueOf("AF" + rand));

                //      txtAvailable.setText("NOT Available");
                btnReserved.setDisable(false);
            }
        }

//        if (cmbRoomType.getSelectionModel().getSelectedItem().equals("RM-1324(Non-Ac)") & txtAvailable.getText().equals("Available") ) {
//          //  txtPrice.setText("3100");
//        //35Rooms
//            for (int i = 0; i<35;i++){
//                txtRoomNo.setText(String.valueOf("N"+i));
//                            i++;
//                            btnReserved.setDisable(false);
//            }
//        }

//        if (cmbRoomType.getSelectionModel().getSelectedItem().equals("RM-5467(Non-Ac/Food)")& txtAvailable.getText().equals("Available")  ) {
//          //  txtPrice.setText("6500");
//            for (int i = 0; i <20; i++) {
//                txtRoomNo.setText(String.valueOf("NF" + i));
//                i++;
//                btnReserved.setDisable(false);
//            }
//
//        }
    }
}
