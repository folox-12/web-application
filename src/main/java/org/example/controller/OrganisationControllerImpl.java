package org.example.controller;

import org.example.entity.ResponseFromServer;
import org.example.service.OrganisationService;
import org.example.utils.ServerException;
import org.example.utils.StatusRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class OrganisationControllerImpl implements OrganisationController {
    OrganisationService organisationService;

    OrganisationControllerImpl(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @Override
    @GetMapping("/getOrganizations")
    public ResponseFromServer getOrganizations(@RequestParam(value = "region", required = false) String region) {
        ResponseFromServer response = new ResponseFromServer();

        try {
            response.setStatus(StatusRequest.SUCCESS.getTitle());

            if (region == null) {
                response.setCode(organisationService.getOrganisations().toString());
            } else {
                response.setCode(organisationService.getOrganisationsWithFilter(region).toString());
            }
        } catch (ServerException e) {
            response = new ResponseFromServer(StatusRequest.ERROR.getTitle(), e.getMessage());
        }

        return response;
    }

}
