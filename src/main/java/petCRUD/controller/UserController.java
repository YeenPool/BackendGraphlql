package petCRUD.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import petCRUD.entity.UsersT;
import petCRUD.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @QueryMapping
    public List<UsersT> findAllUsers(){
        return userService.findAllUsers();
    }
    
    @MutationMapping
    public UsersT saveUser(@Argument Integer cedula,@Argument String nombres,
    		@Argument String apellidos,@Argument String direccion,
    		@Argument String telefono){
    	UsersT userL= new UsersT();
    	userL.setCedula(cedula);
    	userL.setNombres(nombres);
    	userL.setApellidos(apellidos);
    	userL.setDireccion(direccion);
    	userL.setTelefono(telefono);
        return userService.saveUser(userL);
    }

    @MutationMapping
    public UsersT updateUser(@Argument Integer cedula,@Argument String nombres,
    		@Argument String apellidos,@Argument String direccion,
    		@Argument String telefono ){
   
        return userService.updateUser(cedula,nombres,apellidos,direccion,telefono) ;
    }

    @MutationMapping
    public UsersT deleteUser(@Argument Integer cedula){
        return userService.deleteUser(cedula);
    }
    
    @QueryMapping
    public UsersT getUserByCedula(@Argument Integer cedula){
        return userService.getUserByCedula(cedula);
    }


}

