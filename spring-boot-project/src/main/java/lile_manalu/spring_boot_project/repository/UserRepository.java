package lile_manalu.spring_boot_project.repository;

import lile_manalu.spring_boot_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String > {
    @Override
    Optional<User> findById(String id);
}
