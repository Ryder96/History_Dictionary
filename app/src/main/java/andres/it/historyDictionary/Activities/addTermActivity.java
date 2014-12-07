package andres.it.historyDictionary.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import andres.it.dizionario.storico.R;

public class addTermActivity extends Activity {

    private Button myButton;
    private EditText myTerm;
    private EditText myDescription;
    private String typeTerm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_term);

        typeTerm = getIntent().getStringExtra("IDTerm");

        myButton = (Button) findViewById(R.id.bDone);
        myTerm = (EditText) findViewById(R.id.etNameTerm);
        myDescription = (EditText) findViewById(R.id.etDefinitionOfTerm);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveTerm();
                finish();
            }
        });

    }

    private void saveTerm() {
        switch (typeTerm){
            case "Politc":
                politcTerms.add();
        }

    }


}
