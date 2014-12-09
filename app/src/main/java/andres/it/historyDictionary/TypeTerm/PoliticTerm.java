package andres.it.historyDictionary.TypeTerm;

import andres.it.historyDictionary.Interfaces.Term;

/**
 * Created by ryder on 08/12/14.
 */
public class PoliticTerm implements Term {

    private String name;
    private String description;

    public PoliticTerm(String name, String desc) {
        this.name = name;
        this.description = desc;

    }


    public int getID() {
        return 0;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
