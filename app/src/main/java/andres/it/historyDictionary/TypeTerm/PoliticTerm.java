package andres.it.historyDictionary.TypeTerm;

import andres.it.historyDictionary.Interfaces.Term;

/**
 * Created by ryder on 08/12/14.
 */
public class PoliticTerm implements Term {

    private String name;
    private String description;
    private static int ID;

    public PoliticTerm(String name,String desc){
        this.name = name;
        this.description = desc;
        ++ID;
    }
    
    
    public int getID(){
        return ID;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
