package org.example;

import org.apache.log4j.Logger;
import org.example.entity.Organisation;
import org.example.json.JsonReader;
import org.example.entity.RequestApi;
import org.example.entity.ResponseFromServer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class App {
    private static final String API_URL = "https://api.spimex.com/otc/lookup-tables/1";
    private static final Logger LOG = Logger.getLogger(App.class.getName());

    public static void main( String[] args ) {
        final String RESIDENT_OF_RF = "Резидент РФ";
        final int LENGTH_OF_INN_TO_FILTERING = 2;

        Scanner scanner = new Scanner(System.in);

        String listOfOrganisations= RequestApi.getResponseFromRequest(API_URL);

        ResponseFromServer<Organisation> response = JsonReader.getDeserializationObjects(
                listOfOrganisations,
                Organisation.class
        );

        System.out.println("Input first two digital in INN: ");
        String InnFromInput = scanner.nextLine().concat("  ");

        List<Organisation> organisationsWithRussianResidenceAndFilteringINN= response
                .getResponse()
                .stream()
                .filter(el -> el.Residence.equals(RESIDENT_OF_RF))
                .filter(el ->
                        el.INN.length() >= LENGTH_OF_INN_TO_FILTERING && el.INN
                                .substring(0, LENGTH_OF_INN_TO_FILTERING)
                                .equals(InnFromInput.substring(0, LENGTH_OF_INN_TO_FILTERING)))
                .collect(Collectors.toList());

        organisationsWithRussianResidenceAndFilteringINN.forEach(el -> LOG.info(el.toString()));

    }
}
