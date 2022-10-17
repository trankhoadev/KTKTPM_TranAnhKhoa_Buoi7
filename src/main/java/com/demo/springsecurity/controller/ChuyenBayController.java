package com.demo.springsecurity.controller;

import com.demo.springsecurity.entity.ChuyenBay;
import com.demo.springsecurity.service.ChuyenBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chuyen-bay")
public class ChuyenBayController {
    @Autowired
    ChuyenBayService chuyenBayService;

    @GetMapping("/ga-di/{gaDi}")
    public List<ChuyenBay> getChuyenBayByGaDi(@PathVariable(name = "gaDi") String gaDi) {
        return chuyenBayService.findByGaDi(gaDi);
    }

    @GetMapping("/ga-den/{gaDen}")
    public List<ChuyenBay> getChuyenBayByGaDen(@PathVariable(name = "gaDen") String gaDen) {
        return chuyenBayService.findByGaDen(gaDen);
    }

    @GetMapping("/do-dai/{lonHon}/{nhoHon}")
    public List<ChuyenBay> getChuyenBayByDoDai(@PathVariable(name = "lonHon") int lonHon,
                                               @PathVariable(name = "nhoHon") int nhoHon) {
        return chuyenBayService.findByDoDai(lonHon, nhoHon);
    }

    @GetMapping("/ga/{gaDi}/{gaDen}")
    public List<ChuyenBay> getChuyenBayByGaDiGaDen(@PathVariable(name = "gaDi") String gaDi,
                                                   @PathVariable(name = "gaDen") String gaDen) {
        return chuyenBayService.findByGaDiGaDen(gaDi, gaDen);
    }
}
