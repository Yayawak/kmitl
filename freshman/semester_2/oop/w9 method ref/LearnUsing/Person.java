package LearnUsing;

public class Person {
    String name;
    Integer age;
    String favoriteDrink;
    int lottoMotto;
    public Person(String name, Integer age, String favoriteDrink, int lottoMotto) {
        this.name = name;
        this.age = age;
        this.favoriteDrink = favoriteDrink;
        this.lottoMotto = lottoMotto;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public String getFavoriteDrink() {
        return favoriteDrink;
    }
    public int getLottoMotto() {
        return lottoMotto;
    }
    public void setLotto(Integer num) {
        lottoMotto = num;
    }
    public String nameAndName() {
        return name + " " + name;
    }
    @Override
    public String toString() {
        return String.format("Person(%s, %d, %s, %d)",
            name, age, favoriteDrink, lottoMotto
        );
    }
}
