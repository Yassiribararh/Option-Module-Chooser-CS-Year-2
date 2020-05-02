package view;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JTextArea;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class OverviewResultsPane extends StackPane {

	private TextArea results;
	private Button saveOverview;
	
	
	public OverviewResultsPane() {
		
		
		VBox v1 = new VBox();
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(30));
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(10);
		this.getChildren().addAll(grid);
		
		results = new TextArea("Overview will appear here...");
		results.setEditable(false);
		results.setMinSize(250, 300);
		GridPane.setHgrow(results, Priority.ALWAYS);
		GridPane.setVgrow(results, Priority.ALWAYS);
		grid.add(results, 0, 0);
		
		
		saveOverview = new Button("Save Overview");

		saveOverview.setAlignment( Pos.CENTER);
		
		GridPane.setHalignment(saveOverview, HPos.CENTER);
		grid.add(saveOverview, 0, 1);
		
	
		
		
	
	
		
		
		
	}
	
	//methods to update the content of this pane
	public void setOverview(String overview) {
		results.setText(overview);
	}
	public TextArea getOverview() {
		return results;


	}

	public void setColor(String colour) {
		this.setStyle("-fx-background-color: " + colour + ";");
	}
	
	public void addSaveListener(EventHandler<ActionEvent> handler) {
		saveOverview.setOnAction(handler);
	}
	
}
