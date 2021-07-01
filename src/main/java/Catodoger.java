import java.util.Optional;

public class Catodoger {
    interface Cat { default void mrr() {
        System.out.println("mrr");
    }}
    interface Dog {default void gau(){
        System.out.println("GAU!");
    }}

    public static void main(String[] args) {
        // Создаем объект Котопёс и имплеиентируем оба интерфейса
        class Catodog implements Cat, Dog{        }
        // Метод принимает Object поэтому посылаем туда Котопса
        test(new Catodog());
    }
    static void test(Object obj) {
        // Кастим Object к пересеченному типу. Создать переменную такого типа нельзя,
        // но вывести из Optional можно.
        Optional.of( (Cat & Dog) obj)
                .ifPresent(catodog -> {
                    catodog.mrr();
                    catodog.gau();
                });
    }
}
