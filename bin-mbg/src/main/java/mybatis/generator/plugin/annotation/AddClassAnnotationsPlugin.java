package mybatis.generator.plugin.annotation;

import java.util.List;
import java.util.regex.Pattern;

import lombok.NoArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

/**
 * Mybatis generator plugin to add annotations at the class level.
 */
@NoArgsConstructor
public class AddClassAnnotationsPlugin extends PluginAdapter {
	public static final String ANNOTATION_CLASS = "annotationClass";
	public static final String ANNOTATION_STRING = "annotationString";
	public static final String CLAZZ_PATERN = "clazzPattern";


	private String annotationClass;
	private String annotationString;
	private String clazzPattern;

	@Override
	public boolean validate(List<String> warnings) {
		annotationClass = properties.getProperty(ANNOTATION_CLASS);
		annotationString = properties.getProperty(ANNOTATION_STRING);
		clazzPattern = properties.getProperty(CLAZZ_PATERN);

		String warning = "Property %s not set for plugin %s";
		if (!stringHasValue(annotationClass)) {
			warnings.add(String.format(warning, ANNOTATION_CLASS, this.getClass().getSimpleName()));
		}
		if (!stringHasValue(annotationString)) {
			warnings.add(String.format(warning, ANNOTATION_STRING, this.getClass().getSimpleName()));
		}

		return stringHasValue(annotationClass) && stringHasValue(annotationString);
	}

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// 增加注解过滤
		boolean filter = true;
		if (StringUtils.isNotBlank(clazzPattern)) {
			FullyQualifiedJavaType clazzType = topLevelClass.getType();
			String name = clazzType.getShortName();
            System.out.println(name);
            String[] regs = clazzPattern.split(",");
			for (String reg : regs) {
				if (name.contains(reg)) {
					filter = true;
					break;
				}
			}

		}
		if (filter) {
			topLevelClass.addImportedType(annotationClass);
			topLevelClass.addAnnotation(annotationString);
		}
		return true;
	}

}
