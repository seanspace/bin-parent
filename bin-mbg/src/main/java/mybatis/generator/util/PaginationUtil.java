package mybatis.generator.util;


public class PaginationUtil {
	
	/**
	 * getPages: 分页显示,根据总记录数,和每页显示的条数取得显示的总页数.  <br/>
	 *
	 * @param total
	 * @param pageSize
	 * @return
	 * @throws Exception
	 * @since JDK 1.6
	 */
	public static int getPages(int total, int pageSize) throws Exception{
		if(pageSize <= 0){
			throw new Exception("分页显示中,每页显示的数量必须大于等于0;pageSize="+pageSize);
		}
		if(total < 0){
			throw new Exception("分页显示中,记录的总数必须大于0;total="+total);
		}
		return  total%pageSize == 0 ? total / pageSize : total/pageSize+ 1;
	}
}
