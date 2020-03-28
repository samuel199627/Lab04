package it.polito.tdp.lab04;

import javafx.application.Application;

import static javafx.application.Application.launch;

import it.polito.tdp.lab04.FXMLController;
import it.polito.tdp.lab04.model.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Model model = new Model();
        
        
        FXMLController controller = loader.getController();
        
        
        /*
		 * Create and set the model here!
		 */
        //ho inserito la stampa di CIAO2 PERCHE' dobbiamo inizializzare i corsi nel menu a tendina a quelli che 
        //sono disponibili il problema e' che non possiamo farlo nell'inizialize() perche' il modello viene 
        //solo caricato a questo punto e prima non e' ancora stato caricato. Per cui dobbiamo andare a 
        //eseguire il caricamento quando settiamo il modello ovvero quando viene richiamato questo metodo.
        //System.out.println("CIAO2\n");
		controller.setModel(model);
        
        
        stage.setTitle("Laboratorio 4");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
