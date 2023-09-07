package MapTesting;

import com.nctech.bookmyshow.dto.UserDTO;
import com.nctech.bookmyshow.entity.UsersEntity;
import com.nctech.bookmyshow.repositories.UserRepository;
import com.nctech.bookmyshow.repositories.impl.UserRepositoryImpl;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    Map<Integer, UserDTO> usersInHashMap = new HashMap<>();
    UserRepository userRepository = new UserRepositoryImpl();

    public void toHashMap(){
        for (UserDTO user: userRepository.get()) {
            usersInHashMap.put(user.getId(), user);
        }
    }
}
