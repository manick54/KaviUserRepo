package transaction;

import dto.ReportCategoryDTO;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO {

    @Autowired
    QueryDAO queryDAO;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ReportCategoryDTO getReportCategories(String reportId, String queryName){
        MapSqlParameterSource msps = new MapSqlParameterSource("reportId", reportId);
        List<ReportCategoryDTO> reportCategoryList = namedParameterJdbcTemplate.query(queryDAO.getQuery(queryName).getQuery(), msps, new RowMapper<ReportCategoryDTO>(){
            @Override
            public ReportCategoryDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
                ReportCategoryDTO reportCategoryDTO = new ReportCategoryDTO();
                reportCategoryDTO.setReportCategoryId(rs.getInt("REPORT_CATEGORY_ID"));
                reportCategoryDTO.setCategoryName(rs.getString("CATEGORY_NAME"));
                reportCategoryDTO.setCreatedBy(rs.getString("CREATED_BY"));
                reportCategoryDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                reportCategoryDTO.setLastUpdatedBy(rs.getString("LAST_UPDATED_BY"));
                reportCategoryDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
                return reportCategoryDTO;
            }
        });
        return reportCategoryList!=null? reportCategoryList.get(0):null;
    }
}
