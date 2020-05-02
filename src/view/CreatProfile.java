package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import model.StudentProfile;
import model.Module;
import model.Course;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;

import javax.swing.DefaultListModel;

import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javafx.scene.control.DatePicker;
import java.time.LocalDate;
import java.util.Date; 
import model.Course;
import model.Module;
import model.Name;




public class CreatProfile extends GridPane {

	private ComboBox<Course> comboCourse;
	private TextField txtSurname, txtFirstName, txtpnumber, txtemail;
	private Button btnPlay;
	private Stage stage;
	private DatePicker date;
	private DefaultListModel<Module> listModel;

	public CreatProfile() {
		//styling
		this.setPadding(new Insets(100, 100, 100, 100));
		this.setVgap(15);
		this.setHgap(20);
		this.setAlignment(Pos.CENTER);
		
		
		
		//create labels
		Label lblTitle = new Label("Select Course ");
		Label lblPnumber = new Label("Input Pnumber ");
		Label lblFirstName = new Label("input First name: ");
		Label lblSurname = new Label("Input Surname: ");
		Label lblemail = new Label("Input email: ");
		Label lbldate = new Label("Input date: ");

		// setup combobox
		comboCourse = new ComboBox<Course>(); //will be populated via method towards end of class

		//setup text fields
		txtFirstName = new TextField();
		txtSurname = new TextField();
		txtpnumber = new TextField();
		txtemail = new TextField();
		
		//initialise play button
		btnPlay = new Button("Create Profile");
		
		
		comboCourse.getSelectionModel().select(0);
		//add controls and labels to container
		this.add(lblTitle, 0, 0);
		this.add(comboCourse, 1, 0);
		
		this.add(lblPnumber, 0, 1);
		this.add(txtpnumber, 1, 1);
		
		this.add(lblFirstName, 0, 2);
		this.add(txtFirstName, 1, 2);

		this.add(lblSurname, 0, 3);
		this.add(txtSurname, 1, 3);
		
		this.add(lblemail, 0, 4);
		this.add(txtemail, 1, 4);
		
		this.add(lbldate, 0, 5);
		
			
		this.add(new HBox(), 0, 6);
		this.add(btnPlay, 1, 6);
	
		
        date = new DatePicker();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        this.add(date, 1, 5);
        this.getChildren().add(gridPane);
	}
	
	public void addModule(Module a) {
		listModel.addElement(a);
	}
 
	public LocalDate getDatePicker() {
		return date.getValue();
	}
	
	
	public void populateComboBox(Course[] courses) {
		comboCourse.getItems().addAll(courses);
		comboCourse.getSelectionModel().select(0);
		}

	
	public String getFNameInput() {
		return txtFirstName.getText();
	}
	
	public String getLNameInput() {
		return txtSurname.getText();
	}
	
	public String getLPnumberInput() {
		return txtpnumber.getText();
	}
	
	public String getemailInput() {
		return txtemail.getText();
	}
	
	public Course getSelectedCourse() {
		return comboCourse.getSelectionModel().getSelectedItem();
	}
	
	
	public BooleanBinding isEitherFieldEmpty() {
		return txtFirstName.textProperty().isEmpty().or(txtSurname.textProperty().isEmpty());
	}
	
	
	public void reset() {
		//comboCourse
		txtFirstName.setText("");
		txtSurname.setText("");
		txtpnumber.setText("");
		txtemail.setText("");
	}
	
	public void addCourseListener(EventHandler<ActionEvent> handler) {
  		btnPlay.setOnAction(handler);
	}
	
	public void addCreateProfileListenner(EventHandler<ActionEvent> handler) {
  		btnPlay.setOnAction(handler);
	}
	
	
	//method to attach the play button handler
	public void addPlayGameListener(EventHandler<ActionEvent> handler) {
		btnPlay.setOnAction(handler);
	}

	
	
	
	
}

