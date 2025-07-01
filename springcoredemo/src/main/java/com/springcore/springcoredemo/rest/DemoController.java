package com.springcore.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcore.springcoredemo.common.Coach;

@RestController
public class DemoController {
   private Coach myCoach;
//   private Coach tennisCoach;
   
   @Autowired
   public DemoController(@Qualifier("Om") Coach theCoach)
   {
	   System.out.println("In Constructor: "+ getClass().getSimpleName());
	   myCoach=theCoach;
	  
   }
   
//   @Autowired
//   public void setCoach(@Qualifier("cricketCoach") Coach theCoach)
//   {
//	   myCoach=theCoach;
//   }
   
   @GetMapping("/getWorkOut")
   public String getWorkOut()
   {
	   return myCoach.getDailyWorkOut();
   }
   
//   @GetMapping("/check")
//   public String check()
//   {
//	   return "Checking mycoach==tenniscoach : "+(myCoach==tennisCoach);
//   }
}
