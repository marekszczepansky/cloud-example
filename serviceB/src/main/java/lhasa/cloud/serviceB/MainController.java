package lhasa.cloud.serviceB;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController
{
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@GetMapping("/getB")
	public List<Element> getB(HttpServletRequest request)
	{
		logger.info("\n\n--== called {} ==--\n\n", request.getRequestURI());
		return Collections.singletonList(new Element(request.getRequestURI() + " called", request.getLocalPort()));
	}

}
