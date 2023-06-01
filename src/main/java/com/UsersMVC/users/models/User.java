package com.UsersMVC.users.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "roles") //Lombok самостоятельно сгенерирует методы equals() и hashCode() для класса Role
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "firstname")
    private String firstname;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "lastname")
    private String lastname;

    @Min(value = 0, message = "Поле не может быть пустым")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Email(message = "Некорректный email")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Fetch(FetchMode.JOIN)
    private Set<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", firstname='" + firstname + '\'' +
               ", lastname='" + lastname + '\'' +
               ", age=" + age +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", roles=" + roles.toString() +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
               age == user.age &&
               Objects.equals(firstname, user.firstname) &&
               Objects.equals(lastname, user.lastname) &&
               Objects.equals(email, user.email) &&
               Objects.equals(password, user.password) &&
               Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, age, email, password, roles);
    }
}

