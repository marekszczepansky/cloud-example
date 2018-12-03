package lhasa.cloud.serviceB;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController
{

	@GetMapping("/getB")
	public List<Element> getB(HttpServletRequest request)
	{
		return Collections.singletonList(new Element(request.getRequestURI() + " called", request.getLocalPort()));
	}

}
