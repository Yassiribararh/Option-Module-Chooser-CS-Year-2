package view;

import javafx.scene.layout.BorderPane;
import model.StudentProfile;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;

//You may change this class to extend another type if you wish
public class OptionsModuleChooserRootPane extends BorderPane {

	private CreatProfile sgp;
	private OverviewResultsPane orp;
	private MyMenuBar mmb;
	private SelectModules sm;
	private TabPane tp;
	private OptionsModuleChooserRootPane view;
	private StudentProfile model;
	public OptionsModuleChooserRootPane() {
		tp = new TabPane();
		
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE); //don't allow tabs to be closed
		
		mmb = new MyMenuBar();
		
		sgp = new CreatProfile();
		orp = new OverviewResultsPane();
		sm = new SelectModules();
	
		//create tabs with panes added
		Tab t1 = new Tab("Create Profile", sgp);
		Tab t2 = new Tab("Select Modules", sm);
		Tab t3 = new Tab("Overview Results", orp);
		
		//add tabs to tab pane
		tp.getTabs().addAll(t1, t2, t3);
		
		this.setTop(mmb);
		this.setCenter(tp);
		
	}

	/* These methods provide a public interface for the root pane and allow
	 * each of the sub-containers to be accessed by the controller. */
	public CreatProfile getCreatProfile() {
		return sgp;
	}

	public OverviewResultsPane getOverviewResultsPane() {
		return orp;
	}
	public SelectModules getSelectModules() {
		return sm;
	}
	
	public OptionsModuleChooserRootPane getOptionsModuleChooserRootPane() {
		return view;
	}
	
	public StudentProfile getStudentProfile() {
		return model;
	}

	public MyMenuBar getMyMenuBar() {
		return mmb;
	}
	
	//method to allow the controller to change tabs
	public void changeTab(int index) {
		tp.getSelectionModel().select(index);
	}
}

