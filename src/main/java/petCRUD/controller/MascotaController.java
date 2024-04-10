package petCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import petCRUD.entity.Mascota;
import petCRUD.entity.Medicine;
import petCRUD.entity.UsersT;
import petCRUD.service.MascotaService;

@Controller
public class MascotaController {

    @Autowired
    MascotaService mascotaService;

    @QueryMapping
    public List<Mascota> findAllMascota(){
        return mascotaService.findAllMascota();
    }
    
    @MutationMapping
    public Mascota saveMascota(@Argument Integer id,@Argument String nombre,
    		@Argument String edad,@Argument String peso,@Argument String raza,
    		@Argument Integer idCliente,@Argument Integer idMedicamento
    		){
    	Mascota mascota= new Mascota();
    	UsersT c= new UsersT();
    	Medicine m = new Medicine();
    	mascota.setNombre(nombre);
    	mascota.setEdad(edad);
    	mascota.setId(id);
    	mascota.setPeso(peso);
    	mascota.setRaza(raza);
    	c.setCedula(idCliente);
    	m.setId(idMedicamento);
    	mascota.setCliente(c);
    	mascota.setMedicamento(m);
        return mascotaService.saveMascota(mascota);
    }
    
    @MutationMapping
    public Mascota updateMascota(@Argument Integer id,@Argument String nombre,
    		@Argument String edad,@Argument String peso,@Argument String raza,
    		@Argument Integer idCliente,@Argument Integer idMedicamento ){
   
        return mascotaService.updateMascota( id,  nombre,
       		  edad,  peso,  raza,
       		  idCliente,  idMedicamento) ;
    }
    
    @QueryMapping
    public Mascota getMascotaById(@Argument Integer id){
        return mascotaService.getMascotaById(id);
    }
    
    @MutationMapping
    public Mascota deleteMascota(@Argument Integer id){
        return mascotaService.deleteMascota(id);
    }
}
