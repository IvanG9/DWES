import java.util.function.Supplier;


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
interface IFuncionalProveedora {
    public String getStr();
}

public class EjemploProveedorApp {
    
    public static Persona personaPorDefecto(){
        return new Persona("nombre", "apellido", "direccion");
    }
    public static void main(String[] args) {
        // Ejemplos expresiones Lambda proveedoras con Interfaces funcionales
        IFuncionalProveedora hola = () -> "Hello!!";
        System.out.println(hola.getStr());

        // Ejemplo expresiones Lambda con Interfaz Supplier<T>
        Supplier<String> holaConSupplier = () -> "Hola Supplier!!";
        System.out.println(holaConSupplier.get());
        Supplier<Persona> supplierPersona=()-> personaPorDefecto();
        Persona p=supplierPersona.get();
        System.out.println(p.getNombre()+ " "+p.getApellido()+ " vive en " + p.getDireccion());
    }
}