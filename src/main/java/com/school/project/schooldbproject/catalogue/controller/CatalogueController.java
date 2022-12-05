package com.school.project.schooldbproject.catalogue.controller;

import com.school.project.schooldbproject.catalogue.dto.CreateCatalogueDto;
import com.school.project.schooldbproject.catalogue.entity.Catalogue;
import com.school.project.schooldbproject.catalogue.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CatalogueController {
    private final CatalogueService catalogueService;

    @Autowired
    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @PostMapping("catalogue")
    @ResponseBody
    public Catalogue createCatalogue(@Valid @RequestBody CreateCatalogueDto createCatalogueDto) {
        return catalogueService.createCatalogue(createCatalogueDto);
    }

    // http://www.myserver.com/api/v1/catalogue?product-name=소라빵
    @GetMapping("catalogue")
    @ResponseBody
    public Catalogue findByCatalogueName(@Valid @RequestParam(name = "product-name") String name) {
        return catalogueService.findCatalogueByName(name);
    }
}
