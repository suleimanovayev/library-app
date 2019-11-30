  
package mate.academy.spring.dto;

import mate.academy.spring.entity.User;
import org.springframework.stereotype.Component;

@Component
public class DtoUtil {

    public User toEntity(UserDto userDto) {
        User newUser = new User();
        newUser.setFirstName(userDto.getFirstName());
        newUser.setLastName(userDto.getLastName());
        newUser.setEmail(userDto.getEmail());
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(userDto.getPassword());
        return newUser;
    }
}
