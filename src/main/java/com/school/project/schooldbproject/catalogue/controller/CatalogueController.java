package com.school.project.schooldbproject.catalogue.controller;

import com.school.project.schooldbproject.catalogue.dto.CatalogueDto;
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
    public CatalogueDto.Response createCatalogue(@Valid @RequestBody CatalogueDto.CreateDto createCatalogueDto) {
        return catalogueService.createCatalogue(createCatalogueDto);
    }

    @GetMapping("catalogue")
    @ResponseBody
    public CatalogueDto.Response findByCatalogueName(@Valid @RequestParam(name = "product-name") String name) {
        return catalogueService.findCatalogueByName(name);
    }
}
