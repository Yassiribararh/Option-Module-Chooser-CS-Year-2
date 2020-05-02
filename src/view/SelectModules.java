package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Delivery;
import model.Module;
import model.Name;
import model.Course;

public class SelectModules extends HBox {

	
	
	
	private ListView<Module> selectedresultsterm1;
	private ListView<Module> selectedresultsterm2;
	private ListView<Module> unselectedresultsterm1;
	private ListView<Module> unselectedresultsterm2;
	private ListView<Module> selectedresultsyearlong;
	private TextArea creditsterm1;
	private TextArea creditsterm2;
	private Button add1, add2;
	private Button remove1, remove2;
	private Button Submit;
	private Button reset;
	
	
	/**
	 * 
	 */
	private ObservableList<Module> unselectedterm1;
	private ObservableList<Module> unselectedterm2;
	private ObservableList<Module> selectedterm1;
	private ObservableList<Module> selectedterm2;
	private ObservableList<Module> selectedyearlong;
	

	
	
	

		public SelectModules() {
			/*
			 * This pane is a FlowPane with left to right layout (by default),
			 * and horizontal and vertical gaps between its children (set as
			 * parameters)
			 */
			
			Label unselected1 = new Label("Unselected Term 1 modules");
			Label unselected2 = new Label("Unselected Term 2 modules");
			Label selected1 = new Label("selected Term 1 modules");
			Label selected2 = new Label("selected Term 2 modules");
			Label selectedyear = new Label("selected Year Long modules");
			Label term1 = new Label("Term 1");
			Label term2 = new Label("Term 2");
			Label credits1 = new Label("Current term 1 credits");
			Label credits2 = new Label("Current term 2 credits");

		
			GridPane rootpane = new GridPane();
			rootpane.setPadding(new Insets(5));
			rootpane.setAlignment(Pos.CENTER);
			this.getChildren().addAll(rootpane);
			
			HBox.setHgrow(rootpane, Priority.ALWAYS);
			VBox.setVgrow(rootpane, Priority.ALWAYS);
			
			GridPane modulegrid1 = new GridPane();
			modulegrid1.setAlignment(Pos.CENTER_LEFT);
			modulegrid1.setPadding(new Insets(5));
			GridPane.setVgrow(modulegrid1, Priority.ALWAYS);
			GridPane.setHgrow(modulegrid1, Priority.ALWAYS);
			rootpane.add(modulegrid1, 0, 0);
			
			GridPane modulegrid2 = new GridPane();
			modulegrid2.setAlignment(Pos.CENTER_RIGHT);
			modulegrid2.setPadding(new Insets(5));
			GridPane.setVgrow(modulegrid2, Priority.ALWAYS);
			GridPane.setHgrow(modulegrid2, Priority.ALWAYS);
			rootpane.add(modulegrid2, 1, 0);
			
			HBox h1 = new HBox();
			h1.setPadding(new Insets(10));
			h1.setAlignment(Pos.CENTER);
			h1.setSpacing(10);
			HBox.setHgrow(h1, Priority.ALWAYS);
			modulegrid1.add(h1, 0, 2);
			
			HBox h2 = new HBox();
			h2.setPadding(new Insets(10));
			h2.setAlignment(Pos.CENTER);
			h2.setSpacing(10);
			HBox.setHgrow(h2, Priority.ALWAYS);
			modulegrid1.add(h2, 0, 5);
			
			HBox h3 = new HBox();
			h3.setPadding(new Insets(10));
			h3.setAlignment(Pos.CENTER);
			h3.setSpacing(10);
			HBox.setHgrow(h3, Priority.ALWAYS);
			modulegrid1.add(h3, 0, 6);
			
			HBox h4 = new HBox();
			h4.setPadding(new Insets(10));
			h4.setAlignment(Pos.CENTER);
			h4.setSpacing(10);
			HBox.setHgrow(h4, Priority.ALWAYS);
			modulegrid2.add(h4, 0, 6);
			
			//have to delete this
		
			
			modulegrid1.add(unselected1, 0, 0);
			modulegrid1.add(unselected2, 0, 3);
			h1.getChildren().add(term1);
			h1.setAlignment(Pos.CENTER);
			h2.getChildren().add(term2);
			h2.setAlignment(Pos.CENTER);
			
			h3.getChildren().add(credits1);
			modulegrid2.add(selectedyear, 0, 0);
			modulegrid2.add(selected1, 0, 2);
			modulegrid2.add(selected2, 0, 4);
			h4.getChildren().add(credits2);
			
			
			
			//grid.setAlignment(Pos.TOP_LEFT);

		     add1 = new Button("Add");
	         remove1 = new Button("Remove");
	         add2 = new Button("Add");
	         remove2 = new Button("Remove");
	         Submit = new Button("Submit");
	         reset = new Button("Reset");
			
			
	      
	         
	        selectedterm1 = FXCollections.observableArrayList();
	        selectedresultsterm1 = new ListView<>(selectedterm1);
		    selectedresultsterm1.setEditable(false);
		    selectedresultsterm1.setPrefSize(300, 95);
			GridPane.setHgrow(selectedresultsterm1, Priority.ALWAYS);
			GridPane.setVgrow(selectedresultsterm1, Priority.ALWAYS);
			modulegrid2.add(selectedresultsterm1, 0, 3);
			
			
			
			selectedterm2 = FXCollections.observableArrayList();
			selectedresultsterm2 = new ListView<>(selectedterm2);
			selectedresultsterm2.setEditable(false);
			selectedresultsterm2.setPrefSize(300, 95);
			selectedresultsterm2.setEditable(false);
			GridPane.setHgrow(selectedresultsterm2, Priority.ALWAYS);
			GridPane.setVgrow(selectedresultsterm2, Priority.ALWAYS);
			modulegrid2.add(selectedresultsterm2, 0, 5);
			
			unselectedterm1 = FXCollections.observableArrayList();
			unselectedresultsterm1 = new ListView<>(unselectedterm1);
			unselectedresultsterm1.setPrefSize(300, 95);
			GridPane.setHgrow(unselectedresultsterm1, Priority.ALWAYS);
			GridPane.setVgrow(unselectedresultsterm1, Priority.ALWAYS);
			modulegrid1.add(unselectedresultsterm1, 0, 1);
			
			unselectedterm2 = FXCollections.observableArrayList();
			unselectedresultsterm2 = new ListView<>(unselectedterm2);
			unselectedresultsterm2.setPrefSize(300, 95);
			GridPane.setHgrow(unselectedresultsterm2, Priority.ALWAYS);
			GridPane.setVgrow(unselectedresultsterm2, Priority.ALWAYS);
			modulegrid1.add(unselectedresultsterm2, 0, 4);
			
			
			selectedyearlong = FXCollections.observableArrayList();
			selectedresultsyearlong = new ListView<>(selectedyearlong);
			selectedresultsyearlong.setEditable(false);
			selectedresultsyearlong.setPrefSize(300, 45);
			GridPane.setHgrow(selectedresultsyearlong, Priority.ALWAYS);
			GridPane.setVgrow(selectedresultsyearlong, Priority.ALWAYS);
			modulegrid2.add(selectedresultsyearlong, 0, 1);
			
			creditsterm1 = new TextArea("0");
			creditsterm1.setEditable(false);
			creditsterm1.setPrefSize(40, 30);
			h3.getChildren().add(creditsterm1);
			
			
			creditsterm2 = new TextArea("0");
			creditsterm2.setEditable(false);
			creditsterm2.setPrefSize(40, 30);
			h4.getChildren().add(creditsterm2);
			
			
	
			
			add1 =  new Button("Add");
			h1.setAlignment(Pos.CENTER);
			h1.getChildren().add(add1);
			
			add2 = new Button("Add");
			h2.setAlignment(Pos.CENTER);		
			h2.getChildren().add(add2);
			
			remove1 = new Button("Remove");
			h1.setAlignment(Pos.CENTER);
			h1.getChildren().add(remove1);
			
			remove2 = new Button("Remove");
			h2.setAlignment(Pos.CENTER);
			h2.getChildren().add(remove2);
			
			reset = new Button("Reset");
			GridPane.setHalignment(reset, HPos.RIGHT);
			modulegrid1.add(reset, 0, 7);
			
			Submit = new Button("Submit");
			GridPane.setHalignment(Submit, HPos.LEFT);
			modulegrid2.add(Submit, 0, 7);
	}
		
