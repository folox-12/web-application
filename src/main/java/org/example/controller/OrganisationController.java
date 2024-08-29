package org.example.controller;

import org.example.entity.ResponseFromServer;

public interface OrganisationController {
    ResponseFromServer getOrganizations(String region);
}
