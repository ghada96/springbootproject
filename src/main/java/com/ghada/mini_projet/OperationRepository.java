package com.ghada.mini_projet;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation,Long> {
    @Query(value = "select o from operation o where o.compte.code=:code order by o.dateOperation desc",nativeQuery = true)
    public Page<Operation> listOperation(@Param("code") String code, Pageable pageable);
}
