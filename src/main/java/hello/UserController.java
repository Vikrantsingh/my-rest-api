package hello;

import java.util.ArrayList;
import java.util.List;

import model.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dao.LoginDao;

/**
 * Controller of user crud operations
 */
@RestController
public class UserController {

    private final List<Login> usersList = new ArrayList<Login>();
    @Autowired
    private LoginDao loginDao;

    @RequestMapping(value = "/user/display", method = RequestMethod.GET)
    public List<Login> displayUsers() {
        return usersList;// new Login("viki", "viks", "admin");
    }

    @RequestMapping(value = "/user/delete/{username}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String username) {
        int index = getindex(username);
        if (index != -1) {
            usersList.remove(index);
        }
    }

    private int getindex(String username) {
        int index = -1;
        int i = 0;
        for (Login user : usersList) {
            if (username.equals(user.getUsername())) {
                index = i;
            }
            i++;
        }
        return index;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public void updateUser(@RequestBody Login user) {
        int index = getindex(user.getUsername());
        if (index != -1) {
            usersList.add(index, user);
        }
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.PUT)
    public void createUser(@RequestBody Login user) {
        usersList.add(user);
        loginDao.saveLogin(user);
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    public Login searchUser(@RequestParam(value = "username") String username) {
        int index = getindex(username);
        if (index != -1) {
            return usersList.get(0);
        }
        return null;
    }
}