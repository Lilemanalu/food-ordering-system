package lile_manalu.spring_boot_project.repository;

import lile_manalu.spring_boot_project.entity.AddOn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddOnRepository extends JpaRepository<AddOn, String> {
    Optional<AddOn> findFirstByFoodIdAndId(String foodId, String id);
}
