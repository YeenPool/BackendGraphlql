package petCRUD.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import petCRUD.entity.UsersT;
import petCRUD.repository.UserRepository;

@Service
@Slf4j
public class UserService {
	@Autowired
    UserRepository userRepository;

    public List<UsersT> findAllUsers(){
        return userRepository.findAll();
    }
    
    public UsersT getUserByCedula(int cedula){
    	
        return userRepository.findById(cedula).orElse(null);
        
    }

    public UsersT saveUser(UsersT user){
        return userRepository.save(user);
    }

    public UsersT updateUser(Integer cedula,String nombres,
    		String apellidos,String direccion,String telefono){
    	
        UsersT userL = userRepository.findById(cedula)
                .orElseThrow(()->new RuntimeException("cedula not exists"));
        userL.setCedula(cedula);
    	userL.setNombres(nombres);
    	userL.setApellidos(apellidos);
    	userL.setDireccion(direccion);
    	userL.setTelefono(telefono);
        return userRepository.save(userL);
    }

    public UsersT deleteUser(Integer cedula){
        UsersT user = userRepository.findById(cedula)
                .orElseThrow(()->new RuntimeException("cedula not exists"));
        userRepository.delete(user);
        return user;
    }

}
