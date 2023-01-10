package controllers;

import dto.ReportCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getReportCategories", method = RequestMethod.GET, produces = "application/json")
        public ReportCategoryDTO getReportCategories(@PathVariable String reportId){
            return userService.getReportCategories(reportId);
        }
    }