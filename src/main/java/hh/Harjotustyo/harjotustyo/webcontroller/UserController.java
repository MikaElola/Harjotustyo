package hh.Harjotustyo.harjotustyo.webcontroller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.Harjotustyo.harjotustyo.domain.SignupForm;
import hh.Harjotustyo.harjotustyo.domain.UserRepository;
import hh.Harjotustyo.harjotustyo.domain.User;

@Controller
public class UserController {
	@Autowired
	private UserRepository urepo;
	
	@RequestMapping(value = "signup")
	public String addUser(Model model){
		model.addAttribute("sform", new SignupForm());
		return "signup";
	}
	
	@RequestMapping(value="saveuser", method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("sform") SignupForm sform, BindingResult bresult){
		if (!bresult.hasErrors())	{
			if (sform.getPassword().equals(sform.getPasswordCheck())) {
				String pwd = sform.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPwd = bc.encode(pwd);
				
				User newUser = new User();
				newUser.setPasswordHash(hashPwd);
				newUser.setUsername(sform.getUsername());
				newUser.setRole("USER");
				if (urepo.findByUsername(sform.getUsername()) == null){
					urepo.save(newUser);
				}else {
					bresult.rejectValue("username", "err.username", "Username already exists");
					return "signup";
				}
			}
			else {
				bresult.rejectValue("passwordCheck", "err.passCheck", "Password does not match");
				return "signup";
			}
		}
		else {
			return "signup";
		}
		return "redirect:/login";
	}
}
