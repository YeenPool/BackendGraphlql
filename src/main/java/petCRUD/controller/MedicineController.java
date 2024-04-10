package petCRUD.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import petCRUD.entity.Medicine;
import petCRUD.service.MedicineService;

@Controller
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @QueryMapping
    public List<Medicine> findAllMedicine(){
        return medicineService.findAllMedicine();
    }
    
    @MutationMapping
    public Medicine saveMedicine(@Argument String nombre,
    		@Argument String descripcion,@Argument String dosis){
    	Medicine medicine= new Medicine();
    	medicine.setNombre(nombre);
    	medicine.setDescripcion(descripcion);
    	medicine.setDosis(dosis);
        return medicineService.saveMedicine(medicine);
    }

    @MutationMapping
    public Medicine updateMedicine(@Argument int id,@Argument String nombre,
    		@Argument String descripcion,@Argument String dosis ){
   
        return medicineService.updateMedicine(id,nombre,descripcion,dosis) ;
    }

    @MutationMapping
    public Medicine deleteMedicine(@Argument Integer id){
        return medicineService.deleteMedicine(id);
    }
    
    @QueryMapping
    public Medicine getMedicineById(@Argument String nombre){
        return medicineService.getUserByMedicine(nombre);
    }


}

