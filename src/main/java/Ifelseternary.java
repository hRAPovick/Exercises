import org.junit.Test;

public class Ifelseternary {
    @Test
    public void nullPointer() {
        // Будет выведено 1.0 и в дебаггере видно, что o={Double@1185} 1.0
        Object o = true ? 1 : 2.0D;
        System.out.println(o);
        // НО вот так сделать нельзя. Такой код даже не скомпилится.
        // Обертки примитивов друг к другу не кастятся.

        // Integer inta = 1;
        // Double i = (Double) inta;

        // А сами примитивы друг к другу кастятся легко:
        int ir = 2;
        double d = ir;

        // Отсюда следуте следующий инетресный пример:
        Integer i = null;
        Double du = 2.0;
        Object ou = true ? i : d; // NullPointerException!
        System.out.println(o);
    }
}
