package com.example.javafxdemo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label userText;
    @FXML
    public TextField login, password, userLog, userPass;
    @FXML
    private Button SignIn, Create, Back, SignUp;

    ArrayList<Account> accounts = new ArrayList<>();

    @FXML
    public void signingIn() throws IOException {
        String log = login.getText();
        String pass = password.getText();
        accounts.add(new Account("Alex", "123456"));
        boolean flag = true;
        boolean LOG = false;
        boolean PASS = false;
        for (int i = 0; i < accounts.size() && flag; i++) {
            if (accounts.get(i).getLogin().equals(log)) {
                LOG = true;
                if (accounts.get(i).getPassword().equals(pass))
                    PASS = true;
                    flag = false;
            }
        }
        Stage stage;
        Parent root;
        if (LOG && PASS) {
            stage = (Stage) SignIn.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("result_form.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            userText.setText("Login or Password is incorrect");
        }
    }

    @FXML
    public void back() throws IOException {
        Stage stage = (Stage) Back.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("enter_form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void signingUp() throws IOException {
        Stage stage = (Stage) SignUp.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("register_form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void creation() throws IOException {
        String log = userLog.getText();
        String pass = userPass.getText();
        accounts.add(new Account(log, pass));
        Stage stage = (Stage) Create.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("enter_form_form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}