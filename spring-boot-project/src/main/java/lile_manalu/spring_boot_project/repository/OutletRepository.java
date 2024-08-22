package lile_manalu.spring_boot_project.repository;

import lile_manalu.spring_boot_project.entity.Merchant;
import lile_manalu.spring_boot_project.entity.Outlet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OutletRepository extends JpaRepository<Outlet, String> {
    @Override
    Optional<Outlet> findById(String id);

    List<Outlet> findByMerchantId(String merchantId);
}
