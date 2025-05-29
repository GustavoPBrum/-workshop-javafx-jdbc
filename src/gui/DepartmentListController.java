package gui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable, DataChangeListener{
	
	private DepartmentService service;
	
	@FXML
	private TableView<Department> tableViewDepartment;

	@FXML
	private TableColumn<Department, Integer> tableColumnId;

	@FXML
	private TableColumn<Department, String> tableColumnName;

	@FXML
	private Button btNew;
	
	private ObservableList<Department> obsList;
	
	@FXML
	public void onBtNewAction(ActionEvent event) {  // Para ter uma referencia para o controller que recebeu o event
		Stage parentStage = Utils.currentStage(event);  // referencia para o stage atual
		Department obj = new Department();  // Department vazio
		createDialogForm(obj, "/gui/DepartmentForm.fxml", parentStage);
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;  // Injecao de dependencia com principio SOLID
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}

	private void initializeNodes() {
		// Padrao JavaFX para iniciar o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();  // Ref para janela principal
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());  // Jeito de fazer o table department acompanhar a altura da janela
	}
	
	// Acessa o service, carrega os departmente e jogar no obsList
	public void updateTableView() {
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		
		tableViewDepartment.setItems(obsList);
	}
	
	// Quando criamos uma janela de dialogo, temos que informa-la quem eh o stage que criou essa janela de dialogo
	private void createDialogForm(Department obj, String  absoluteName, Stage parentStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			Pane pane = loader.load();  // Carrega a view
			
			DepartmentFormController controller = loader.getController();  // Controller da instancia atual
			controller.setDepartment(obj);   
			controller.setDepartmentService(new DepartmentService());  // Injetamos o service
			
			// O proprio objeto se inscreve para receber o evento 
			controller.subscribeDataChanceLinstener(this); 
			
			controller.updateFormData();  // Vai carregar os dados do department vazio nas caixas de texto txtId e txtName
			
			
			// Um palco na frente de outro
			Stage dialogStage = new Stage();  // Novo Stage
			dialogStage.setTitle("Enter Department data");
			dialogStage.setScene(new Scene(pane));  // Nova scene
			dialogStage.setResizable(false); // Se pode ser redimensionada
			dialogStage.initOwner(parentStage);  // Stage **pai** dessa janela
			
			// Enquanto a janela nao for fechada, nao pode acessar a janela anterior
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.showAndWait();
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void onDataChanged() {  // Na hora que disparar que foram alteraram os dados
		updateTableView();
	}
}
