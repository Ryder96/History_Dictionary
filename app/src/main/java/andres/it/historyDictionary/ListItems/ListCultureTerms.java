package andres.it.historyDictionary.ListItems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import andres.it.historyDictionary.TypeTerm.CultureTerm;
import andres.it.historyDictionary.TypeTerm.PoliticTerm;
import andres.it.historyDictionary.TypeTerm.ReligiousTerm;

/**
 * Created by ryder on 08/12/14.
 */
public class ListCultureTerms {

    public static ArrayList<CultureTerm> cultureTerms = new ArrayList<>();

    public static void sortList() {

        Collections.sort(cultureTerms, new Comparator<CultureTerm>() {
            @Override
            public int compare(CultureTerm cultureTerm1, CultureTerm cultureTerm2) {

                return cultureTerm1.getName().compareTo(cultureTerm2.getName());
            }
        });
    }
}
