package com.demo.springsecurity.service;

import com.demo.springsecurity.entity.ChuyenBay;
import com.demo.springsecurity.repository.ChuyenBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService {
    @Autowired
    ChuyenBayRepository chuyenBayRepository;

    @Override
    public List<ChuyenBay> findByGaDi(String gaDi) {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findByGaDi(gaDi);
        return  chuyenBays;
    }

    @Override
    public List<ChuyenBay> findByGaDen(String gaDen) {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findByGaDen(gaDen);
        return  chuyenBays;
    }

    @Override
    public List<ChuyenBay> findByDoDai(int lonHon, int nhoHon) {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findByDoDai(lonHon, nhoHon);
        return  chuyenBays;
    }

    @Override
    public List<ChuyenBay> findByGaDiGaDen(String gaDi, String gaDen) {
        List<ChuyenBay> chuyenBays = chuyenBayRepository.findByGaDiGaDen(gaDi, gaDen);
        return  chuyenBays;
    }
}
