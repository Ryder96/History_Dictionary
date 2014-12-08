package andres.it.historyDictionary.Adapter;

import android.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import andres.it.dizionario.storico.R;
import andres.it.historyDictionary.ListItems.ListCultureTerms;
import andres.it.historyDictionary.ListItems.ListPolitcTerms;
import andres.it.historyDictionary.ListItems.ListReligiousTerms;

/**
 * Created by ryder on 02/12/14.
 */
public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.DescriptionViewHolder> {

    private final String LogAdapter = "LogAdpater";

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
    public void onBindViewHolder(DescriptionViewHolder descriptionViewHolder, int i) {

        switch (termRequested){
            case "Cultura":
                descriptionViewHolder.vTermine.setText(ListCultureTerms.cultureTerms.get(i).getName());
                descriptionViewHolder.vDescription.setText(ListCultureTerms.cultureTerms.get(i).getDescription());
                break;
            case "Politica":
                descriptionViewHolder.vTermine.setText(ListPolitcTerms.politicTerms.get(i).getName());
                descriptionViewHolder.vDescription.setText(ListPolitcTerms.politicTerms.get(i).getDescription());
                break;
            case "Religione":
                descriptionViewHolder.vTermine.setText(ListReligiousTerms.religiousTerms.get(i).getName());
                descriptionViewHolder.vDescription.setText(ListReligiousTerms.religiousTerms.get(i).getDescription());
                break;
            default :
                break;
        }

    }

    @Override
    public int getItemCount() {
        int size = 0;
        switch (termRequested){
            case "Cultura":
                myActionBar.setTitle("Cultura");
                size = ListCultureTerms.cultureTerms.size();
                break;
            case "Politica":

                myActionBar.setTitle("Politica");
                size = ListPolitcTerms.politicTerms.size();
               break;
            case "Religione":

                myActionBar.setTitle("Religione");
                size = ListReligiousTerms.religiousTerms.size();
                break;
            default :
                break;
        }

        return size;
    }


    public class DescriptionViewHolder extends RecyclerView.ViewHolder {

        protected TextView vTermine;
        protected TextView vDescription;

        public DescriptionViewHolder(final View itemView) {
            super(itemView);
            vTermine = (TextView) itemView.findViewById(R.id.tvTermine);
            vDescription = (TextView) itemView.findViewById(R.id.tvDescription);

        }

    }

}
