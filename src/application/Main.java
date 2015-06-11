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
// - para apanhar o evento criado num objeto gráfico, usa-se o método .setOn..
/* - As ações escrevem-se no método handle(), da classe EventHandler
 * Duas soluções para este método:
 * Sol.1 - A classe Main implementa a interface EventHandler <ActionEvent>
 * 		 - Faz-se o  override do método handle() após o método start(), com ação pretendida
 * 		 - Objeto activa o método setOnAction(this) para apanhar o evento do tipo action com o argumeno this, que informa a 
 * 			ação está nesta classe, no método handler()
 * 			método handler na classe Main, como a seguir está definido
 * */


//Notas Finais : A interface EventHandler<>  é uma interface com métodos por implmentar que define o
//tipo de ação nos seus parenteses retos : MouseEvent, KeyboardEvent, ActionEvent
//Interface é uma classe com todos os métodos abstract
public class Main extends Application implements EventHandler<ActionEvent> {
	Button btn;									//Cria Botão null, fora dos métodos para ser acessível a todos
	@Override
	public void start(Stage primaryStage) {
		try {
			btn = new Button("Clica-me");  			//btn é agora um botão inicializado
			btn.setOnAction(this);					 //setOnAction Ativa a captura de eventos do tipo click e
													//This Informa que deve procurar o método handler() algures dentro desta classe
			StackPane layout = new StackPane();
			layout.getChildren().add(btn);				 //adiciona o botão ao Layout
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
