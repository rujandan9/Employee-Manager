package tech.getarray.employeemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarray.employeemanager.model.Permis;

import java.util.Optional;


public interface PermisReposittory extends JpaRepository<Permis, Long> {
    Optional<Permis> findByName(String name);
}
