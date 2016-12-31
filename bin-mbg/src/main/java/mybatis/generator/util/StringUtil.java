package mybatis.generator.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class StringUtil {
	private static Logger logger=LoggerFactory.getLogger(StringUtil.class);
	/**
	 * charCount: 统计一个字符在字符串中出现的次数. <br/>
	 *
	 * @param source
	 * @param target
	 * @return
	 * @since JDK 1.6
	 */
	public static int charCount(String source,char target){
		if(source==null){
			return 0;
		}
		int count=0;
		for(int i=0;i<source.length();i++){
			if(target==source.charAt(i)){
				count++;
			}
		}
		return count;
	}
	/**
	 * isBlank: 判断字符串为空. <br/>
	 *
	 * @param str
	 * @return
	 * @since JDK 1.6
	 */
	public static boolean isBlank(String str){
		if(str==null){
			return true;
		}
		if("".equals(str.trim())){
			return true;
		}
		return false;
	}
	public static boolean isNull(String str){
		if(str==null){
			return true;
		}
		return false;
	}
	public static boolean isNotNull(String str){
		return !isNull(str);
	}
	
	/**
	 * isNotBlank: 判断字符串不为空. <br/>
	 * TODO .<br/>
	 * TODO .<br/>
	 *
	 * @param str
	 * @return
	 * @since JDK 1.6
	 */
	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}
	
	/**
	 * upperFirstChar:  转换字符串的首字母大写. <br/>
	 *
	 * @param   oldString 转换前的字符串
	 * @return  String   转换后的字段串，首字母大写
	 * @since JDK 1.6
	 */
	public static String upperFirstChar(String oldString) {
		logger.debug("UpperCase the first letter of "+ oldString);
		if (isBlank(oldString)) {
			return oldString;
		}
		String target = new StringBuffer()
				.append(oldString.substring(0, 1).toUpperCase())
				.append(oldString.substring(1)).toString();
		return target;
	}
	/**
	 * lowerFirstChar:  转换字符串的首字母小写. <br/>
	 *
	 * @param   oldString 转换前的字符串
	 * @return  String   转换后的字段串，首字母大写
	 * @since JDK 1.6
	 */
	public static String lowerFirstChar(String oldString) {
		logger.debug("LowerCase the first letter of "+ oldString);
		if (isBlank(oldString)) {
			return oldString;
		}
		String target = new StringBuffer()
				.append(oldString.substring(0, 1).toLowerCase())
				.append(oldString.substring(1)).toString();
		return target;
	} 
	
	/**
	 *  随机生成一个字符串
	 * 
	 * @param length
	 * @return
	 */
	public static String getRandomString(int length) {
		if(length <= 0){
			length = 10;
		}
		char[] pattern = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
				'w', 'x', 'y', 'z' };
		StringBuilder result = new StringBuilder();
		int n = pattern.length;
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int rnd = random.nextInt(n);
			result.append(pattern[rnd]);
		}
		return result.toString();
	}
}
