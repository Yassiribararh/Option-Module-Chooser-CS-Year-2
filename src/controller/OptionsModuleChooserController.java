package controller;

import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Collection;

import javax.swing.DefaultListModel;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;



import model.Course;
import model.Delivery;
import model.Module;
import model.Name;
import model.StudentProfile;



import view.OptionsModuleChooserRootPane;
import view.MyMenuBar;
import view.CreatProfile;
import view.OverviewResultsPane;
import view.SelectModules;


public class OptionsModuleChooserController {

	//fields to be used throughout the class
	private OptionsModuleChooserRootPane view;
	
	
	private CreatProfile profilePnl;
	private MyMenuBar menuBar;
	private OverviewResultsPane overviewPnl;
	private SelectModules selectMod;
	private StudentProfile model;
	int credit = 0;

	public OptionsModuleChooserController(OptionsModuleChooserRootPane view, StudentProfile model) {
		//initialise model and view fields
		this.model = model;
		this.view = view;
		
		
		profilePnl = view.getCreatProfile();
		menuBar = view.getMyMenuBar();
		selectMod = view.getSelectModules();
		overviewPnl = view.getOverviewResultsPane();
		/*model = view.getStudentProfile();
		view = view.getOptionsModuleChooserRootPane();
*/
		//populate combobox in create profile pane, e.g. if profilePane represented your create profile pane you could invoke the line below
		//profilePane.populateComboBoxWithCourses(setupAndRetrieveCourses());
		profilePnl.populateComboBox( setupAndRetrieveCourses());
		
		profilePnl.addCreateProfileListenner(new createButtonHandler());
		//attach event handlers to view using private helper method
		this.attachEventHandlers();	

	}

	private void attachEventHandlers() {
		/* ---TO DO - implement AboutHandler ---*/

		menuBar.addExitHandler(e -> System.exit(0));
		menuBar.addAboutHandler(e -> this.alertDialogBuilder(AlertType.INFORMATION, "Information Dialog", null, "App Made by Yassir Ibararh P16224469"));
		menuBar.addLoadHandler(new LoadMenuHandler());
		menuBar.addSaveHandler(new SaveMenuHandler());
		
		
		selectMod.addAdd1Handler(new AddButton1Handler());
		selectMod.addAdd2Handler(new AddButton2Handler());
		selectMod.addRemove1Handler(new AddRemove1Handler());
		selectMod.addRemove2Handler(new AddRemove2Handler());
		selectMod.addSubmitHandler(new AddSubmitHandler() );
		selectMod.addResetListener(new AddResetHandler());
		
		overviewPnl.addSaveListener(new AddSaveOverviewHandler());
		
		/*---TO DO - attach handlers to view some may be lambdas and some named inner classes ---*/

		
		
		// profilePnl.populateComboBox(setupCreateProfile());	

		
	
	
	
	}
	

	                
	private Course[] setupAndRetrieveCourses() {
		Module imat3423 = new Module("IMAT3423", "Systems Building: Methods", 15, true, Delivery.TERM_1);
		Module imat3451 = new Module("IMAT3451", "Computing Project", 30, true, Delivery.YEAR_LONG);
		Module ctec3902_SoftEng = new Module("CTEC3902", "Rigorous Systems", 15, true, Delivery.TERM_2);	
		Module ctec3902_CompSci = new Module("CTEC3902", "Rigorous Systems", 15, false, Delivery.TERM_2);
		Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15, false, Delivery.TERM_1);
		
		Module ctec3426 = new Module("CTEC3426", "Telematics", 15, false, Delivery.TERM_1);
		Module ctec3605 = new Module("CTEC3605", "Multi-service Networks 1", 15, false, Delivery.TERM_1);	
		Module ctec3606 = new Module("CTEC3606", "Multi-service Networks 2", 15, false, Delivery.TERM_2);	
		Module ctec3410 = new Module("CTEC3410", "Web Application Penetration Testing", 15, false, Delivery.TERM_2);
		Module ctec3904 = new Module("CTEC3904", "Functional Software Development", 15, false, Delivery.TERM_2);
		Module ctec3905 = new Module("CTEC3905", "Front-End Web Development", 15, false, Delivery.TERM_2);
		Module ctec3906 = new Module("CTEC3906", "Interaction Design", 15, false, Delivery.TERM_1);
		Module imat3410 = new Module("IMAT3104", "Database Management and Programming", 15, false, Delivery.TERM_2);
		Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based Systems", 15, false, Delivery.TERM_1);
		
		Module imat3611 = new Module("IMAT3611", "Popular Technology Ethics", 15, false, Delivery.TERM_1);
		Module imat3613 = new Module("IMAT3613", "Data Mining", 15, false, Delivery.TERM_1);
		Module imat3614 = new Module("IMAT3614", "Big Data and Business Models", 15, false, Delivery.TERM_2);
		Module imat3428_CompSci = new Module("IMAT3428", "Information Technology Services Practice", 15, false, Delivery.TERM_2);

