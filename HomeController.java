package com.niit.ShoppingCart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingCart.DAO.LoginDAO;
import com.niit.ShoppingCart.DAO.SupplierDAO;
import com.niit.ShoppingCart.DAO.UserDetailsDAO;
import com.niit.ShoppingCart.model.Supplier;
import com.niit.ShoppingCart.model.UserDetails;
import com.niit.ShoppingCart.model.Login;


@Controller
public class HomeController 
{
	@Autowired
	private UserDetailsDAO ud;
	@Autowired
	private LoginDAO ld;
	@Autowired
	private SupplierDAO sd;
	@RequestMapping("/")
	public ModelAndView Home()
	{
		ModelAndView m1=new ModelAndView("Home");
		return m1;
	}
	@RequestMapping("home")
	public ModelAndView home()
	{
		ModelAndView m1=new ModelAndView("Home");
		return m1;
	}
	@RequestMapping("UserHome")
	public ModelAndView home1()
	{
		ModelAndView m1=new ModelAndView("Home");
		return m1;
	}
	
	@RequestMapping("Register")
	public ModelAndView register()
	{
		ModelAndView m1=new ModelAndView("Register");
		return m1;
	}
	@RequestMapping("RegisterUK")
	public ModelAndView register1()
	{
		ModelAndView m1=new ModelAndView("RegisterUK");
		return m1;
	}
		
		@RequestMapping("Contact us")
		public ModelAndView contact()
		{
			ModelAndView m1=new ModelAndView("Contact us");
			return m1;
	}
	@RequestMapping("Admin")
	public ModelAndView admin()
	{
		ModelAndView m1=new ModelAndView("Admin");
		return m1;
	}
	@RequestMapping("Login")
	public ModelAndView Login()
	{
		ModelAndView m1=new ModelAndView("Login");
		return m1;
	}
	@RequestMapping("LoginUK")
	public ModelAndView Login1()
	{
		ModelAndView m1=new ModelAndView("LoginUK");
		return m1;
	}
	@ModelAttribute("UserDetails")
	public UserDetails registerUser() {
		return new UserDetails();

	}
	@ModelAttribute("Supplier")
	public Supplier sup() {
		return new Supplier();

	}
	
	@RequestMapping(value = "storeUser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("UserDetails") UserDetails registeruser,BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Errors");
			return "Register";
		}
		System.out.println(registeruser.getUsername());
		ud.save(registeruser);
		Login loginuser = new Login();
		loginuser.setId(registeruser.getId());
		loginuser.setUsername(registeruser.getUsername());
		loginuser.setPassword(registeruser.getPassword());
		loginuser.setStatus(registeruser.isStatus());
		ld.save(loginuser);
		return "Register";
	}

	@ModelAttribute("Login")
    public Login createuser(){
    	return new Login();
    }
    
    @RequestMapping("/checkuser")
    public ModelAndView chackedUser(@Valid @ModelAttribute("Login")Login user,BindingResult result,@RequestParam("userName") String userName,@RequestParam("password")String password) 
    { 
    	System.out.println("UserName is............."+userName);
    	System.out.println("Password is............."+password);
		return null;
    	
    }
    @RequestMapping("addsupplier")
	public ModelAndView display3() {

		ModelAndView mv3 = new ModelAndView("addsupplier");
		return mv3;
	}
    @RequestMapping("storesupplier")
	public String addproduct(HttpServletRequest request, @Valid @ModelAttribute("Supplier") Supplier supplier,
			BindingResult result) {
		if (result.hasErrors()) {
			return "addsupplier";
		}
		sd.save(supplier);
		return "addsupplier";
    }
		
		
		 @RequestMapping("logoutsuccess")
			public ModelAndView logoutpage(){
				ModelAndView mv9 = new ModelAndView("logoutsuccess");
				return mv9;
			}

			@RequestMapping(value = "/Logout", method = RequestMethod.GET)
			public void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
					throws ServletException, IOException {
				HttpSession newsession = request.getSession(false);
				if (newsession != null) 
			    {
			         newsession.invalidate();

			    }
				response.sendRedirect("j_spring_security_logout");	
				}
		


			


	}
   
	
