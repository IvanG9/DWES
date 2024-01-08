import java.util.ArrayList;
import java.util.List;

public class StreamPaisesAnyMatchApp {
    public static void main(String[] args) {
        // A partir de Java 9 tenemos List.of
        List<String> paises = new ArrayList<String>(
            List.of("España","Portugal","Francia"));
        //Algún país contiene una i?
        System.out.println(paises.stream().anyMatch(p->p.contains("i")));
    }
}