		public void setTotalCredit1(String a) {
			creditsterm1.setText(a);
		}
		
		public void setTotalCredit2(String a) {
			creditsterm2.setText(a);
		}
		
		public void ClearTotalCredit1() {
			creditsterm1.clear();
		}
		
		public void ClearTotalCredit2() {
			creditsterm2.clear();
		}
		
		
		public int getTotalCredit1() {
			int creditTotal = 0;
		//	String tCredit = a;
			
			for(int i=0; i < selectedterm1.size(); i++) {
				
				creditTotal = creditTotal + selectedterm1.get(i).getCredits();
				}
				return creditTotal;
			}
		//getElementAt
		
		
		public int getTotalCredit2() {
			int creditTotal = 0;
		//	String tCredit = a;
			
			for(int i=0; i < selectedterm2.size(); i++) {
				
				creditTotal = creditTotal + selectedterm2.get(i).getCredits();
				}
				return creditTotal;
			}
		
		public Module getunSelectedModuleterm1() {
			return unselectedresultsterm1.getSelectionModel().getSelectedItem();
		}
		
		public Module getunSelectedModuleterm2() {
			return unselectedresultsterm2.getSelectionModel().getSelectedItem();
		}
		
		public Module getSelectedModuleterm1() {
			return unselectedresultsterm1.getSelectionModel().getSelectedItem();
		}
		
