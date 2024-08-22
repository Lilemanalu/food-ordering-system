package lile_manalu.spring_boot_project.repository;

import lile_manalu.spring_boot_project.entity.AddOnSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddOnSnapshotRepository extends JpaRepository<AddOnSnapshot, String> {
    @Override
    Optional<AddOnSnapshot> findById(String id);

    List<AddOnSnapshot> findByFoodSnapshotId(String snapshotId);
}
