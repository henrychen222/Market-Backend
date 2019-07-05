package com.itlize.marketBackend.controller;


import static org.springframework.http.ResponseEntity.ok;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.jboss.logging.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.marketBackend.Util.JWTProvider;
import com.itlize.marketBackend.Util.exceptions.AuthenticationException;
import com.itlize.marketBackend.Util.exceptions.UserExistsException;
import com.itlize.marketBackend.Util.exceptions.UserNotFoundException;
import com.itlize.marketBackend.domain.AuthenticationRequest;
import com.itlize.marketBackend.domain.Buyer;
import com.itlize.marketBackend.service.BuyerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class BuyerController {
	
//	private static final Logger logger = Logger
//            .getLogger(BuyerController.class);
	
	public BuyerController() {
		System.out.println("BuyerController initialization...");
	}
	
	@Autowired
	private BuyerService buyerService;
	
	@Autowired
	private JWTProvider jwtProvider;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public void addBuyer(@RequestBody Buyer new_buyer) throws Throwable {
//		if (!buyerService.addBuyer(new_buyer)) {
//			System.out.println("User already existed!!! Failed to register...");
//		} else {
//			System.out.println("Successfully register!!!");
//		}
		try {
			buyerService.addBuyer(new_buyer);
			
		} catch(UserExistsException e) {
			throw e;
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public Buyer getBuyer(@RequestBody Buyer user) throws Throwable {
//		
//		Buyer buyer = buyerService.getBuyer(user);
//		
//		if (buyer == null) {
//			System.out.println("Not Found user!!! -> " + user.getUsername());
//			throw new Exception("User Not found!!!");
//		} else if (!buyer.getPassword().equals(user.getPassword())) {
//			System.out.println("Password not match!!!");
//			throw new Exception("Password not match!!!");
//		}
// 
//        return buyer;
//	}
	public ResponseEntity<?> signin(@RequestBody AuthenticationRequest data) throws Exception {

        try {
            String username = data.getUsername();
            buyerService.validation(username, data.getPassword());
            //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            //String token = jwtTokenProvider.createToken(username, this.users.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());
            String token = jwtProvider.createToken(username, new ArrayList<String>());
            
            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
//            throw new BadCredentialsException("Invalid username/password supplied");
        		throw e;
        } catch (Exception e) {
        		throw new Exception();
        }
    }
	
	//test rest controller advice
	@RequestMapping(value="/buyers/{username}", method=RequestMethod.GET)
	public ResponseEntity<?> testEx(@PathVariable("username") String username) {
		System.out.println("test!");
		throw new UserNotFoundException(username);
	}
	
//	@ModelAttribute
//	public void setVaryResponseHeader(HttpServletResponse response) {
//		response.setHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin");
//	    response.setHeader("Access-Control-Allow-Origin", "*");
//	    response.setHeader("crossDomain", "true");
//	}  

}
