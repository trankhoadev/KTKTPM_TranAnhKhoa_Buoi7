package com.demo.springsecurity.service;

import com.demo.springsecurity.entity.ChuyenBay;

import java.util.List;

public interface ChuyenBayService {
    List<ChuyenBay> findByGaDi(String gaDi);
    List<ChuyenBay> findByGaDen(String gaDen);
    List<ChuyenBay> findByDoDai(int lonHon, int nhoHon);
    List<ChuyenBay> findByGaDiGaDen(String gaDi, String gaDen);
}
