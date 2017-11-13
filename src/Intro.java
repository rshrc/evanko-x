/*
This Class creates a sample object of the class SpeechModule and Introduces itself as Mandreck 1.0
 */
public class Intro
{
    Intro()
    {

    }
    void introduce()
    {
        SpeechModule sm = new SpeechModule();
        sm.speak("I an Mandreck!, version 1 point O");
    }
}
