package service;

import dto.ReportCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import transaction.UserDAO;

@Component
public class UserService {

    @Autowired
    UserDAO userDAO;

    public ReportCategoryDTO getReportCategories(String reportId){
        return userDAO.getReportCategories(reportId, "REPORT_CATEGORY");
    }
}
