import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    /*
    Дана строка из нулей и единиц;
    Определить длину максимального интервала из единиц при условии,
    что можно удалить не более одного нуля из исходной строки.
    */
    public static void main(String[] args) {
        //    Генерируем искомую строку
        List<Integer> collect = new Random()
                .ints(100, 0, 2)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(collect);

        //  Определяем переменные:
        int max = 0;    // Максимум
        int count = 0;  // Счёт текущий
        int prev = 0;   // Счёт едениц до одного нуля

        for (int i = 0; i < collect.size(); i++) {
            // Если значение = 1 то увеличиваем счёт
            if (collect.get(i) == 1) {
                count++;
            }
            // Если значение = 0 или последний элемент массива, то
            // Обновляем максимум когда он меньше count + prev
            // Обнуляем count и присваеваем его значение prev
            if (collect.get(i) == 0 || i == collect.size() - 1) {
                if ( (count + prev ) > max) {
                    max = (count + prev);
                }
                prev = count;
                count = 0;
            }
        }
        System.out.println(max);
    }
}
