import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.animation.PauseTransition;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.net.URL;

public class Song extends Application {
	
    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 0.05, 0.05);
        stage.setScene(scene);
        stage.hide();
        final URL resource = getClass().getResource("Read.mp3");
        Media song = new Media(resource.toString());
        MediaPlayer player = new MediaPlayer(song);
        player.setAutoPlay(true);
        MediaView mediaView = new MediaView(player);
        ((Group)scene.getRoot()).getChildren().add(mediaView);
        
        //Here we create a delay that lasts the length of the song
        PauseTransition delay = new PauseTransition(Duration.seconds(5));
        delay.setOnFinished( event -> stage.close() );
        delay.play();
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}