		Course compSci = new Course("Computer Science");
		compSci.addModuleToCourse(imat3423);
		compSci.addModuleToCourse(imat3451);
		compSci.addModuleToCourse(ctec3902_CompSci);
		compSci.addModuleToCourse(ctec3110);
		compSci.addModuleToCourse(ctec3426);
		compSci.addModuleToCourse(ctec3605);
		compSci.addModuleToCourse(ctec3606);
		compSci.addModuleToCourse(ctec3410);
		compSci.addModuleToCourse(ctec3904);
		compSci.addModuleToCourse(ctec3905);
		compSci.addModuleToCourse(ctec3906);
		compSci.addModuleToCourse(imat3410);
		compSci.addModuleToCourse(imat3406);
		compSci.addModuleToCourse(imat3611);
		compSci.addModuleToCourse(imat3613);
		compSci.addModuleToCourse(imat3614);
		compSci.addModuleToCourse(imat3428_CompSci);

		Course softEng = new Course("Software Engineering");
		softEng.addModuleToCourse(imat3423);
		softEng.addModuleToCourse(imat3451);
		softEng.addModuleToCourse(ctec3902_SoftEng);
		softEng.addModuleToCourse(ctec3110);
		softEng.addModuleToCourse(ctec3426);
		softEng.addModuleToCourse(ctec3605);
		softEng.addModuleToCourse(ctec3606);
		softEng.addModuleToCourse(ctec3410);
		softEng.addModuleToCourse(ctec3904);
		softEng.addModuleToCourse(ctec3905);
		softEng.addModuleToCourse(ctec3906);
		softEng.addModuleToCourse(imat3410);
		softEng.addModuleToCourse(imat3406);
		softEng.addModuleToCourse(imat3611);
		softEng.addModuleToCourse(imat3613);
		softEng.addModuleToCourse(imat3614);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}

	private class createButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent e) {	
			System.out.println("create profile");
			view.changeTab(1);
			selectMod.setUnselected1(setUp1());
			selectMod.setUnselected2(setUp2());
			selectMod.setSelectedyearlong(setUp3());
			selectMod.setSelected1(setUp4());
			
			selectMod.setSelected2(setUp5());
			
			
			
			
			
		
			String fN = profilePnl.getFNameInput();
			String lN = profilePnl.getLNameInput();
			String pNo =profilePnl.getLPnumberInput();
			String Email = profilePnl.getemailInput();
			
			Course course = profilePnl.getSelectedCourse();
		 	//LoadModules3(course.getAllModulesOnCourse());
			
			
//			for (Module m: course.getModulesOnCourse()) {
//				if (m.isMandatory())
//					selectMod.addModule2_selected(m);
//				else selectMod.addModule(m);
//				
//					
//			}
			
			
		}
	}
	
		public void LoadModules1(Collection<Module> modules) {
			

			for (Module m: modules) 
				if (m.isMandatory())
					selectMod.addModule1(m);
			        
			
			
				else selectMod.addModule1(m);
				
			
		}
		
public void LoadModules2 (Collection<Module> modules) {
			

			for (Module m: modules) {
				if (m.getRunPlan().equals(Delivery.TERM_2))
					selectMod.addModuleselected2(m);
			        
			
			
				else selectMod.addModule2(m);
			
			}	
			
		}


public void LoadModules3(Collection<Module> modules) {
	

	for (Module m: modules) {
		if (m.isMandatory())
			selectMod.addModuleselected5(m);
	 else  selectMod.addModule3(m);
		
	}
}



public ObservableList<Module> setUp1(){
	selectMod.getselected1().removeAll();
	ObservableList<Module> list = FXCollections.observableArrayList();

	Course y = profilePnl.getSelectedCourse();
	

	for(Module s : y.getAllModulesOnCourse()){
		if (s.getRunPlan().equals(Delivery.TERM_1)) {
		list.add(s);
	}
	}
	return list;
}
	public ObservableList<Module> setUp2(){
		selectMod.getselected1().removeAll();
		ObservableList<Module> list = FXCollections.observableArrayList();

		Course y = profilePnl.getSelectedCourse();
		

		for(Module s : y.getAllModulesOnCourse()){
			if (s.getRunPlan().equals(Delivery.TERM_2)) {
			list.add(s);
		}
		}
		return list;
	}
		
		public ObservableList<Module> setUp3(){
			selectMod.getselected1().removeAll();
			ObservableList<Module> list = FXCollections.observableArrayList();

			Course y = profilePnl.getSelectedCourse();
			

			for(Module s : y.getAllModulesOnCourse()){
				if (s.getRunPlan().equals(Delivery.YEAR_LONG)) {
				list.add(s);
			}
			}
			return list;
}
		
		
		
		public ObservableList<Module> setUp4(){
			selectMod.getselected1().removeAll();
			ObservableList<Module> list = FXCollections.observableArrayList();

			Course y = profilePnl.getSelectedCourse();
			

			for(Module s : y.getAllModulesOnCourse()){
				if (s.getRunPlan().equals(Delivery.TERM_1)) {
					if (s.isMandatory()) {
				list.add(s);
				
			}
			}
			}
			return list;
}
		
		public ObservableList<Module> setUp5(){
			selectMod.getselected1().removeAll();
			ObservableList<Module> list = FXCollections.observableArrayList();

			Course y = profilePnl.getSelectedCourse();
			

			for(Module s : y.getAllModulesOnCourse()){
				if (s.getRunPlan().equals(Delivery.TERM_2)) {
					if (s.isMandatory()) {
				list.add(s);
			}
			}
			}
			return list;
}

