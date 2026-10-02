package ir.maktabsharif.model;

import ir.maktabsharif.enums.Role;
import jakarta.persistence.*;
//import lombok.*;

@Entity
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "users")
//@Builder
public class Users extends BaseEntity{
    @Column(unique = true ,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public Users() {
    }

    public Users(String username, String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
