package petCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petCRUD.entity.UsersT;

@Repository
public interface UserRepository extends JpaRepository<UsersT, Integer> {
}
