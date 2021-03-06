package wellfernandes.com.github.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import wellfernandes.com.github.model.Fsm;
import wellfernandes.com.github.model.State;

public class ControllerPrincipalView implements Initializable {

	@FXML
	private Button btnCreateState;

	@FXML
	private Button btnDeleteState;

	@FXML
	private Button btnInsertTransition;

	@FXML
	private Button checkModeling;

	@FXML
	private Button clearTrace;

	@FXML
	private Button generateReport;

	@FXML
	private AnchorPane mainPane;

	private Fsm fsm = new Fsm();

	private State state;

	private Stage stage;
	private Scene scene;

	private FxViewer view;
	private FxViewPanel panel;
	private StackPane nodePane;

	private Graph node;
	private List<Graph> listNodes = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);

	@FXML
	void onClickBtncreateState(ActionEvent event) {


		node = new SingleGraph("graph"); // node
		state = new State();

		listNodes.add(node); // add node in list nodes
		fsm.getStates().add(state); // add state in final state machine
		fsm.setLastState(state); // add last state

		node.addNode("test");
		node.setAutoCreate(true);
		
		view = new FxViewer(node, FxViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
		panel = (FxViewPanel) view.addView(FxViewer.DEFAULT_VIEW_ID, new FxGraphRenderer());
		nodePane = new StackPane();

		nodePane.getChildren().addAll(panel); // prevent UI shift issues

		view.enableAutoLayout();
		view.getDefaultView().enableMouseOptions();
		mainPane.getChildren().add(nodePane);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		view = new FxViewer(node, FxViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
		panel = (FxViewPanel) view.addView(FxViewer.DEFAULT_VIEW_ID, new FxGraphRenderer());
		nodePane = new StackPane();

		nodePane.getChildren().addAll(panel); // prevent UI shift issues

		view.enableAutoLayout();
		view.getDefaultView().enableMouseOptions();
		mainPane.getChildren().add(nodePane);

	}

	public boolean onCloseQuery() {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

		alert.setTitle("Do you want to close?");
		alert.setHeaderText("Are you sure?");

		ButtonType buttonYes = ButtonType.YES;
		ButtonType buttonNo = ButtonType.NO;

		alert.getButtonTypes().setAll(buttonYes, buttonNo);
		Optional<ButtonType> clickedButton = alert.showAndWait();

		return clickedButton.get() == buttonYes ? true : false;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Button getBtnCreateState() {
		return btnCreateState;
	}

	public void setBtnCreateState(Button btnCreateState) {
		this.btnCreateState = btnCreateState;
	}

	public Button getBtnDeleteState() {
		return btnDeleteState;
	}

	public void setBtnDeleteState(Button btnDeleteState) {
		this.btnDeleteState = btnDeleteState;
	}

	public Button getBtnInsertTransition() {
		return btnInsertTransition;
	}

	public void setBtnInsertTransition(Button btnInsertTransition) {
		this.btnInsertTransition = btnInsertTransition;
	}

	public Button getCheckModeling() {
		return checkModeling;
	}

	public void setCheckModeling(Button checkModeling) {
		this.checkModeling = checkModeling;
	}

	public Button getClearTrace() {
		return clearTrace;
	}

	public void setClearTrace(Button clearTrace) {
		this.clearTrace = clearTrace;
	}

	public Button getGenerateReport() {
		return generateReport;
	}

	public void setGenerateReport(Button generateReport) {
		this.generateReport = generateReport;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public AnchorPane getMainPane() {
		return mainPane;
	}

	public void setMainPane(AnchorPane mainPane) {
		this.mainPane = mainPane;
	}
}
