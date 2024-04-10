package petCRUD.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petCRUD.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

}
