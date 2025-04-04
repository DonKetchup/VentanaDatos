public class Persona {
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String genero;
    String fechaNacimiento;

    public Persona(String nombre,String apellidoPaterno, String apellidoMaterno, String genero, String fechaNacimiento) {
        this.apellidoPaterno = apellidoPaterno;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + nombre + '\'' +
                ", Apellido Paterno='" + apellidoPaterno + '\'' +
                ", Apellido Materno='" + apellidoMaterno + '\'' +
                ", Genero='" + genero + '\'' +
                ", Fecha de Nacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
}