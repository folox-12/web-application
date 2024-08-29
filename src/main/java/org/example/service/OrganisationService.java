package org.example.service;

import org.example.entity.Organisation;
import org.example.utils.ServerException;

import java.util.List;

public interface OrganisationService {
    public List<Organisation> getOrganisationsWithFilter(String region) throws ServerException;

    public List<Organisation> getOrganisations() throws ServerException;
}