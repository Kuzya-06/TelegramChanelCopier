package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.entity.Securities;

@Repository
public interface SecuritiesRepository extends JpaRepository<Securities, Long> {

}
