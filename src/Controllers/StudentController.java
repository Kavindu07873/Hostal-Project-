package Controllers;

import Entity.Student;
import TM.StudentTM;
import Utill.FactoryConfiguration;
import bo.StudentBOImpl;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class StudentController {
    StudentBOImpl studentBOI = new StudentBOImpl();

//    CustomerBOImpl customerBOImpl = BOFactory.getInstance().getBO(BOType.CUSTOMER);



    public Button btnAddNewStudent;
    public  JFXTextField txtStuId;
    public JFXTextField txtStuName;
    public JFXTextField txtStuAddress;
    public Button btnSave;
    public Button btnDelete;
    public TableView tblCustomer;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public Label lblTime;
    public AnchorPane root;
    public TableView tblStudent;

//    public static Object getStuId() {
////        Session session = FactoryConfiguration.getInstance().getSession();
////
////
////        Transaction transaction = session.beginTransaction();
////        Student resultSet =  session.get(Student.class,txtStuId.getText());
////        transaction.commit();
////        session.close();
////        return resultSet;
//    }

    public  void initialize()  {

        colId.setCellValueFactory(new PropertyValueFactory("Stu_Id"));
        colName.setCellValueFactory(new PropertyValueFactory("Name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("Address"));

    loadAllStudent();
time();


    }

    public void time() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" yyyy-MM-dd  \n  HH:mm:ss");

            lblTime.setText(LocalDateTime.now().format(formatter));

        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
    private void loadAllStudent() {


        tblStudent.getItems().clear();

   try {
       List<Student> allstudent = studentBOI.getAllStudent();
       for (Student studentDto:allstudent
            ) {
           tblStudent.getItems().add(
                   new StudentTM(
                           studentDto.getStu_Id(),
                           studentDto.getName(),
                           studentDto.getAddress()
                   )
           );
       }
   }catch (SQLException |ClassNotFoundException e){
       e.printStackTrace();
   }
    }

    public void BtnONUpdate(ActionEvent actionEvent) {
String  id = txtStuId.getText();
String name = txtStuName.getText();
String address = txtStuAddress.getText();

        if(studentBOI.update(new Student(id,name,address))){
            new Alert(Alert.AlertType.CONFIRMATION, "Updated.!").show();

        }else {
            new Alert(Alert.AlertType.ERROR, "Something Happened").show();
        }
        txtStuAddress.clear();
        txtStuName.clear();
        txtStuId.clear();
loadAllStudent();
    }

    public void btnOnActionDelete(ActionEvent actionEvent) {
        String id = txtStuId.getText();
tblStudent.refresh();
        try {
            if(
                    studentBOI.deleteStudent(id)
            ) {

                new Alert(Alert.AlertType.CONFIRMATION,"Deleted!..").showAndWait();
          tblStudent.refresh();
            }else {
                 new Alert(Alert.AlertType.WARNING,"Not").showAndWait();

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        txtStuAddress.clear();
        txtStuName.clear();
        txtStuId.clear();
        loadAllStudent();
    }


    public void btnAddNewStudent(ActionEvent actionEvent) {
        String id = txtStuId.getText();
        String name = txtStuName.getText();
        String Address = txtStuAddress.getText();
try {
        if(
                studentBOI.saveStudent(
                        new Student(id,name,Address))
        ){
            new Alert(Alert.AlertType.CONFIRMATION,"Saved"+name).showAndWait();
        }
       tblStudent.getItems().add(
                new Student(
                        id,name,Address
                )
        ) ;
}catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

}
        txtStuAddress.clear();
        txtStuName.clear();
        txtStuId.clear();
loadAllStudent();
    }

    public void StuIdSearch(ActionEvent actionEvent) throws SQLException {
        Search();
    }
    private void Search() throws SQLException {

   Session session = FactoryConfiguration.getInstance().getSession();


        Transaction transaction = session.beginTransaction();
        try (Student resultSet = session.get(Student.class,txtStuId.getText())) {
            System.out.println(resultSet);

//        System.out.println(resultSet.getStu_Id());
//        System.out.println(resultSet.getAddress());
//        System.out.println(resultSet.getName());
//
            txtStuName.setText(resultSet.getName());
            txtStuAddress.setText(resultSet.getAddress());
        }


        transaction.commit();
        session.close();
    }

    public void btnOnActionBack(ActionEvent actionEvent) throws IOException {
        this.root.getChildren().clear();
        this.root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/DashBoard.fxml")));
    }
}
