package com.example.capstoneproject.classes;

import android.os.AsyncTask;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import static com.example.capstoneproject.HomeActivity.API_KEY;
import static com.example.capstoneproject.HomeActivity.textViewHandler;
import static com.example.capstoneproject.SpeechActivity.SpeechOutput;
import static com.example.capstoneproject.SpeechActivity.mText;
import static com.example.capstoneproject.SpeechActivity.selectedLanguage;

public class SpeechTranslatorProcess extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... voids) {
        TranslateOptions options = TranslateOptions.newBuilder()
                .setApiKey(API_KEY)
                .build();

        Translate translate = options.getService();

        final Translation translation =
                translate.translate(mText.getText().toString(), Translate.TranslateOption.targetLanguage(selectedLanguage));

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
