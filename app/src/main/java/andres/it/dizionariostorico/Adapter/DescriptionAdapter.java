package andres.it.dizionariostorico.Adapter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import andres.it.dizionario.storico.R;

/**
 * Created by ryder on 02/12/14.
 */
public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.DescriptionViewHolder> {


    private String termRequested;
    private ActionBar myActionBar;
    public DescriptionAdapter(String termRequested, ActionBar actionBar) {
        this.termRequested = termRequested;
        this.myActionBar = actionBar;
    }

    @Override
    public DescriptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.personal_card_layout, viewGroup, false);
        return new DescriptionViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(DescriptionViewHolder imageViewHolder, int i) {

        switch (termRequested){
            case "Cultura":
                myActionBar.setTitle("Cultura");
                break;
            case "Politica":
                myActionBar.setTitle("Politica");
                break;
            case "Religione":
                myActionBar.setTitle("Religione");
                break;
            default :
                break;
        }

    }

    @Override
    public int getItemCount() {
        return 1;
    }


    public class DescriptionViewHolder extends RecyclerView.ViewHolder {

        protected TextView vName;

        public DescriptionViewHolder(final View itemView) {
            super(itemView);
            vName = (TextView) itemView.findViewById(R.id.description);

        }

    }

}
