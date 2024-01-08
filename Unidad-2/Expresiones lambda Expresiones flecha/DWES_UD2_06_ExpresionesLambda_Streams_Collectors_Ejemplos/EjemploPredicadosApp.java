import java.util.function.Predicate;

class Persona {
    private String nombre;
    private String apellido;
    private String direccion;

    public Persona(){}

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

    public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}

}

@FunctionalInterface
interface IFuncionalPredicado {
    public Boolean comprobar(int num);
}

public class EjemploPredicadosApp {

    public static void main(String[] args) {
        // Ejemplos expresiones Lambda Predicado con Interfaces Predicado
        IFuncionalPredicado mayorEdad = edad -> edad>=18;
        System.out.println("¿Con 20 años eres mayor de edad? "+
        mayorEdad.comprobar(20));

        // Ejemplo expresiones Lambda con Interfaz Predicate<T>
        Predicate<Integer> mayorEdadConPredicado=edad -> edad>=18;
        System.out.println("¿Con 10 años eres mayor de edad? "+
        mayorEdadConPredicado.test(10));
        System.out.println("¿Con 10 años eres menor de edad? "+
        mayorEdadConPredicado.negate().test(10));
        Persona persona1= new Persona("nom", "apellido", "direccion");
        Predicate<Persona> nombreCorto=p -> p.getNombre().length()<5;
        System.out.println("¿Nombre persona '"+persona1.getNombre()+
        "' es demasiado corto? "+nombreCorto.test(persona1));
    }
}