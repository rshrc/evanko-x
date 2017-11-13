/*
This is the LoginPage class which creates the LoginPage for the user.
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage extends Application
{
    Stage window;
    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)throws Exception
    {
        window = primaryStage;
        window.setTitle("Mandreck 1.0");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label nameLabel = new Label("Username : ");
        nameLabel.setId("bold-label");
       // nameLabel.setStyle("-fx-text-fill: #eBeBeB");
        GridPane.setConstraints(nameLabel,0,0);

        TextField nameInput = new TextField();
        nameInput.setPromptText("Username");
        GridPane.setConstraints(nameInput,1,0);

        Label passLabel = new Label("Password : ");
        //passLabel.setStyle("-fx-text-fill: #eBeBeB");
        passLabel.setId("bold-label");
        GridPane.setConstraints(passLabel,0,1);

        TextField passInput = new TextField();
        passInput.setPromptText("**********");
        GridPane.setConstraints(passInput,1,1);

        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton,1,2);

        Button signUp = new Button("Sign Up!");
        GridPane.setConstraints(signUp,1,3);

        signUp.setOnAction( e-> {
            try {
                StoreLoginInfo info = new StoreLoginInfo();
                String username = nameInput.getText();
                String password = passInput.getText();
                info.storeLoginInfo("\n"+username+"\n");
                info.storeLoginInfo("\n"+password+"\n");
            }
            catch (Exception exp)
            {}
        });

        grid.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,loginButton,signUp);
        Scene scene = new Scene(grid,300,200);
        scene.getStylesheets().add("MandreckStyleSheet.css");


        window.setScene(scene);
        window.show();


    }
}
