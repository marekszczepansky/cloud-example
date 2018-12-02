package lhasa.cloud.serviceA;

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

    private static final String SERVICE_B_URL = "http://localhost:9092";
    private static final String SERVICE_C_URL = "http://localhost:9093";
    private RestTemplate restTemplate;

    public MainController(RestTemplateBuilder rtb) {
        restTemplate = rtb.build();
    }

    @GetMapping("/getA")
    public List<Element> getA(HttpServletRequest request) {
        return Collections.singletonList(getElementForRequest(request));
    }

    @GetMapping("/getAB")
    public List<Element> getAB(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_B_URL + "/getB", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    @GetMapping("/getAC")
    public List<Element> getAC(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_C_URL + "/getC", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    @GetMapping("/getABC")
    public List<Element> getABC(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_B_URL + "/getBC", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    @GetMapping("/getACB")
    public List<Element> getACB(HttpServletRequest request){
        List<Element> result = restTemplate.getForObject(SERVICE_C_URL + "/getCB", List.class);
        result.add(0, getElementForRequest(request));
        return result;
    }

    private Element getElementForRequest(HttpServletRequest request) {
        return new Element(String.format("%s called", request.getRequestURI()), request.getLocalPort());
    }
}

