package com.demo.springsecurity.repository;

import com.demo.springsecurity.entity.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChuyenBayRepository extends JpaRepository<ChuyenBay, String> {
    List<ChuyenBay> findByGaDi(String gaDi);
    List<ChuyenBay> findByGaDen(String gaDen);
    @Query(value = "select * from chuyenbay c where c.doDai >= ?1 and c.doDai <= ?2", nativeQuery = true)
    List<ChuyenBay> findByDoDai(int lonHon, int nhoHon);
    @Query(value = "select * from chuyenbay c where c.gaDi = ?1 and c.gaDen = ?2", nativeQuery = true)
    List<ChuyenBay> findByGaDiGaDen(String gaDi, String gaDen);
}
