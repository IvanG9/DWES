import java.util.ArrayList;
import java.util.List;

public class StreamPaisesFilterApp {
    public static void main(String[] args) {
        // A partir de Java 9 tenemos List.of
        List<String> paises = new ArrayList<String>(
            List.of("España","Francia"));
        
        //paises que empiezan por E
        paises.stream().filter(p->p.startsWith("E")).forEach(System.out::println);
    }
}