private class AddButton1Handler implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		//retrieves name from view
		 
		
				selectMod.addModuleselected3(selectMod.getSelectedModuleterm1());
				
				
		
		System.out.println("ADD term1 button pressed");
		
		credit += selectMod.getSelectedModuleterm1().getCredits();
		selectMod.setTotalCredit1(Integer.toString(credit));
		//selectMod.removeunselectedModuleterm1();
		
		}
	}

private class AddButton2Handler implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		//retrieves name from view

		selectMod.addModuleselected4(selectMod.getSelectedModuleterm2());
		System.out.println("ADD term2 button pressed");
		credit += selectMod.getSelectedModuleterm2().getCredits();
		selectMod.setTotalCredit2(Integer.toString(credit));
		//selectMod.removeunselectedModuleterm2();

		}
	}

private class AddRemove1Handler implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		//retrieves name from view
		
		selectMod.removeSelectedModuleterm1();
		//selectMod.addModuleselected1(selectMod.getunSelectedModuleterm1());
		
		//selectMod.addModuleselected1(selectMod.getSelectedModuleterm1());
		
		/*credit += selectMod.getSelectedModuleterm1().getCredits();
		selectMod.ClearTotalCredit1();
		selectMod.setTotalCredit1(Integer.toString(credit));*/
		System.out.println("Remove term2 button Pressed");
	


		}
	}


private class AddRemove2Handler implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		//retrieves name from view

		selectMod.removeSelectedModuleterm2();
		//selectMod.addModuleselected2(selectMod.getunSelectedModuleterm1());
		System.out.println("Remove term2 button Pressed");
		


		}
	}

private class AddResetHandler implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		//retrieves name from view


		System.out.println("Reset button Pressed");

		selectMod.clearModulesterm1();

		selectMod.clearModulesterm2();
		
		selectMod.ClearTotalCredit1();
		
		selectMod.ClearTotalCredit2();
		selectMod.setSelected1(setUp4());
		
		selectMod.setSelected2(setUp5());
		
		}
	}


private class AddSubmitHandler implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		//retrieves name from view
		String name = profilePnl.getFNameInput()+ "\n" + profilePnl.getLNameInput();
		String pNum = profilePnl.getLPnumberInput() + "\n";
		String Email = profilePnl.getemailInput()+ "\n";
		LocalDate date = profilePnl.getDatePicker();
		
		String course = profilePnl.getSelectedCourse().toString();
		
		String module1 =  "\n\n Modules term1: \n\n" ;
		String module2 =  "\n\n Modules term2: \n\n";
		String module3 = "\n\n All year Modules: \n\n";
		
		
		for(int i = 0; i < selectMod.getselected1().size(); i++) {
			Module a = selectMod.getselected1().get(i);
			module1 = module1 + a.toString() + "\n";
		}
		
		for(int i = 0; i < selectMod.getselected2().size(); i++) {
			Module a = selectMod.getselected2().get(i);
			module2 = module2 + a.toString() + "\n";
		}
		
		for(int i = 0; i < selectMod.getselectedyearlong().size(); i++) {
			Module a = selectMod.getselectedyearlong().get(i);
			module3 = module3 + a.toString() + "\n";
		}

	
		
		
		System.out.println("Submit button Pressed");
		view.changeTab(2);
		overviewPnl.setOverview(null);
		overviewPnl.getOverview().setText("Full Name: \n " + name + "\n\n Pnumber: \n" + pNum + "\n\n Email: \n" + Email + "\n Date: \n" + date + "\n\n Selected Course: \n\n"  + course + module3 + module1 + module2 + "\n");
		}
	}


private class AddSaveOverviewHandler implements EventHandler<ActionEvent> {

	public void handle(ActionEvent e) {
		//retrieves name from view


		System.out.println("Save Overview button Pressed");
		

		}
	}

private class LoadMenuHandler implements EventHandler<ActionEvent> {
	public void handle(ActionEvent e) {
		//load in the data model
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("StudentProfileObj.dat"));) {

			model = (StudentProfile) ois.readObject();
		}
		catch (IOException ioExcep){
			System.out.println("Error loading");
		}
		catch (ClassNotFoundException c) {
			System.out.println("Class Not found");
		}


	}

}
private class SaveMenuHandler implements EventHandler<ActionEvent> {
	public void handle(ActionEvent e) {          
		//save the data model
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("StudentProfileObj.dat"));) {

			oos.writeObject(model);
			oos.flush();
		}
		catch (IOException ioExcep){
			System.out.println("Error saving");
		}
	}
}



	//helper method to build dialogs
		private void alertDialogBuilder(AlertType type, String title, String header, String content) {
			Alert alert = new Alert(type);
			alert.setTitle(title);
			alert.setHeaderText(header);
			alert.setContentText(content);
			alert.showAndWait();
		}
}

