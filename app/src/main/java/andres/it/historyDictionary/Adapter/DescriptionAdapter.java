package andres.it.historyDictionary.Adapter;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import andres.it.dizionario.storico.R;
import andres.it.historyDictionary.Activities.TermActivity;
import andres.it.historyDictionary.Dialogs.DeleteTerm;
import andres.it.historyDictionary.ListItems.ListCultureTerms;
import andres.it.historyDictionary.ListItems.ListPolitcTerms;
import andres.it.historyDictionary.ListItems.ListReligiousTerms;

/**
 * Created by ryder on 02/12/14.
 */
public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.DescriptionViewHolder> {


    private String termRequested;
    private ActionBar myActionBar;
    protected Context context;

    public DescriptionAdapter(String termRequested, ActionBar actionBar,Context context) {
        this.termRequested = termRequested;
        this.myActionBar = actionBar;
        this.context = context;
    }

    @Override
    public DescriptionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.personal_card_layout, viewGroup, false);
        return new DescriptionViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(DescriptionViewHolder descriptionViewHolder, int i) {

        switch (termRequested) {
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
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        int size = 0;
        switch (termRequested) {
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
            default:
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, TermActivity.class);
                    intent.putExtra("Term",vTermine.getText().toString());
                    intent.putExtra("Description",vDescription.getText().toString());
                    intent.putExtra("Type",termRequested);
                    context.startActivity(intent);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    DeleteTerm mDialog = new DeleteTerm();
                    Activity a = (Activity) context;
                    mDialog.setTypeTerm(termRequested);
                    mDialog.setTermToDelete(vTermine.getText().toString());
                    mDialog.show(a.getFragmentManager(),"CIAO");
                    return false;
                }
            });

        }

    }

}
