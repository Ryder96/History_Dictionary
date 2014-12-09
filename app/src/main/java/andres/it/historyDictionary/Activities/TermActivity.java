package andres.it.historyDictionary.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import andres.it.dizionario.storico.R;
import andres.it.historyDictionary.ListItems.ListCultureTerms;
import andres.it.historyDictionary.ListItems.ListPolitcTerms;
import andres.it.historyDictionary.ListItems.ListReligiousTerms;

public class TermActivity extends Activity {

    private EditText mTerm, mDesc;
    private String iTerm,iDesc;
    private ImageButton bDone, bBack;
    private final String  LOGMODIFY = "LOG MODIFY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term);

        iTerm = getIntent().getStringExtra("Term");
        iDesc = getIntent().getStringExtra("Description");

        mTerm = (EditText) findViewById(R.id.etmTerm);
        mDesc = (EditText) findViewById(R.id.etmDesc);

        bDone = (ImageButton) findViewById(R.id.ibDone);
        bBack = (ImageButton) findViewById(R.id.ibBack);

        mTerm.setText(iTerm);
        mDesc.setText(iDesc);

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        bDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modifyTerm();
                finish();
            }


        });



    }

    private void modifyTerm() {

        String typeTerm = getIntent().getStringExtra("Type");
        String newTerm = mTerm.getText().toString();
        String newDesc = mDesc.getText().toString();
        int i = 0;
        switch (typeTerm) {
            case "Cultura":
                for(; i < ListCultureTerms.cultureTerms.size(); i++)
                    if(iTerm.compareTo(ListCultureTerms.cultureTerms.get(i).getName()) == 0)
                        break;
                ListCultureTerms.cultureTerms.get(i).setName(newTerm);
                ListCultureTerms.cultureTerms.get(i).setDescription(newDesc);
                break;

            case "Politica":
                for(; i < ListPolitcTerms.politicTerms.size(); i++)
                    if(iTerm.compareTo(ListPolitcTerms.politicTerms.get(i).getName()) == 0)
                        break;
                ListPolitcTerms.politicTerms.get(i).setName(newTerm);
                ListPolitcTerms.politicTerms.get(i).setDescription(newDesc);
                break;
            case "Religione":
                for(; i < ListReligiousTerms.religiousTerms.size(); i++)
                    if(iTerm.compareTo(ListReligiousTerms.religiousTerms.get(i).getName()) == 0)
                        break;
                ListReligiousTerms.religiousTerms.get(i).setName(newTerm);
                ListReligiousTerms.religiousTerms.get(i).setDescription(newDesc);

                break;
            default:
                break;
        }

        DescriptionActivity.mAdapter.notifyDataSetChanged();

    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();

    }

}
