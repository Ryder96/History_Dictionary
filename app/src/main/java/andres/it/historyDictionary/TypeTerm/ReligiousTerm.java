package andres.it.historyDictionary.TypeTerm;

import andres.it.historyDictionary.Interfaces.Term;

/**
 * Created by ryder on 08/12/14.
 */
public class ReligiousTerm implements Term {

    private String name;
    private String description;

    public ReligiousTerm(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
