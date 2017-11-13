/*
The Speech Module Class accesses the freetts library so as to generate the voice of the answer.
Current Issue : Voice is too Robotic
 */
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
public class SpeechModule
{
    private static final String VOICENAME_kevin = "kevin";
    private String text;  // text to be converted to speech

    public void  speak(String text)
    {
        Voice voice;
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(VOICENAME_kevin);
        voice.allocate();
        voice.speak(text);
    }
}
