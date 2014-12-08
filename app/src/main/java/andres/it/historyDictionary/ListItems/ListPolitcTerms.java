package andres.it.historyDictionary.ListItems;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import andres.it.historyDictionary.TypeTerm.PoliticTerm;


/**
 * Created by ryder on 08/12/14.
 */
public class ListPolitcTerms {

    public static ArrayList<PoliticTerm> politicTerms = new ArrayList<>();

    public static void sortList() {

        Collections.sort(politicTerms, new Comparator<PoliticTerm>() {
            @Override
            public int compare(PoliticTerm politicTerm1, PoliticTerm politicTerm2) {

                return politicTerm1.getName().compareTo(politicTerm2.getName());
            }
        });
    }
}
