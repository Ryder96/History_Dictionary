package andres.it.historyDictionary.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import andres.it.dizionario.storico.R;
import andres.it.historyDictionary.Adapter.DescriptionAdapter;

public class DescriptionActivity extends Activity {

    public static DescriptionAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private Button myButton;

    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        title = getIntent().getStringExtra("TypeOfTerm");
        mRecyclerView = (RecyclerView) findViewById(R.id.descriptionCardList);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mAdapter = new DescriptionAdapter(title, getActionBar());
        mRecyclerView.setAdapter(mAdapter);


        myButton = (Button) findViewById(R.id.bAddTerm);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewTerm();
            }
        });


    }

    private void addNewTerm() {
        Intent intent = new Intent(this, addTermActivity.class);
        intent.putExtra("IDTerm", title);
        startActivity(intent);
    }


}
