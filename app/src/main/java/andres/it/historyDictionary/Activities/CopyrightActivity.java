package andres.it.historyDictionary.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import andres.it.dizionario.storico.R;

public class CopyrightActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copyright);
    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }

}
