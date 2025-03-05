
public class Main {
    public static void main(String[] args) {

        Hero hero1 = new Hero("batman", 42, "$$$");
        System.out.println(hero1.name);
        System.out.println(hero1.age);
        System.out.println(hero1.power);

        Hero hero2 = new Hero("superman", 35, "flying");
        System.out.println(hero2);

    }
}