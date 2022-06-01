package com.eheio.pfa.securityy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

	       //page de login admin
			@GetMapping(value="/admin/login")
			public String login() {
				return "login";
			}

			    
			//page de login etudiant
			@GetMapping(value="/etudiant/loginEtudiant")
				public String loginEtudiant() {
					return "loginEtudiant";
				}
				
			//forbidden
			@GetMapping(value="/403")
			public String accecDenied() {
			return "403";
				}

}
