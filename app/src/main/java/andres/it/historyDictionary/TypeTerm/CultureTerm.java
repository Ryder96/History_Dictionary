package andres.it.historyDictionary.TypeTerm;

import andres.it.historyDictionary.Interfaces.Term;

/**
 * Created by ryder on 08/12/14.
 */
public class CultureTerm implements Term {
    private static int ID;
    private String name;
    private String description;

    public CultureTerm(String name, String desc) {
        this.name = name;
        this.description = desc;
        ++ID;
    }


    @Override
    public int getID() {
        return ID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
