package com.luizjhonata.productcatalog.service;

import com.luizjhonata.productcatalog.controlleradvice.InvalidPasswordException;
import com.luizjhonata.productcatalog.dto.UserModelDTO;
import com.luizjhonata.productcatalog.models.RoleModel;
import com.luizjhonata.productcatalog.models.UserModel;
import com.luizjhonata.productcatalog.repository.RoleRepository;
import com.luizjhonata.productcatalog.repository.UserModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service @Transactional @Slf4j
public class UserModelService {

    @Autowired
    private UserModelRepository repository;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private Validator validator;

    //Method to verification password pattern
    public boolean passwordVerification(String password) {
        String passwordPattern = "^(?=.*[a-zA-Z])(?=.*[0-9]).{6,15}$";
        if (password.matches(passwordPattern)) {
            return true;
        }
        return false;
    }

    //Method to insert new users
    public UserModelDTO insert(@RequestBody UserModelDTO newUserDTO) throws Exception{
        if (! passwordVerification(newUserDTO.getPassword())){
            throw new InvalidPasswordException("Password must be between 6 to 15 characters and contain 1 number");
        }

        UserModel newUser = new UserModel();
        newUser.setName(newUserDTO.getName());
        newUser.setUsername(newUserDTO.getUsername());
        newUser.setPassword(newUserDTO.getPassword());
        newUser.setRoleModels(newUserDTO.getRoleModels());

        Set<ConstraintViolation<UserModel>> violations = validator.validate(newUser);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserModel> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException("Error occurred: " + sb.toString(), violations);
        }

        newUser.setPassword(new BCryptPasswordEncoder().encode(newUserDTO.getPassword()));
        repository.save(newUser);
        log.info("Saving new user {} to the database", newUser.getName());
        return new UserModelDTO(newUser);
    }

    //Method to list all users
    public List<UserModelDTO> findAll() {
        List<UserModel> listUserModel = repository.findAll();
        log.info("Fetching all users");
        return listUserModel.stream().map(UserModelDTO::new).collect(Collectors.toList());
    }

    //Method to list a user by username
    public List<UserModelDTO> findByUsername(String username) {
        Optional<UserModel> listUserByUsername = repository.findByUsername(username);
        UserModelDTO listUserByUsernameDTO = new UserModelDTO(listUserByUsername);
        log.info("Fetching user {}", username);
        return (List<UserModelDTO>) listUserByUsernameDTO;
    }

    //Method to list a user by id
    public List<UserModelDTO> findById(Integer id) {
        Optional<UserModel> listUserById = repository.findById(id);
        log.info("Fetching user by id", id);
        return listUserById.stream().map(UserModelDTO::new).collect(Collectors.toList());
    }

    //Method to update the username in a user
    public UserModelDTO updateUsername(Integer id, String username) {
        if(repository.existsById(id)) {
            UserModel updateUsernameUser = repository.getReferenceById(id);
            updateUsernameUser.setUsername(username);
            repository.save(updateUsernameUser);
        }
        log.info("Updating username to {}", username);
        return null;
    }

    //Method to update the name in a user
    public UserModelDTO updateName(Integer id, String name) {
        if(repository.existsById(id)) {
            UserModel updateNameUser = repository.getReferenceById(id);
            updateNameUser.setName(name);
            repository.save(updateNameUser);
        }
        log.info("Updating name to {}", name);
        return null;
    }

    //    Method to update a user's password
    public UserModelDTO updatePassword(Integer id, String password) throws Exception{
        if(repository.existsById(id) && passwordVerification(password)){
            UserModel updatePasswordUser = repository.getReferenceById(id);
            updatePasswordUser.setPassword(new BCryptPasswordEncoder().encode(password));
            repository.save(updatePasswordUser);
        }
        else {
            throw new InvalidPasswordException("Password must be between 6 to 15 characters and contain 1 number");
        }
        log.info("Updating password");
        return null;
    }

    //Method to update data in a user
    public UserModelDTO updateUser(@RequestBody UserModelDTO userModelUpdate) {
        if(repository.existsById(userModelUpdate.getId())) {
            UserModel updateUser = repository.getReferenceById(userModelUpdate.getId());
            updateUser.setName(userModelUpdate.getName());
            updateUser.setUsername(userModelUpdate.getUsername());
            updateUser.setPassword(new BCryptPasswordEncoder().encode(userModelUpdate.getPassword()));
            updateUser.setRoleModels(userModelUpdate.getRoleModels());
            repository.save(updateUser);
        }
        log.info("Updating all data in user {}", userModelUpdate.getUsername());
        return userModelUpdate;
    }
    //Method to delete a user
    public void deleteById(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
        log.info("Deleting user id {}", id);
    }

    public RoleModel saveRole(RoleModel role) {
        log.info("Saving new role {} to the database", role.getRoleName());
        return roleRepo.save(role);
    }

//    public void addRoleToUser(String username, String roleName) {
//        log.info("SAdding role {} to user {}", roleName, username);
//        Optional<UserModel> user = repository.findByUsername(username);
//        RoleModel role = roleRepo.findByRoleName(roleName);
//        if (user.isPresent()) {
//            user.get().add
//            user.getRoleModels().add(role);
//        }
//    }

}