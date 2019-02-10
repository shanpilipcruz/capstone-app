package cebucityguide.capstoneproject.classes;

import android.os.AsyncTask;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import static cebucityguide.capstoneproject.HomeActivity.API_KEY;
import static cebucityguide.capstoneproject.HomeActivity.textViewHandler;
import static cebucityguide.capstoneproject.SpeechActivity.SpeechOutput;
import static cebucityguide.capstoneproject.SpeechActivity.mText;
import static cebucityguide.capstoneproject.SpeechActivity.selectedLanguage;

public class SpeechTranslatorProcess extends AsyncTask<Void, Void, Void> {

    String textTranslatorText = mText.getText().toString();

    @Override
    protected Void doInBackground(Void... voids) {
        TranslateOptions options = TranslateOptions.newBuilder()
                .setApiKey(API_KEY)
                .build();

        Translate translate = options.getService();

        final Translation translation =
                translate.translate(textTranslatorText, Translate.TranslateOption.targetLanguage(selectedLanguage));

        textViewHandler.post(new Runnable(){
            @Override
            public void run(){
                if(SpeechOutput != null){
                    SpeechOutput.setText(translation.getTranslatedText());
                }
            }
        });
        return null;
    }
}
