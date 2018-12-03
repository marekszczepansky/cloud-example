package lhasa.cloud.serviceC;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController
{

	@GetMapping("/getC")
	public List<Element> getC(HttpServletRequest request)
	{
		return Collections.singletonList(new Element(request.getRequestURI() + " called", request.getLocalPort()));
	}

}
