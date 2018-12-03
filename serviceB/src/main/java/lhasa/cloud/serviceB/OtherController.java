/**
 * Copyright © 2018 Lhasa Limited
 * File created: 2018-12-03 by Marek
 * Creator : Marek
 * Version : $$Id$$
 */
package lhasa.cloud.serviceB;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Marek
 * @since 2018-12-03
 */
@RestController
@SuppressWarnings("ALL")
public class OtherController
{
	private static final String SERVICE_A_URL = "http://localhost:9091";
	private static final String SERVICE_C_URL = "http://localhost:9093";

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/getBC")
	public List<Element> getBC(HttpServletRequest request)
	{
		List<Element> result = restTemplate.getForObject(SERVICE_C_URL + "/getC", List.class);
		result.add(0, getElementForRequest(request));
		return result;
	}

	@GetMapping("/getBA")
	public List<Element> getBA(HttpServletRequest request)
	{
		List<Element> result = restTemplate.getForObject(SERVICE_A_URL + "/getA", List.class);
		result.add(0, getElementForRequest(request));
		return result;
	}

	@GetMapping("/getBCA")
	public List<Element> getBCA(HttpServletRequest request)
	{
		List<Element> result = restTemplate.getForObject(SERVICE_C_URL + "/getCA", List.class);
		result.add(0, getElementForRequest(request));
		return result;
	}

	@GetMapping("/getBAC")
	public List<Element> getBAC(HttpServletRequest request)
	{
		List<Element> result = restTemplate.getForObject(SERVICE_A_URL + "/getAC", List.class);
		result.add(0, getElementForRequest(request));
		return result;
	}

	private Element getElementForRequest(HttpServletRequest request)
	{
		return new Element(String.format("%s called", request.getRequestURI()), request.getLocalPort());
	}
}
/* ---------------------------------------------------------------------*
 * This software is the confidential and proprietary
 * information of Lhasa Limited
 * Granary Wharf House, 2 Canal Wharf, Leeds, LS11 5PS
 * ---
 * No part of this confidential information shall be disclosed
 * and it shall be used only in accordance with the terms of a
 * written license agreement entered into by holder of the information
 * with LHASA Ltd.
 * --------------------------------------------------------------------- */