		public Module getSelectedModuleterm2() {
			return unselectedresultsterm2.getSelectionModel().getSelectedItem();
		}
		
		public void addModule1(Module a) {
			unselectedterm1.add(a);
			
			unselectedresultsterm1.setItems(unselectedterm1);
		}
		
		public void addModule2(Module a) {
			unselectedterm2.add(a);
			
			unselectedresultsterm2.setItems(unselectedterm2);
		}
		
		public void addModule3(Module a) {
			selectedyearlong.add(a);
			
			selectedresultsyearlong.setItems(selectedyearlong);
		}
		
		
		public void setUnselected1(ObservableList<Module> listModel){
			this.unselectedterm1 = listModel;
			unselectedresultsterm1.setItems(listModel);
		}
		
		public void setUnselected2(ObservableList<Module> listModel){
			this.unselectedterm2 = listModel;
			unselectedresultsterm2.setItems(listModel);
		}
		
		public void setSelected1(ObservableList<Module> listModel){
			this.selectedterm1 = listModel;
			selectedresultsterm1.setItems(listModel);
		}
		
		public void setSelected2(ObservableList<Module> listModel){
			this.selectedterm2 = listModel;
			selectedresultsterm2.setItems(listModel);
		}
		
		public void setSelectedyearlong(ObservableList<Module> listModel){
			this.selectedyearlong = listModel;
			selectedresultsyearlong.setItems(listModel);
		}
		
		
		public ObservableList<Module> getUnselected1() {
			return unselectedterm1;
		}
		
		public ObservableList<Module> getUnselected2() {
			return unselectedterm2;
		}
		
		
		
		public ObservableList<Module> getselected1() {
			return selectedterm1;
		}
		
		
		public ObservableList<Module> getselected2() {
			return selectedterm2;
		}
		
		
		public ObservableList<Module> getselectedyearlong() {
			return selectedyearlong;
		}
		
		
		 
		
		public void addModuleselected1(Module module) {
			unselectedterm1.add(module);
			this.clearSelectionterm1();
		}
		
