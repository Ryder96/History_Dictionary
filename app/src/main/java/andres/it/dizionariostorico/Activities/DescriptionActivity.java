package andres.it.dizionariostorico.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import andres.it.dizionario.storico.R;
import andres.it.dizionariostorico.Adapter.DescriptionAdapter;

public class DescriptionActivity extends Activity {

    DescriptionAdapter mAdapter;
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mRecyclerView = (RecyclerView) findViewById(R.id.descriptionCardList);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(llm);

        mAdapter = new DescriptionAdapter();
        mRecyclerView.setAdapter(mAdapter);

    }



}
