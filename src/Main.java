import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class Mandy
{
    public void makeNewStage()
    {
        Stage window = new Stage();
        SpeechModule sm = new SpeechModule();
        window.setTitle("Ask Mandy (me)");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label writeHere = new Label("Write Here : ");
        writeHere.setId("write-here");
        GridPane.setConstraints(writeHere, 1, 0);

        TextField query = new TextField();
        query.setPromptText("Write Here");
        GridPane.setConstraints(query, 1, 1);

        Label answer = new Label("");
        answer.setId("answer");
        GridPane.setConstraints(answer, 1, 2);

//        Button button = new Button("Submit");
//        GridPane.setConstraints(button, 1, 3);

        query.setOnAction(e -> {
            String answerToQuestion = query.getText();
            BaseFramework baseFramework = new BaseFramework();
            answerToQuestion = baseFramework.replyToQuestion(answerToQuestion);
            answer.setText(answerToQuestion);
            String answerToQuery = answer.toString().substring((answer.toString()).indexOf('\''));
            sm.speak(answerToQuery);
        });


        grid.getChildren().addAll(writeHere, query, answer);
        Scene scene = new Scene(grid, 500, 500);
        scene.getStylesheets().add("MandreckStyleSheet.css");

        window.setScene(scene);
        window.show();


    }
}

public class Main extends Application
{
    // SQL Database not connected, no actual database login. Only predefined.
    String user = "username";   // Username goes here
    String pw = "password";     // Password goes here
    String checkUser, checkPw;
    public static void main(String args[])
    {
        launch(args);
    }
    public void start(Stage primaryStage)
    {
        primaryStage.setTitle("Mandy");

        BorderPane bp = new BorderPane();
        bp.setPadding(new Insets(10,50,50,50));

        //Adding HBox
        HBox hb = new HBox();
        hb.setPadding(new Insets(20,20,20,30));

        //Adding GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //Implementing Nodes for GridPane
        Label lblUserName = new Label("Username");
        final TextField txtUserName = new TextField();
        Label lblPassword = new Label("Password");
        final PasswordField pf = new PasswordField();
        Button btnLogin = new Button("Login");
        final Label lblMessage = new Label();

        //Adding Nodes to GridPane layout
        gridPane.add(lblUserName, 0, 0);
        gridPane.add(txtUserName, 1, 0);
        gridPane.add(lblPassword, 0, 1);
        gridPane.add(pf, 1, 1);
        gridPane.add(btnLogin, 2, 1);
        gridPane.add(lblMessage, 1, 2);


        //Reflection for gridPane
        Reflection r = new Reflection();
        r.setFraction(0.7f);
        gridPane.setEffect(r);

        //DropShadow effect
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);

        //Adding text and DropShadow effect to it
        Text text = new Text("Mandy");
        text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
        text.setEffect(dropShadow);

        //Adding text to HBox
        hb.getChildren().add(text);

        //Add ID's to Nodes
        bp.setId("bp");
        gridPane.setId("root");
        btnLogin.setId("btnLogin");
        text.setId("text");

        //Action for btnLogin
        btnLogin.setOnAction(e -> {

            checkUser = txtUserName.getText().toString();
            checkPw = pf.getText().toString();
            if(checkUser.equals(user) && checkPw.equals(pw)){
                primaryStage.close();
               Mandy mandy = new Mandy();
               mandy.makeNewStage();
            }
            else{
                lblMessage.setText("You are not Mandy's Friend");
                lblMessage.setTextFill(Color.RED);
            }
            txtUserName.setText("");
            pf.setText("");

        });

        //Add HBox and GridPane layout to BorderPane Layout
        bp.setTop(hb);
        bp.setCenter(gridPane);

        //Adding BorderPane to the scene and loading CSS
        Scene scene = new Scene(bp);
        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.titleProperty().bind(
                scene.widthProperty().asString().
                        concat(" : ").
                        concat(scene.heightProperty().asString()));
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
}
