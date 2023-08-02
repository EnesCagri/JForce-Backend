package dev.enescagri.jforceapp.service_interface;

import dev.enescagri.jforceapp.dto.UserDTO;
import dev.enescagri.jforceapp.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> getUser(String userName, String password);

    Optional<User> updateUser(Long id, User employeeDetails);

    ResponseEntity<Map<String, Boolean>> deleteUser(Long id);

    Optional<User> loginUser(String userName, String password);

    List<UserDTO> getAllUserDTOs();
    Optional<UserDTO> getUserDTOById(Long id);

}
