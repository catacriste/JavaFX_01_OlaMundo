package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
//Eventos por Interface EventHandler<>
// - para apanhar o evento criado num objeto gr�fico, usa-se o m�todo .setOn..
/* - As a��es escrevem-se no m�todo handle(), da classe EventHandler
 * Duas solu��es para este m�todo:
 * Sol.1 - A classe Main implementa a interface EventHandler <ActionEvent>
 * 		 - Faz-se o  override do m�todo handle() ap�s o m�todo start(), com a��o pretendida
 * 		 - Objeto activa o m�todo setOnAction(this) para apanhar o evento do tipo action com o argumeno this, que informa a 
 * 			a��o est� nesta classe, no m�todo handler()
 * 			m�todo handler na classe Main, como a seguir est� definido
 * */


//Notas Finais : A interface EventHandler<>  � uma interface com m�todos por implmentar que define o
//tipo de a��o nos seus parenteses retos : MouseEvent, KeyboardEvent, ActionEvent
//Interface � uma classe com todos os m�todos abstract
public class Main extends Application implements EventHandler<ActionEvent> {
	Button btn;									//Cria Bot�o null, fora dos m�todos para ser acess�vel a todos
	@Override
	public void start(Stage primaryStage) {
		try {
			btn = new Button("Clica-me");  			//btn � agora um bot�o inicializado
			btn.setOnAction(this);					 //setOnAction Ativa a captura de eventos do tipo click e
													//This Informa que deve procurar o m�todo handler() algures dentro desta classe
			StackPane layout = new StackPane();
			layout.getChildren().add(btn);				 //adiciona o bot�o ao Layout
			Scene scene = new Scene(layout,600,400);	 //Cria a scene com o layout incluido
			
			BorderPane root = new BorderPane();
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == btn){
			System.out.println("Fui Clicado");
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