		public void addModuleselected2(Module module) {
			unselectedterm2.add(module);
			this.clearSelectionterm2();
		}
		
		public void addModuleselected3(Module module) {
			selectedterm1.add(module);
			this.clearSelectionterm1();
		}
		
		
		
		public void addModuleselected4(Module module) {
			selectedterm2.add(module);
			this.clearSelectionterm1();
			
			
		}
		
		
		public void addModuleselected5(Module module) {
			selectedyearlong.add(module);
			this.clearSelectionterm1();
		}
		
		public void clearunSelectionterm1() {
			unselectedresultsterm1.getSelectionModel().clearSelection();
		}
		
		public void clearunSelectionterm2() {
			unselectedresultsterm2.getSelectionModel().clearSelection();
		}
	
		public void clearSelectionterm1() {
			selectedresultsterm1.getSelectionModel().clearSelection();
		}
		
		public void clearSelectionterm2() {
			selectedresultsterm2.getSelectionModel().clearSelection();
		}
		
		public void clearModulesterm1() {
			selectedterm1.clear();
		}
		public void clearModulesterm2() {
			selectedterm2.clear();
		}
		public void clearModulesyear() {
			selectedyearlong.clear();
		}
		
		public void removeunselectedModuleterm1() {
          int index = unselectedresultsterm1.getSelectionModel().getSelectedIndex();
			
			if (index != -1) {
				unselectedterm1.removeAll(this.getunSelectedModuleterm1());
				this.clearunSelectionterm1();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Selection Error");
				alert.setContentText("Please select an item to add.");
				alert.showAndWait();
			}
		}
		
		public void removeunselectedModuleterm2() {
	          int index = unselectedresultsterm2.getSelectionModel().getSelectedIndex();
				
				if (index != -1) {
					unselectedterm2.removeAll(this.getunSelectedModuleterm2());
					this.clearunSelectionterm2();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Selection Error");
					alert.setContentText("Please select an item to add.");
					alert.showAndWait();
				}
			}
			
		
		public void removeSelectedModuleterm1() {
			int index = selectedresultsterm1.getSelectionModel().getSelectedIndex();
			
			if (index != -1) {
				selectedterm1.removeAll(this.getSelectedModuleterm1());
				this.clearSelectionterm1();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Selection Error");
				alert.setContentText("Please select an item to remove.");
				alert.showAndWait();
			}
		}
		
		
		public void removeSelectedModuleterm2() {
			int index = selectedresultsterm2.getSelectionModel().getSelectedIndex();
			
			if (index != -1) {
				selectedterm2.removeAll(this.getSelectedModuleterm2());
				this.clearSelectionterm2();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Selection Error");
				alert.setContentText("Please select an item to remove.");
				alert.showAndWait();
			}
		}
		
		
		
		
		public void add1DisableBind(BooleanBinding property) {
			add1.disableProperty().bind(property);
		}
		
		public void add2DisableBind(BooleanBinding property) {
			add2.disableProperty().bind(property);
		}
		
		//these methods allow handlers to be externally attached to this view
		public void addAdd1Handler(EventHandler<ActionEvent> handler) {
			add1.setOnAction(handler);
		}
		public void addAdd2Handler(EventHandler<ActionEvent> handler) {
			add2.setOnAction(handler);
		}
	
		public void addRemove1Handler(EventHandler<ActionEvent> handler) {
			remove1.setOnAction(handler);
		}

		public void addRemove2Handler(EventHandler<ActionEvent> handler) {
			remove2.setOnAction(handler);
		}
		
		public void addSubmitHandler(EventHandler<ActionEvent> handler) {
			Submit.setOnAction(handler);
		}
		
		public void addResetListener(EventHandler<ActionEvent> handler) {
			reset.setOnAction(handler);
		}

		
		public void setColor(String colour) {
		this.setStyle("-fx-background-color: " + colour + ";");
	}
}
		
		