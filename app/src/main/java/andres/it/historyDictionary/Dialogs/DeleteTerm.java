package andres.it.historyDictionary.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import java.util.Locale;

import andres.it.historyDictionary.Activities.DescriptionActivity;
import andres.it.historyDictionary.ListItems.ListCultureTerms;
import andres.it.historyDictionary.ListItems.ListPolitcTerms;
import andres.it.historyDictionary.ListItems.ListReligiousTerms;

/**
 * Created by ryder on 09/12/14.
 */
public class DeleteTerm extends DialogFragment {

    private String typeTerm;
    private String termToDelete;

    private final String LOGDIALOG = "LOG_DELETE";

    public void setTypeTerm(String type){
        this.typeTerm = type;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Vuoi eliminare il termine?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int i = 0;
                        switch (typeTerm) {
                            case "Cultura":
                                for(; i < ListCultureTerms.cultureTerms.size(); i++)
                                    if(termToDelete.compareTo(ListCultureTerms.cultureTerms.get(i).getName()) == 0)
                                        break;
                                ListCultureTerms.cultureTerms.remove(i);
                                break;

                            case "Politica":
                                for(; i < ListPolitcTerms.politicTerms.size(); i++)
                                    if(termToDelete.compareTo(ListPolitcTerms.politicTerms.get(i).getName()) == 0)
                                        break;
                                ListPolitcTerms.politicTerms.remove(i);
                                break;
                            case "Religione":
                                for(; i < ListReligiousTerms.religiousTerms.size(); i++)
                                    if(termToDelete.compareTo(ListReligiousTerms.religiousTerms.get(i).getName()) == 0)
                                        break;
                                ListReligiousTerms.religiousTerms.remove(i);

                                break;
                            default:
                                break;
                        }
                        DescriptionActivity.mAdapter.notifyDataSetChanged();
                    }
                })


                 .setNegativeButton("No", new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int id) {
                         dialog.dismiss();
                     }
                 });
        return builder.create();
    }


    public void setTermToDelete(String termToDelete) {
        this.termToDelete = termToDelete;
    }
}
