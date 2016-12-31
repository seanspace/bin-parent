package mybatis.generator.plugin.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.util.Calendar;

@MappedJdbcTypes({JdbcType.TIMESTAMP,JdbcType.TIME,JdbcType.DATE})
@MappedTypes(Calendar.class)
public class CalendarTypeHandler  extends BaseTypeHandler<Calendar> {

	/**
	 * setNonNullParameter:. <br/>
	 *
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			Calendar parameter, JdbcType jdbcType) throws SQLException {
		ps.setTimestamp(i, new Timestamp(parameter.getTimeInMillis()));
	}

	/**
	 * getNullableResult:. <br/>
	 *
	 */
	@Override
	public Calendar getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		Timestamp sqlTimestamp = rs.getTimestamp(columnName);
	    if (sqlTimestamp != null) {
	    	Calendar cal = Calendar.getInstance();
	    	cal.setTimeInMillis(sqlTimestamp.getTime());
	    	return cal;
	    }
	    return null;
	}

	/**
	 * getNullableResult:. <br/>
	 *
	 */
	@Override
	public Calendar getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		Timestamp sqlTimestamp = rs.getTimestamp(columnIndex);
	    if (sqlTimestamp != null) {
	    	Calendar cal = Calendar.getInstance();
	    	cal.setTimeInMillis(sqlTimestamp.getTime());
	    	return cal;
	    }
	    return null;
	}

	/**
	 * getNullableResult:. <br/>
	 *
	 */
	@Override
	public Calendar getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		Timestamp sqlTimestamp = cs.getTimestamp(columnIndex);
	    if (sqlTimestamp != null) {
	    	Calendar cal = Calendar.getInstance();
	    	cal.setTimeInMillis(sqlTimestamp.getTime());
	    	return cal;
	    }
	    return null;
	}
}
