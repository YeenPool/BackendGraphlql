package petCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import petCRUD.entity.Medicine;
import petCRUD.repository.MedicineRepository;

@Service
@Slf4j
public class MedicineService {
	@Autowired
    MedicineRepository medicineRepository;

    public List<Medicine> findAllMedicine(){
        return medicineRepository.findAll();
    }
    
    public Medicine getUserByMedicine(String nombre){
    	 Optional<Medicine> medicineOptional = medicineRepository.findOneByNombre(nombre);
         return medicineOptional.orElse(null);
    }

    public Medicine saveMedicine(Medicine medicine){
        return medicineRepository.save(medicine);
    }

    public Medicine updateMedicine(Integer id,String nombre,String descripcion,String dosis){
    	
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(()->new RuntimeException("id not exists"));
       medicine.setId(id);
       medicine.setNombre(nombre);
       medicine.setDescripcion(descripcion);
       medicine.setDosis(dosis);
        return medicineRepository.save(medicine);
    }

    public Medicine deleteMedicine(Integer id){
        Medicine medicine = medicineRepository.findById(id)
                .orElseThrow(()->new RuntimeException("cedula not exists"));
        medicineRepository.delete(medicine);
        return medicine;
    }

}
