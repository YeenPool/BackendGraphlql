package petCRUD.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Mascota {
    @Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
    private String nombre;
    private String raza;
    private String edad;
    private String peso;
	
    @ManyToOne
    @JoinColumn( referencedColumnName = "CEDULA")
    private UsersT cliente;

    @ManyToOne
    @JoinColumn( referencedColumnName = "ID")
    private Medicine medicamento;
    
    
 
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEdad() {
        return edad;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getPeso() {
        return peso;
    }

   
    public void setCliente(UsersT cliente) {
        this.cliente = cliente;
    }

    public UsersT getCliente() {
        return cliente;
    }

    public void setMedicamento(Medicine medicamento) {
        this.medicamento = medicamento;
    }

    public Medicine getMedicamento() {
        return medicamento;
    }
	
}
