package com.UsersMVC.users.models;


<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
=======
import lombok.Data;
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "users")
@Data
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "roles") //Lombok самостоятельно сгенерирует методы equals() и hashCode() для класса Role
public class User implements UserDetails {

=======
public class User implements UserDetails {
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
<<<<<<< HEAD

    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "firstname")
    private String firstname;

    @NotEmpty(message = "Поле не должно быть пустым")
=======
    @NotEmpty(message = "поле не должны быть пустым")
    @Column(name = "firstname")
    private String firstname;
    @NotEmpty(message = "поле не должны быть пустым")
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
    @Column(name = "lastname")
    private String lastname;

    @Min(value = 0, message = "Поле не может быть пустым")
    @Column(name = "age")
    private int age;
<<<<<<< HEAD

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
=======
    @NotEmpty(message = "Поле не должно быть пустым")
    @Email(message = "Некоректный email")
    @Column(name = "email",unique = true)
    private String email;
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "password")
    private String password;
    @ManyToMany
    @JoinTable(
            name = "users_roles", //таблица связывания ролей и юзеров
            joinColumns = @JoinColumn(name = "user_id"), // значение таблицы users_roles
            inverseJoinColumns = @JoinColumn(name = "role_id")) // значение таблицы users_roles
    @Fetch(FetchMode.JOIN)//для немедленной загрузки связанных сущностей
    private Set<Role> roles;

    public User(String firstname, String lastname, int age, String email, String password, Set<Role> roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }

    public String getPassword() {
        return password;
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
    }

    @Override
    public String getUsername() {
        return email;
    }

<<<<<<< HEAD
=======

>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
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

<<<<<<< HEAD


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
=======
    public void setPassword(String password) {
        this.password = password;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
<<<<<<< HEAD
        return id == user.id &&
               age == user.age &&
               Objects.equals(firstname, user.firstname) &&
               Objects.equals(lastname, user.lastname) &&
               Objects.equals(email, user.email) &&
               Objects.equals(password, user.password) &&
               Objects.equals(roles, user.roles);
=======
        return id == user.id && age == user.age && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(roles, user.roles);
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, age, email, password, roles);
    }
<<<<<<< HEAD
}

=======

    @Override
    public String toString() {
        return
               "firstname='" + firstname + '\'' +
               ", lastname='" + lastname + '\'' +
               ", age=" + age +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               ", roles=" + roles +
               '}';
    }
}
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
