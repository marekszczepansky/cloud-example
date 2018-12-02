package lhasa.cloud.serviceB;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@RestController
//@SuppressWarnings({"ALL"})
public class MainController {

    private static final String SERVICE_A_URL = "http://localhost:9091";
    private static final String SERVICE_C_URL = "http://localhost:9093";
    private RestTemplate restTemplate;

    public MainController(RestTemplateBuilder rtb) {
        restTemplate = rtb.build();
    }

    @GetMapping("/getB")
    public List<Element> getB(HttpServletRequest request) {
        return Collections.singletonList(getElementForRequest(request));
    }

    @GetMapping("/getBC")
    public List<Element> getBC(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_C_URL + "/getC", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    @GetMapping("/getBA")
    public List<Element> getBA(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_A_URL + "/getA", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    @GetMapping("/getBCA")
    public List<Element> getBCA(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_C_URL + "/getCA", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    @GetMapping("/getBAC")
    public List<Element> getBAC(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_A_URL + "/getAC", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    private Element getElementForRequest(HttpServletRequest request) {
        return new Element(String.format("%s called", request.getRequestURI()), request.getLocalPort());
    }
}
