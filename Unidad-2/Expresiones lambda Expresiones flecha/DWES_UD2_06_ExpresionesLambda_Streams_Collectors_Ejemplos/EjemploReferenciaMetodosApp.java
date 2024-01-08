import java.util.function.Consumer;
import java.util.function.Function;
class Persona {
    private String nombre;
    private String apellido;
    private String direccion;

    public Persona(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

@FunctionalInterface
interface IFuncionalImpresion {
    public void imprime(String nom);
}

public class EjemploReferenciaMetodosApp {
    public static void main(String[] args) {
    // Ejemplos expresiones Lambda consumidoras con Interfaces funcionales
    IFuncionalImpresion nombre = (str) -> System.out.println(str);
    nombre.imprime("Jose");        
    // Ejemplos expresiones Lambda que hace referencia a métodos
    IFuncionalImpresion nombreReferencia = System.out::println;
    //"Pedro" sera 'nom' y se le pasara al println
    nombreReferencia.imprime("Pedro");        

    // Ejemplo expresiones Lambda con Interfaz Consumer<T>
    Consumer<String> minuscula = (nom) -> nom.toLowerCase();
    minuscula.accept("Jose");
    Consumer<String> minusculaRef = String::toLowerCase;
    //"Pedro" sera la variable 'nom' consumida sobre la que se ejecutará 'toLowerCase()'
    minusculaRef.accept("Pedro");
    // Ejemplo expresiones Lambda con Interfaz Function<T,R>
    Persona persona1=new Persona("nom1", "apellido1", "direccion1");
    Function<Persona,String> nombrePersona= p-> p.getNombre();
    System.out.println("Nombre de la persona= "+
    nombrePersona.apply(persona1));   
    Function<Persona,String> nombrePersonaReferencia= Persona::getNombre;
    //'persona1' será el objeto de tipo 'Persona' sobre el que se le invocará 'getNombre'
    System.out.println("Nombre de la persona= "+
    nombrePersonaReferencia.apply(persona1));   
    }
}
