package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Student;

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

    public void EnterKeyRelease(KeyEvent keyEvent) {
    }

    public void SaveStudentrOnAction(ActionEvent actionEvent) {
    }

    public void NewStudentOnAction(ActionEvent actionEvent) {
    }

    public void DeleteStudentOnAction(ActionEvent actionEvent) {
    }

    public void UpdateStudentOnAction(ActionEvent actionEvent) {
    }

    public void SearchStudentOnAction(ActionEvent actionEvent) {
    }
}
