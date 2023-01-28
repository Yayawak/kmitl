// package a;
import java.util.ArrayList;

public class Lab2Coder {
    String name;
    int experience;
    ArrayList<String> languages = new ArrayList<>();

    Lab2Coder() {}

    Lab2Coder(String n, int exp) {
        name = n;
        experience = exp;
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

}
