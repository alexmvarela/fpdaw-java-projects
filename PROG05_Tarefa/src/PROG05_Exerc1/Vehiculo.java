package PROG05_Exerc1;

import java.time.LocalDate;

/**
 * Clase que representa un vehículo.
 * Esta clase almacena información sobre un vehículo, como su marca, matrícula,
 * kilómetros, fecha de matriculación, descripción, precio y propietario.
 * Además, proporciona métodos para acceder y modificar estos datos, 
 * así como para calcular la antigüedad del vehículo. 
 * 
 * @author Alex Martínez
 */
public class Vehiculo {
    // Atributos
    private String marca;
    private String matricula;
    private int kilometros;
    private LocalDate fechaMatriculacion;
    private String descripcion;
    private double precio;
    private String nombrePropietario;
    private String dniPropietario;
    
    // Constructor
    public Vehiculo(String marca, String matricula, int kilometros,
                    LocalDate fechaMatriculacion, String descripcion, double precio,
                    String nombrePropietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.kilometros = kilometros;
        this.fechaMatriculacion = fechaMatriculacion;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }
    
    // Métodos getters y setters
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public int getKilometros() {
        return kilometros;
    }
    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }
    
    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }
    public void setFechaMatriculacion(LocalDate fechaMatriculacion) {
        this.fechaMatriculacion = fechaMatriculacion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public String getNombrePropietario() {
        return nombrePropietario;
    }
    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }
    
    public String getDniPropietario() {
        return dniPropietario;
    }
    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }
    
    /**
     * Método para calcular el número de años del vehículo.
     * @return número de años desde la fecha de matriculación.
     */
    public int getAnios() {
        LocalDate fechaActual = LocalDate.now();
        int anios = fechaMatriculacion.until(fechaActual).getYears();
        return anios;
    }
}
