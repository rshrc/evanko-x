/*
This is the InputPanel class which manages the user input from keyboard and sends the questions from the textfied
to the BaseFramework Class and stores the return value into a String variable and sets the label answer to the
returned data.
Current Issue : Same issue as of the BaseFramework
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class InputPanel extends Application
{
    Stage window;
//    InputPanel()
//    {
//        /*
//         Default Constructor
//         */
//    }
    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        window = primaryStage;
        window.setTitle("Ask Mandreck (me)");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(10);
        grid.setHgap(10);

        Label writeHere = new Label("Write Here : ");
        writeHere.setId("write-here");
        GridPane.setConstraints(writeHere,1,0);

        TextField query = new TextField();
        query.setPromptText("Write Here");
        GridPane.setConstraints(query,1,1);

        Label answer = new Label("");
        answer.setId("answer");
        GridPane.setConstraints(answer,1,2);

        Button button = new Button("Submit");
        GridPane.setConstraints(button,1,3);

        button.setOnAction(e -> {
        String answerToQuestion = query.getText();
        BaseFramework baseFramework = new BaseFramework();
        answerToQuestion = baseFramework.replyToQuestion(answerToQuestion);
        answer.setText(answerToQuestion);
        });


        grid.getChildren().addAll(writeHere,query,answer,button);
        Scene scene = new Scene(grid,500,500);
        scene.getStylesheets().add("MandreckStyleSheet.css");

        window.setScene(scene);
        window.show();

    }
}
