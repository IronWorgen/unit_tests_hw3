package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    private List<User> data = new ArrayList<>();


    public void addUser(User user) {
        if (user.isAuthenticate()) {
            data.add(user);
        } else {
            System.out.println("access denied");
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void logOutIfNotAdmin() {
        data = data.stream().filter((x) -> {
            if (!x.isAdmin()) {
                x.setAuthenticate(false);
                return false;
            } else {
                return true;
            }
        }).toList();
    }


}