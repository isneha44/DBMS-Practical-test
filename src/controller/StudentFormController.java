package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Student;

import java.sql.SQLException;

public class StudentFormController {
    public AnchorPane StudentContext;
    public JFXTextField txtSid;
    public JFXTextField txtSName;
    public TextField txtSearch;
    public JFXTextField txtContact;
    public JFXTextField txtSemail;
    public JFXTextField txtAdress;
    public JFXButton btnSaveStudent;
    public JFXButton btnNewStudent;
    public TableView<Student> tblviewStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colemail;
    public TableColumn colcontact;
    public TableColumn colAddress;
    public TableColumn colnic;
    public JFXButton btnDeleteStudent;
    public JFXButton btnUpdateStudent;
    public JFXButton btnSearchStudent;
    public JFXTextField txtNic;

    public void initialize() {
        btnSaveStudent.setDisable(true);


            loadAllStudents();

        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("email"));
        colcontact.setCellValueFactory(new PropertyValueFactory("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colnic.setCellValueFactory(new PropertyValueFactory("nic"));


        }






        public void EnterKeyRelease (KeyEvent keyEvent){
        }

        public void SaveStudentrOnAction (ActionEvent actionEvent){

            Student student= new Student(
                    txtSid.getText(),
                    txtSName.getText(),
                    txtSemail.getText(),
                    txtContact.getText(),
                    txtAdress.getText(),
                    txtNic.getText());


            try {
                if (CrudUtil.execute("INSERT INTO Customer VALUES (?,?,?,?,?)",customer.getId(),customer.getName(),customer.getAddress(),customer.getNic(),customer.getContact())){
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }

            AdminContext.getChildren().clear();
            Parent parent = FXMLLoader.load(getClass().getResource("../view/CustomerForm.fxml"));
            AdminContext.getChildren().add(parent);
        }

        public void NewStudentOnAction (ActionEvent actionEvent){
        }

        public void DeleteStudentOnAction (ActionEvent actionEvent){
        }

        public void UpdateStudentOnAction (ActionEvent actionEvent){
        }

        public void SearchStudentOnAction (ActionEvent actionEvent){
        }


    private void loadAllStudents() {
    }
}

