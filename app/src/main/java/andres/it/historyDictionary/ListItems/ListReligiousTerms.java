package andres.it.historyDictionary.ListItems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import andres.it.historyDictionary.TypeTerm.ReligiousTerm;

/**
 * Created by ryder on 08/12/14.
 */
public class ListReligiousTerms {

    public static ArrayList<ReligiousTerm> religiousTerms = new ArrayList<>();

    public static void sortList() {

        Collections.sort(religiousTerms, new Comparator<ReligiousTerm>() {
            @Override
            public int compare(ReligiousTerm religiousTerm1, ReligiousTerm religiousTerm2) {

                return religiousTerm1.getName().compareTo(religiousTerm2.getName());
            }
        });
    }
}
