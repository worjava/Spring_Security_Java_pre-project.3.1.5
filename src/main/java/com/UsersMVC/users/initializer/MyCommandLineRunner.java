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

        userRepository.saveAll(List.of(
                new User("admin", "admin1", 25, "admin@gmail.com","$2a$12$c/GWhaE4h/Hp47iPsMR94.4R5Gtkvz89tEjLms6ZzzOs.OJ3YCtsy", Set.of(adminRole)),
                new User("user", "user1", 25, "user@gmail.com","$2a$12$c/GWhaE4h/Hp47iPsMR94.4R5Gtkvz89tEjLms6ZzzOs.OJ3YCtsy", Set.of(userRole))
                //пароль для аунтификации 100
        ));
    }
}
