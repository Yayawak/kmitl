// package a;
import java.util.ArrayList;

public class Lab3Coder {
    String name;
    int experience;
    ArrayList<String> languages = new ArrayList<>();


    Lab3Coder(String n, int exp) {
        name = n;
        experience = exp;
    }
    Lab3Coder(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(String... ls) {
        // ls_ =
        for (String l : ls)
            languages.add(l);
        // this.languages = languages;
    }

    @Override
    public String toString() {
        String str = String.format("%s(%d)",
            name, experience
        );
        for (String s : languages)
            str += " " + s;

        return str;
    }

    public ArrayList<String> findCommonLanguage(Lab3Coder lc) {
        ArrayList<String> common = new ArrayList<>();
        // System.out.println(languages);
        // System.out.println(lc.getLanguages());
        for (String thisLang : languages) {
            for (String otherLang : lc.getLanguages()) {
                if (thisLang.equals(otherLang))
                {
                    common.add(thisLang);
                }
            }
        }

        if (common.size() == 0)
            common.add("none");
        return common;
    }
}
