import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecorrerListaApp {
    public static void main(String[] args) {
        List<String> paises = new ArrayList<String>();
        paises.add("España"); // ocupa la posición 0
        paises.add("Francia"); // ocupa la posición 1
        paises.add("Portugal"); // ocupa la posición 2
        // MÉTODOS TRADICIONALES (ANTES DEL JDK 1.8)
        // 1º METODO
        for (int i = 0; i < paises.size(); i++) {
            System.out.println(paises.get(i));
        }
        // 2º METODO
        for (String pais : paises) {
            System.out.println(pais);
        }
        // 3º METODO
        // Iterator iter=paises.iterator();
        // No da error pero es mejor:
        Iterator<String> iter = paises.iterator();
        while (iter.hasNext()) {// V si quedan elementos
            System.out.println(iter.next());
            // next() retorna el elemento y apunta al siguiente
        }

        // RECORRER LISTA UTILIZANDO EXPRESIÓN LAMBDA Consumer<T>
        paises.forEach(System.out::println);
    }
}
