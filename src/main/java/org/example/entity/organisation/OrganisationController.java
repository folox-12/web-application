package org.example.entity.organisation;

import org.example.entity.ResponseFromServer;
import org.example.integration.ServerException;
import org.example.integration.StatusRequest;
import org.example.json.JsonReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class OrganisationController {
 @GetMapping("/getOrganizations")
    public String getOrganizations(@RequestParam(value="region", required = false) String region) {
        ResponseFromServer response = new ResponseFromServer();
            try {
                response.setStatus(StatusRequest.SUCCESS.getTitle());

                if (region == null) {
                    response.setCode(OrganisationService.getOrganisations().toString());
                } else {
                    response.setCode(OrganisationService.getOrganisationsWithFilter(region).toString());
                }

                return JsonReader.convertToJson(response);
            }
            catch( ServerException e) {
                return JsonReader.convertToJson(new ResponseFromServer(StatusRequest.ERROR.getTitle(), e.getMessage()));
            }
     }

 }
