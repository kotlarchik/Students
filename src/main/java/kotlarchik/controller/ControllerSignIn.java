package kotlarchik.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import kotlarchik.dao.DAO;
import kotlarchik.model.Users;
import kotlarchik.service.ServiceUsers;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerSignIn {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    List<Users> usersList = new ArrayList<>();

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtPass;

    @FXML
    private Button buttonSign;

    @FXML
    void initialize(){
        dataBase();
    }

    public void dataBase(){
        DAO<Users, Integer> usersDAO = new ServiceUsers(factory);
        usersList.addAll(usersDAO.readAll());
    }

    @FXML
    public void pressSign(ActionEvent event) throws IOException {
        for (Users users: usersList) {
            if (users.getName().equals(txtLogin.getText()) && users.getPass().equals(txtPass.getText())){
                buttonSign.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Успеваемость студентов.");
                stage.setScene(new Scene(root));
                stage.show();
            }
        }

    }
}