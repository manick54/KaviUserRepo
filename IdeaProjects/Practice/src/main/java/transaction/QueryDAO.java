package transaction;

import dto.QueryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class QueryDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public QueryDTO getQuery(String queryID) {

        MapSqlParameterSource msps = new MapSqlParameterSource("queryid", queryID);
        String query = "SELECT * FROM USER WHERE QUERY_ID = ? ";
        List<QueryDTO> queryDTOList = namedParameterJdbcTemplate.query(query, msps, new RowMapper<QueryDTO>(){
        @Override
        public QueryDTO mapRow (ResultSet rs, int rowNum) throws SQLException {
            QueryDTO queryDTO = new QueryDTO();
            queryDTO.setQuery(rs.getString("QUERY"));
            queryDTO.setQueryID(rs.getString("QUERY_ID"));
            queryDTO.setQueryName(rs.getString("QUERY_NAME"));
            queryDTO.setCreatedDate(rs.getDate("CREATED_DATE"));
            return queryDTO;
        }
    });
        return queryDTOList !=null ?queryDTOList.get(0):null;
    }

}
