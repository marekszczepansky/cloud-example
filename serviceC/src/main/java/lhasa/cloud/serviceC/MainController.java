package lhasa.cloud.serviceC;

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
    private static final String SERVICE_B_URL = "http://localhost:9092";
    private RestTemplate restTemplate;

    public MainController(RestTemplateBuilder rtb) {
        restTemplate = rtb.build();
    }

    @GetMapping("/getC")
    public List<Element> getC(HttpServletRequest request) {
        return Collections.singletonList(getElementForRequest(request));
    }

    @GetMapping("/getCB")
    public List<Element> getCB(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_B_URL + "/getB", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    @GetMapping("/getCA")
    public List<Element> getCA(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject( SERVICE_A_URL+ "/getA", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    @GetMapping("/getCBA")
    public List<Element> getCBA(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_B_URL + "/getBA", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    @GetMapping("/getCAB")
    public List<Element> getCAB(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject( SERVICE_A_URL+ "/getAB", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    private Element getElementForRequest(HttpServletRequest request) {
        return new Element(String.format("%s called", request.getRequestURI()), request.getLocalPort());
    }
}
