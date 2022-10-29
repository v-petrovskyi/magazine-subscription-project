package com.magazine.project.repositories;

import com.magazine.project.entity.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {
    List<Magazine> getAllByActiveIsTrue();
    Optional<Magazine> findByTitle(String title);
}
