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
interface IFuncionalCalculo {
    public double getResultado(int radio);
}

public class EjemploFuncionApp {
    public static void main(String[] args) {
        // Ejemplos expresiones Lambda consumidoras con Interfaces funcionales
        IFuncionalCalculo area = radio -> (double)radio*radio*3.141516;
        System.out.println("Area de un circulo de radio 5= "+
        area.getResultado(5));
        
        // Ejemplos expresiones Lambda con Interfaz Function<T,R>
        Function<Integer, Double> areaConFunction=radio-> radio*radio*3.141516;
        System.out.println("AreaConFunction de un circulo de radio 5= "+
        areaConFunction.apply(5));
        
        Persona persona1=new Persona("nom1", "apellido1", "direccion1");
        Function<Persona,String> nombrePersona= p-> p.getNombre();
        System.out.println("Nombre de la persona= "+ nombrePersona.apply(persona1));   
    }
}





