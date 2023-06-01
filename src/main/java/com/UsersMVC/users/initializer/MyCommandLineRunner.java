package com.UsersMVC.users.initializer;

import com.UsersMVC.users.models.Role;
import com.UsersMVC.users.models.User;
import com.UsersMVC.users.repositories.RoleRepository;
import com.UsersMVC.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class MyCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public MyCommandLineRunner(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() > 0) {
            // Пользователи уже сохранены, пропускаем сохранение
            return;
        }

        Role adminRole = new Role("ROLE_ADMIN");
        Role userRole = new Role("ROLE_USER");

        roleRepository.save(adminRole);
        roleRepository.save(userRole);

<<<<<<< HEAD
        User adminUser = new User();
        adminUser.setFirstname("admin");
        adminUser.setLastname("admin1");
        adminUser.setAge(25);
        adminUser.setEmail("admin@gmail.com");
        adminUser.setPassword("$2a$12$c/GWhaE4h/Hp47iPsMR94.4R5Gtkvz89tEjLms6ZzzOs.OJ3YCtsy");
        adminUser.setRoles(Set.of(adminRole));

        User regularUser = new User();
        regularUser.setFirstname("user");
        regularUser.setLastname("user1");
        regularUser.setAge(25);
        regularUser.setEmail("user@gmail.com");
        regularUser.setPassword("$2a$12$c/GWhaE4h/Hp47iPsMR94.4R5Gtkvz89tEjLms6ZzzOs.OJ3YCtsy");
        regularUser.setRoles(Set.of(userRole));
//password 100
        userRepository.saveAll(List.of(adminUser, regularUser));
    }
}

=======
        userRepository.saveAll(List.of(
                new User("admin", "admin1", 25, "admin@gmail.com","$2a$12$c/GWhaE4h/Hp47iPsMR94.4R5Gtkvz89tEjLms6ZzzOs.OJ3YCtsy", Set.of(adminRole)),
                new User("user", "user1", 25, "user@gmail.com","$2a$12$c/GWhaE4h/Hp47iPsMR94.4R5Gtkvz89tEjLms6ZzzOs.OJ3YCtsy", Set.of(userRole))
                //пароль для аунтификации 100
        ));
    }
}
>>>>>>> 31623b5ce9a71f7899ad090bf2bf5b9f636aed26
