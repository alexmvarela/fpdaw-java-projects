package prog06.ejerc;

import java.time.LocalDate;

/**
 * Clase que representa un vehículo.
 * Contiene información sobre la marca, matrícula, precio, kilómetros, descripción,
 * fecha de matriculación, nombre y dni del propietario.
 * Dispone de métodos (getters) para acceder a los valores de todos los atributos
 * y un método setter para modificar el valor de los kilómetros.
 * 
 * @author alex
 */
public class Vehiculo {
    private String marca;
    private String matricula;
    private double precio;
    private int kms;
    private String descripcion;
    private LocalDate fechaMatriculacion;
    private String nombrePropietario;
    private String dniPropietario;
    
    public Vehiculo(String marca, String matricula, double precio, int kms, String descripcion, LocalDate fechaMatriculacion, String nombrePropietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.precio = precio;
        this.kms = kms;
        this.descripcion = descripcion;
        this.fechaMatriculacion = fechaMatriculacion;
        this.nombrePropietario = nombrePropietario;
        this.dniPropietario = dniPropietario;
    }

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getPrecio() {
        return precio;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFechaMatriculacion() {
        return fechaMatriculacion;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }
}