package andres.it.historyDictionary.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import andres.it.dizionario.storico.R;
import andres.it.historyDictionary.ListItems.ListCultureTerms;
import andres.it.historyDictionary.ListItems.ListPolitcTerms;
import andres.it.historyDictionary.ListItems.ListReligiousTerms;
import andres.it.historyDictionary.TypeTerm.CultureTerm;
import andres.it.historyDictionary.TypeTerm.PoliticTerm;
import andres.it.historyDictionary.TypeTerm.ReligiousTerm;

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
                DescriptionActivity.mAdapter.notifyDataSetChanged();
                finish();
            }
        });

    }

    private void saveTerm() {

        String term = myTerm.getText().toString();
        String description = myDescription.getText().toString();

        switch (typeTerm) {

            case "Cultura":
                CultureTerm tempCT = new CultureTerm(term, description);
                ListCultureTerms.cultureTerms.add(tempCT);
                ListCultureTerms.sortList();
                break;

            case "Politica":
                PoliticTerm tempPT = new PoliticTerm(term, description);
                ListPolitcTerms.politicTerms.add(tempPT);
                ListPolitcTerms.sortList();
                break;

            case "Religione":
                ReligiousTerm tempRT = new ReligiousTerm(term, description);
                ListReligiousTerms.religiousTerms.add(tempRT);
                ListReligiousTerms.sortList();
                break;

            default:
                break;
        }

    }


}
