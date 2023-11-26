package org.example;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data

public class User {

    private String name;
    private String password;

    private boolean isAuthenticate = false;
    private boolean isAdmin;


    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;

    }

    //3.6.
    public boolean authenticate(String name, String password) {
        isAuthenticate = name.trim().equals(this.name.trim()) && password.trim().equals(this.password.trim());
        return isAuthenticate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isAdmin != user.isAdmin) return false;
        if (!name.equals(user.name)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (isAdmin ? 1 : 0);
        return result;
    }
}