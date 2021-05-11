package kotlarchik.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import kotlarchik.dao.DAO;
import kotlarchik.model.Student;
import kotlarchik.service.ServiceStudent;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collection;

public class ControllerMain {

    @FXML
    private TableView<Student> tableStudents;

    @FXML
    private TableColumn<Student, Integer> columnID;

    @FXML
    private TableColumn<Student, String> columnLastName;

    @FXML
    private TableColumn<Student, String> columnName;

    @FXML
    private TableColumn<Student, String> columnPatronymic;

    @FXML
    private TableColumn<Student, String> columnSpec;

    @FXML
    private TableColumn<Student, String> columnAVGBall;

    private final ObservableList<Student> studentObservableList = FXCollections.observableArrayList();

    @FXML
    void initialize(){
        dataBaseItem();
        initData();
    }

    private void dataBaseItem(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Student, Integer> studentDAO = new ServiceStudent(factory);
        studentObservableList.addAll(studentDAO.readAll());
    }

    private void initData(){
        tableStudents.setItems(studentObservableList);
        columnID.setCellValueFactory(s -> new SimpleObjectProperty<>(s.getValue().getId()));
        columnLastName.setCellValueFactory(s -> new SimpleObjectProperty<>(s.getValue().getLastName()));
        columnName.setCellValueFactory(s -> new SimpleObjectProperty<>(s.getValue().getName()));
        columnPatronymic.setCellValueFactory(s -> new SimpleObjectProperty<>(s.getValue().getPatronymic()));
        columnSpec.setCellValueFactory(s -> new SimpleObjectProperty<>(s.getValue().getSpecialization().toString()));
    }
}
