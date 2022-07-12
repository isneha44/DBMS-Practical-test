package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
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

    public void initialize() {
        btnSaveStudent.setDisable(true);

        try {
            loadAllStudents();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colNic.setCellValueFactory(new PropertyValueFactory("nic"));
        colContact.setCellValueFactory(new PropertyValueFactory("contact"));

    }


        public void EnterKeyRelease (KeyEvent keyEvent){
        }

        public void SaveStudentrOnAction (ActionEvent actionEvent){
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

