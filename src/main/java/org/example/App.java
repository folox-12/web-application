package org.example;

import org.apache.log4j.Logger;
import org.example.entities.Organisation;
import org.example.json.JsonReader;
import org.example.requestAPi.requestApi;
import org.example.requestAPi.responseFromServer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

public class App {
    private static final String apiUrl = "https://api.spimex.com/otc/lookup-tables/1";
    private static final Logger log = Logger.getLogger(requestApi.class.getName());

    public static void main( String[] args ) {

        final String residentOfRF = "Резидент РФ";
        final int lengthOfInnToFiltering = 2;

        String listOfOrganisations= requestApi.getResponseFromGetRequest(apiUrl);

        responseFromServer<Organisation> response = JsonReader.getDeserializationObjects(
                listOfOrganisations,
                Organisation.class
        );

        Scanner in = new Scanner(System.in);
        System.out.println("Input first two digital in INN: ");

        String INN = in.nextLine();

        INN = INN.length() < lengthOfInnToFiltering ? INN.concat("  ") : INN;

        String finalINN = INN;
        List<Organisation> organisationsWithRussianResidenceAndFilteringINN= response
                .getResponse()
                .stream()
                .filter(el -> el.Residence.equals(residentOfRF))
                .filter(el ->
                        el.INN.length() >= lengthOfInnToFiltering && el.INN
                                .substring(0, lengthOfInnToFiltering)
                                .equals(finalINN.substring(0, lengthOfInnToFiltering)))
                .collect(Collectors.toList());
        log.info(organisationsWithRussianResidenceAndFilteringINN.toString());
    }
}
