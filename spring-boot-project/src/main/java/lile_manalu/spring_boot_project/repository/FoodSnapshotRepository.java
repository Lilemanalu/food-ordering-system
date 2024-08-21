package lile_manalu.spring_boot_project.repository;

import lile_manalu.spring_boot_project.entity.FoodSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FoodSnapshotRepository extends JpaRepository<FoodSnapshot, String> {
    @Override
    Optional<FoodSnapshot> findById(String id);
}
