package petCRUD.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import petCRUD.entity.Mascota;
import petCRUD.entity.Medicine;
import petCRUD.entity.UsersT;
import petCRUD.repository.MascotaRepository;

@Service
@Slf4j
public class MascotaService {
	@Autowired
    MascotaRepository mascotaRepository;
	    
	public List<Mascota> findAllMascota(){
	    return mascotaRepository.findAll();
	}
	  
    public Mascota saveMascota(Mascota mascota){
        return mascotaRepository.save(mascota);
    }
    
    public Mascota updateMascota(Integer id, String nombre,
    		 String edad, String peso, String raza,
    		 Integer idCliente, Integer idMedicamento){
    	
        Mascota mascotaL = mascotaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
    	UsersT c= new UsersT();
    	Medicine m = new Medicine();
    	mascotaL.setNombre(nombre);
    	mascotaL.setEdad(edad);
    	mascotaL.setId(id);
    	mascotaL.setPeso(peso);
    	mascotaL.setRaza(raza);
    	c.setCedula(idCliente);
    	c.setNombres(mascotaL.getCliente().getNombres());
    	m.setId(idMedicamento);
    	m.setNombre(mascotaL.getMedicamento().getNombre());
    	m.setDescripcion(mascotaL.getMedicamento().getDescripcion());
    	m.setDosis(mascotaL.getMedicamento().getDosis());
    	mascotaL.setCliente(c);
    	
    	mascotaL.setMedicamento(m);
        return mascotaRepository.save(mascotaL);
    }
    
    public Mascota getMascotaById(int id){
        return mascotaRepository.findById(id).orElse(null);   
    }
    
    public Mascota deleteMascota(Integer id){
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
        mascotaRepository.delete(mascota);
        return mascota;
    }
}
