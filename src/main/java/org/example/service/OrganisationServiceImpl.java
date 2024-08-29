package org.example.service;

import org.apache.log4j.Logger;
import org.example.entity.ApiResponseFromServer;
import org.example.entity.RequestApi;
import org.example.entity.ResponseFromServer;
import org.example.entity.Organisation;
import org.example.utils.ServerException;
import org.example.utils.StatusRequest;
import org.example.utils.JsonReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    @Value("${api.url}")
    private String API_URL;

    private static final Logger LOG = Logger.getLogger(OrganisationServiceImpl.class.getName());

    @Override
    public List<Organisation> getOrganisations() throws ServerException {
        ResponseFromServer responseFromApi = RequestApi.getResponseFromRequest(API_URL);

        if (responseFromApi.getStatus() == StatusRequest.ERROR.getTitle()) {
            throw new ServerException("Ошибка в получении данных с сервера");
        }

        String listOfOrganisations = responseFromApi.getCode();

        ApiResponseFromServer<Organisation> response = JsonReader.getDeserializationObjects(
                listOfOrganisations,
                Organisation.class
        );

        return response.getResponse();
    }

    @Override
    public List<Organisation> getOrganisationsWithFilter(String region) throws ServerException {
        final int LENGTH_OF_INN_TO_FILTERING = 2;
        List<Organisation> organisationsWithRussianResidenceAndFilteringINN =
                getOrganisations()
                        .stream()
                        .filter(el ->
                                el.INN.length() >= LENGTH_OF_INN_TO_FILTERING && el.INN
                                        .substring(0, LENGTH_OF_INN_TO_FILTERING)
                                        .equals(region.substring(0, LENGTH_OF_INN_TO_FILTERING)))
                        .collect(Collectors.toList());

        organisationsWithRussianResidenceAndFilteringINN.forEach(el -> LOG.info(el.toString()));

        if (organisationsWithRussianResidenceAndFilteringINN.isEmpty()) {
            throw new ServerException(("Регион не найден"));
        }

        return organisationsWithRussianResidenceAndFilteringINN;
    }
}
