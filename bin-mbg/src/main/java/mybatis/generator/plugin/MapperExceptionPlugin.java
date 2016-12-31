package mybatis.generator.plugin;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class MapperExceptionPlugin extends PluginAdapter {
	
	private void addException(Method method,IntrospectedTable introspectedTable){
		String exceptionClassStr = this.getProperties().getProperty("exceptionClass");
		try {
			method.addException(new FullyQualifiedJavaType(exceptionClassStr));
		} catch (Exception e) {
			method.addException(new FullyQualifiedJavaType(RuntimeException.class.getName()));
		}
	};

	/**
	 * validate:. <br/>
	 *
	 */
	@Override
	public boolean validate(List<String> warnings) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * clientGenerated:. <br/>
	 *
     */
	@Override
	public boolean clientGenerated(Interface interfaze,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		List<Method> mothodList = interfaze.getMethods();
		if(mothodList !=null && mothodList.size()>0){
			for(Method m : mothodList){
				// 给没一个接口方法添加异常抛出
				addException(m,introspectedTable);
			}
		}
		return true;
	}
}
