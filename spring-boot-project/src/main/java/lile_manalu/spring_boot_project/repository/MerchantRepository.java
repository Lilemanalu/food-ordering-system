package lile_manalu.spring_boot_project.repository;

import lile_manalu.spring_boot_project.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, String> {
    @Override
    Optional<Merchant> findById(String id);
}
