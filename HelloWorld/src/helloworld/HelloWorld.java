package helloworld;
 
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class HelloWorld extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        final Button btn = new Button();
        FadeTransition ft = new FadeTransition(Duration.millis(1500), btn);
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        ft.setFromValue(1.0);
        ft.setToValue(0.5);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        
        final DropShadow shadow = new DropShadow();
      //Adding the shadow when the mouse cursor is on
      btn.addEventHandler(MouseEvent.MOUSE_ENTERED, 
          new EventHandler<MouseEvent>() {
              @Override public void handle(MouseEvent e) {
                  btn.setEffect(shadow);
              }
      });
      //Removing the shadow when the mouse cursor is off
      btn.addEventHandler(MouseEvent.MOUSE_EXITED, 
          new EventHandler<MouseEvent>() {
              @Override public void handle(MouseEvent e) {
                  btn.setEffect(null);
              }
      });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}