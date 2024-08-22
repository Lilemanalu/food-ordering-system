package lile_manalu.spring_boot_project.repository;

import lile_manalu.spring_boot_project.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<Food, String> {
    @Override
    Optional<Food> findById(String id);

    List<Food> findByOutletId(String outletId);
}
