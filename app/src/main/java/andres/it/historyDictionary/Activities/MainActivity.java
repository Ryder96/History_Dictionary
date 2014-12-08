package andres.it.historyDictionary.Activities;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import andres.it.dizionario.storico.R;
import andres.it.historyDictionary.Adapter.ImageAdapter;
import andres.it.historyDictionary.ListItems.ListCultureTerms;
import andres.it.historyDictionary.ListItems.ListPolitcTerms;
import andres.it.historyDictionary.ListItems.ListReligiousTerms;
import andres.it.historyDictionary.TypeTerm.CultureTerm;
import andres.it.historyDictionary.TypeTerm.PoliticTerm;
import andres.it.historyDictionary.TypeTerm.ReligiousTerm;


public class MainActivity extends Activity {


    ImageAdapter mAdapter;
    RecyclerView mRecyclerView;

    private final String KEYSP = "DizionarioAndres";
    private final String KEYCL = "Lista termini cultura";
    private final String KEYPL = "Lista termini politica";
    private final String KEYRL = "Lista termini religione";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadPreferences();

        mRecyclerView = (RecyclerView) findViewById(R.id.cardList);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mAdapter = new ImageAdapter(this);
        mRecyclerView.setAdapter(mAdapter);




    }


    private void savePrefereces(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEYSP,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();

        String cultureJson = gson.toJson(ListCultureTerms.cultureTerms);
        String politicJson = gson.toJson(ListPolitcTerms.politicTerms);
        String religiousJson = gson.toJson(ListReligiousTerms.religiousTerms);


        editor.putString(KEYCL,cultureJson);
        editor.putString(KEYPL,politicJson);
        editor.putString(KEYRL,religiousJson);

        editor.commit();
    }

    private void loadPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEYSP, MODE_PRIVATE);

        Gson gson = new Gson();

        Type culturalType = new TypeToken< ArrayList<CultureTerm>>(){}.getType();
        Type politicType = new TypeToken<ArrayList<PoliticTerm>>(){}.getType();
        Type religiousType = new TypeToken<ArrayList<ReligiousTerm>>(){}.getType();

        ListCultureTerms.cultureTerms.clear();

        String cultureJson = sharedPreferences.getString(KEYCL,"");
        String politicJson = sharedPreferences.getString(KEYPL,"");
        String religiousJson = sharedPreferences.getString(KEYRL,"");



        ListCultureTerms.cultureTerms = gson.fromJson(cultureJson,culturalType);
        ListPolitcTerms.politicTerms = gson.fromJson(politicJson,politicType);
        ListReligiousTerms.religiousTerms = gson.fromJson(religiousJson,religiousType);
    }



    @Override
    public void onBackPressed(){
        super.onBackPressed();
        savePrefereces();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        savePrefereces();
    }




}
