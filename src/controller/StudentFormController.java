package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import util.CrudUtil;

import java.io.IOException;
import java.sql.ResultSet;
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


        try {
            loadAllStudents();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("email"));
        colcontact.setCellValueFactory(new PropertyValueFactory("contact"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colnic.setCellValueFactory(new PropertyValueFactory("nic"));


        }






        public void EnterKeyRelease (KeyEvent keyEvent){
        }

        public void SaveStudentrOnAction (ActionEvent actionEvent) throws IOException {

            Student student= new Student(
                    txtSid.getText(),
                    txtSName.getText(),
                    txtSemail.getText(),
                    txtContact.getText(),
                    txtAdress.getText(),
                    txtNic.getText());


            try {
                if (CrudUtil.execute("INSERT INTO Student VALUES (?,?,?,?,?,?)",student.getId(),student.getName(),student.getEmail(),student.getContact(),student.getAddress(),student.getNic())){
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }

            StudentContext.getChildren().clear();
            Parent parent = FXMLLoader.load(getClass().getResource("../view/StudentForm.fxml"));
            StudentContext.getChildren().add(parent);
        }

        public void NewStudentOnAction (ActionEvent actionEvent){
        }

        public void DeleteStudentOnAction (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

            if (CrudUtil.execute("DELETE FROM Student WHERE id=?",txtSearch.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }


        }

        public void UpdateStudentOnAction (ActionEvent actionEvent){

        
        }

        public void SearchStudentOnAction (ActionEvent actionEvent){
        }


    private void loadAllStudents() throws SQLException, ClassNotFoundException {

        ResultSet result = CrudUtil.execute("SELECT * FROM Customer");
        ObservableList<Student> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new Student(
                            result.getString("id"),
                            result.getString("name"),
                            result.getString("email"),
                            result.getString("contact"),
                            result.getString("addres"),
                            result.getString("nic")

                    )
            );
        }
        tblviewStudent.setItems(obList);

    }
    }


