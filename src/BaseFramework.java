/*
This is the BaseFramework Class which defines objects of the SpeechModule Class and The Input Panel
BaseFramework constructs the answers to the questions send by the InputPanel classes and returns it.
Current Issue : Label text appearing after speech is complete
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaseFramework
{
    String answer;
    BaseFramework()
    {
        /*
        Default Constructor
         */
    }
    public static void main(String args[])throws IOException
    {
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(r);
        Intro intro = new Intro();
        SpeechModule sm = new SpeechModule(); // Creates an object of the SpeechModule Class
        sm.speak("Hello");              // Says Hello
        intro.introduce();                  // Introduces from the intro Class
        sm.speak("Ask Me Anything");
    }

    public String replyToQuestion(String question) // Function to reply to a question generated from the input Panel
    {
        SpeechModule sm = new SpeechModule(); // Creates an object of the SpeechModule Class
        // Question and Answer Design
        if(question.equals("Hello"));
        {
            answer = "Hello";
            sm.speak(answer);

        }
        if(question.equalsIgnoreCase("I love dogs"))
        {
            answer = "I love dogs too!";
            sm.speak(answer);
        }
        return answer;
    }
}
