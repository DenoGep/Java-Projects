
public class Main {
    public static void main(String[] args) {

        Human human1 = new Human("Beyza", 22, 44.4);
        Human human2 = new Human("Denizhan", 20, 91.8);

        System.out.println(human2.name);

        human1.eat();
        human2.drink();
    }
}