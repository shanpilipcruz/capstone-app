package cebucityguide.capstoneproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

import java.util.Locale;

import static cebucityguide.capstoneproject.SpeechActivity.textToSpeech;

public class SpeechActivity_Text extends HomeActivity
        implements TextToSpeech.OnInitListener, AdapterView.OnItemSelectedListener {

    public String selectLanguage = "";
    public static String inputtedText;
    private Spinner languageSelector;
    private EditText inputTextTranslator;
    private TextView translatedTextView;
    private ImageButton textTranslatorButton;
    private ImageButton speakTranslationButton;
    private ImageButton speechTranslatorSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.capstone_speech_activity_text_translator, frameLayout);
        setTitle("Text Translator");

        textToSpeech = new TextToSpeech(this, this);
        languageSelector = findViewById(R.id.languageSelector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSelector.setAdapter(adapter);
        languageSelector.setOnItemSelectedListener(this);

        textTranslatorButton = findViewById(R.id.textTranslatorButton);
        textTranslatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputtedText = inputTextTranslator.getText().toString();
                new translationProcess().execute();
            }
        });

        inputTextTranslator = findViewById(R.id.inputTextTranslator);
        translatedTextView = findViewById(R.id.translatedTextView);

        speakTranslationButton = findViewById(R.id.speakTranslationButton);
        speakTranslationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakTextTranslation();
            }
        });

        speechTranslatorSwitcher = findViewById(R.id.speechTranslatorSwitcher);
        speechTranslatorSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpeechActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS){
            int result = textToSpeech.setLanguage(Locale.getDefault());
            if(result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TextToSpeech", "This Language is not Supported");
                speakTranslationButton.setEnabled(false);
            } else {
                speakTranslationButton.setEnabled(true);
            }
        }
    }

    @Override
    protected void onDestroy() {
        if(textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    private void speakTextTranslation(){
        String text = translatedTextView.getText().toString();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            selectLanguage = "en";
            Toast.makeText(this,"The selected Language is english", Toast.LENGTH_SHORT).show();
        } else if (position == 1) {
            selectLanguage = "ceb";
            Toast.makeText(this,"The selected Language is cebuano", Toast.LENGTH_SHORT).show();
        } else if (position == 2) {
            selectLanguage = "tl";
            Toast.makeText(this,"The selected Language is tagalog", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @SuppressLint("StaticFieldLeak")
    public class translationProcess extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            TranslateOptions options = TranslateOptions.newBuilder()
                    .setApiKey(API_KEY)
                    .build();

            Translate translate = options.getService();

            final Translation translation =
                    translate.translate(inputtedText, Translate.TranslateOption.targetLanguage(selectLanguage));

            textViewHandler.post(new Runnable(){
                @Override
                public void run(){
                    if(translatedTextView != null){
                        translatedTextView.setText(translation.getTranslatedText());
                    }
                }
            });
            return null;
        }
    }
}
