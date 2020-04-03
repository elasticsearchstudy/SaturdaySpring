package com.study.seoul.healthcheck;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HealthCheck {
	
	@RequestMapping(value= "/ajax.health", method=RequestMethod.GET)
	public void sendPingRequest(@RequestParam("ip") String ipAddress, HttpServletResponse response) throws IOException {
		
		InetAddress inetchecker = InetAddress.getByName(ipAddress);
		
		if (inetchecker.isReachable(5000)) {
			// System.out.println("Host is reachable");
			response.getWriter().print("Host is reachable \n");
		} else {
			// System.out.println("Sorry ! We can't reach to this host");
			response.getWriter().print("Sorry ! We can't reach to this host \n");
		}
		// System.out.println("Sending Ping Request to " + ipAddress);
		response.getWriter().print("Sending Ping Request to " + ipAddress + "\n");
	}
}
