public class Substitutes extends Search {
    
    private String[] soySubs = FileReader.toStringArray("soyReplacements.txt");
    private String[] peanutSubs = FileReader.toStringArray("peanutReplacements.txt");
    private String[] vegetarianSubs = FileReader.toStringArray("vegetarianReplacements.txt");
    private String[] kosherSubs = FileReader.toStringArray("kosherReplacements.txt");



    public Substitutes(String filename) {
        super(filename);
    }
    public Substitutes() {}
    
    public String substituteAll() {
        String result = "";
        if (getEnableKosher() && !substituteKosher().equals("No kashrut issues found.")) {
            result += substituteKosher() + " \n";
        }
        if (getEnableVegetarian() && !substituteVegetarian().equals("No vegetarian issues found.")) {
            result += substituteVegetarian() + " \n";
        }
        if (getEnableSoy() && !substituteSoy().equals("No soy allergies found.")) {
            result += substituteSoy() + "\n";
        }
        if (getEnablePeanuts() && !substitutePeanuts().equals("No peanut allergies found.")) {
            result += substitutePeanuts() + " \n";
        }
        return result;
    }
    
    public String substituteKosher() {
        String result = "No kashrut issues found.";
            // checks if any of the kosher issues are present in the words array 
        String[] kosherAllergens = getKosherAllergens();     
        // for (int i = 0, x = 0; i < kosherAllergens.length && x < getWords().length; i++, x++) {
        for (int i = 0; i < kosherAllergens.length; i++) { 
            for (int x = 0; x < getWords().length; x++) {
                if (getWords()[x].equalsIgnoreCase(kosherAllergens[i])) {
                    if (i < kosherSubs.length) {
                        result = "Kashrut issue found: " + kosherAllergens[i] + ". Suggested substitute: " + kosherSubs[i] + ". ";
                    }
                }
            }
        // returns "no kashrut issues found" if no kashrut issues are found
        }
        return result;
    }

    public String substituteVegetarian() {
        String result = "No vegetarian issues found.";
            // checks if any of the vegetarian issues are present in the words array 
        String[] vegetarianAllergens = getVegetarianAllergens();     
        for (int i = 0; i < vegetarianAllergens.length; i++) { 
            for (int x = 0; x < getWords().length; x++) {
                if (getWords()[x].equalsIgnoreCase(vegetarianAllergens[i])) {
                    if (i < vegetarianSubs.length) {
                        result = "Vegetarian issue found: " + vegetarianAllergens[i] + ". Suggested substitute: " + vegetarianSubs[i] + ". ";
                    }
                }
            }
        }
        // returns "no vegetarian issues found" if no vegetarian issues are found
        return result;
    }

    public String substituteSoy() {
        String result = "No soy allergies found.";
            // checks if any of the soy issues are present in the words array 
        String[] soyAllergens = getSoyAllergens();     
        for (int i = 0; i < soyAllergens.length; i++) {
            for (int x = 0; x < getWords().length; x++) {
                if (getWords()[x].equalsIgnoreCase(soyAllergens[i])) {
                    if (i < soySubs.length) {
                        result = "Soy allergy found: " + soyAllergens[i] + ". Suggested substitute: " + soySubs[i] + ". ";
                    }
                }
            }
        // returns "no soy allergies found" if no soy allergies are found
        }
        return result;
    }

    public String substitutePeanuts() {
        String result = "No peanut allergies found.";
            // checks if any of the peanut issues are present in the words array 
        String[] peanutAllergens = getPeanutAllergens();     
        for (int i = 0; i < peanutAllergens.length; i++) {
            for (int x = 0; x < getWords().length; x++) {
                if (getWords()[x].equalsIgnoreCase(peanutAllergens[i])) {
                    if (i < peanutSubs.length) {
                    result = "Peanut allergy found: " + peanutAllergens[i] + ". Suggested substitute: " + peanutSubs[i] + ". ";
                    }
                }
            }
        // returns "no peanut allergies found" if no peanut allergies are found
        }
        return result;
    }

}
