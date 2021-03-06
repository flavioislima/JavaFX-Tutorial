package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.address.MainApp;
import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    // Reference to the main application.
    private MainApp mainApp;

    /**
     * O construtor.
     * O construtor � chamado antes do m�todo inicialize().
     */
    public PersonOverviewController() {
    }

    /**
     * Inicializa a classe controller. Este m�todo � chamado automaticamente
     *  ap�s o arquivo fxml ter sido carregado.
     */
    @FXML
    private void initialize() {
        // Inicializa a tabela de pessoa com duas colunas.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        //Limpa os detalhes das pessoas
        showPersonDetails(null);

        //Observa mudan�as de sele��o e mostra o detalhe da pessoa selecionada
        personTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)
        		-> showPersonDetails(newValue));

    }

    /**
     * � chamado pela aplica��o principal para dar uma refer�ncia de volta a si mesmo.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Adiciona os dados da observable list na tabela
        personTable.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(Person person){
    	if (person != null){
    		firstNameLabel.setText(person.getFirstName());
    		lastNameLabel.setText(person.getLastName());
    		streetLabel.setText(person.getStreet());
    		postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
    		cityLabel.setText(person.getCity());
    		birthdayLabel.setText(DateUtil.format(person.getBirthday()));

    	}
    	else{
    		firstNameLabel.setText("");
    		lastNameLabel.setText("");
    		streetLabel.setText("");
    		postalCodeLabel.setText("");
    		cityLabel.setText("");
    		birthdayLabel.setText("");
    	}
    }

    //Chamado para deletar uma pessoa da lista
    @FXML
    private void deletarPessoa(){
    	int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
    	if (selectedIndex >= 0){
    	personTable.getItems().remove(selectedIndex);
    	} else{
    		Alert alert = new Alert(AlertType.WARNING);
    		alert.setTitle("Nada selecionado!");
    		alert.setHeaderText("Nenhuma pessoa selecionada!");
    		alert.setContentText("Por favor, selecione uma pessoa na tabela!");

    		alert.showAndWait();
    	}
    }

}