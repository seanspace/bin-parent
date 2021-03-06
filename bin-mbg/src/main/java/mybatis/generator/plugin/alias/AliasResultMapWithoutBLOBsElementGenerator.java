package mybatis.generator.plugin.alias;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

import java.util.List;

import static org.mybatis.generator.internal.util.StringUtility.stringHasValue;

public class AliasResultMapWithoutBLOBsElementGenerator {
	private boolean isSimple = false;
	
	private String resultMapId = "AliasResultMap";
	
	/**
	 * addElements: 在当前的parentElement元素中添加别名ReulstMap列元素. <br/>
	 */
	public void addElements(XmlElement parentElement,IntrospectedTable introspectedTable) {
		XmlElement answer = new XmlElement("resultMap"); //$NON-NLS-1$
		
		introspectedTable.getContext().getCommentGenerator().addComment(answer);
		
		answer.addAttribute(new Attribute("id", resultMapId));
		String returnType = null;
		if (isSimple) {
			returnType = introspectedTable.getBaseRecordType();
		} else {
			if (introspectedTable.getRules().generateBaseRecordClass()) {
				returnType = introspectedTable.getBaseRecordType();
			} else {
				returnType = introspectedTable.getPrimaryKeyType();
			}
		}
		answer.addAttribute(new Attribute("type", //$NON-NLS-1$
				returnType));

		if (introspectedTable.isConstructorBased()) {
			addResultMapConstructorElements(answer,introspectedTable);
		} else {
			addResultMapElements(answer,introspectedTable);
		}
		
		parentElement.addElement(answer);
	}

	/**
	 * addResultMapElements: . <br/>
	 *
	 */
	private void addResultMapElements(XmlElement answer,IntrospectedTable introspectedTable) {
		// 得到当前表的名字
		String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
		for (IntrospectedColumn introspectedColumn : introspectedTable
				.getPrimaryKeyColumns()) {
			XmlElement resultElement = new XmlElement("id"); //$NON-NLS-1$

			resultElement
					.addAttribute(new Attribute(
							"column", (tableName+"_"+MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)).toUpperCase())); //$NON-NLS-1$
			resultElement.addAttribute(new Attribute(
					"property", introspectedColumn.getJavaProperty())); //$NON-NLS-1$
			resultElement.addAttribute(new Attribute("jdbcType", //$NON-NLS-1$
					introspectedColumn.getJdbcTypeName()));

			if (stringHasValue(introspectedColumn.getTypeHandler())) {
				resultElement.addAttribute(new Attribute(
						"typeHandler", introspectedColumn.getTypeHandler())); //$NON-NLS-1$
			}

			answer.addElement(resultElement);
		}

		List<IntrospectedColumn> columns;
		if (isSimple) {
			columns = introspectedTable.getNonPrimaryKeyColumns();
		} else {
			columns = introspectedTable.getBaseColumns();
		}
		for (IntrospectedColumn introspectedColumn : columns) {
			XmlElement resultElement = new XmlElement("result"); //$NON-NLS-1$

			resultElement
					.addAttribute(new Attribute(
							"column", (tableName+"_"+MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)).toUpperCase())); //$NON-NLS-1$
			resultElement.addAttribute(new Attribute(
					"property", introspectedColumn.getJavaProperty())); //$NON-NLS-1$
			resultElement.addAttribute(new Attribute("jdbcType", //$NON-NLS-1$
					introspectedColumn.getJdbcTypeName()));

			if (stringHasValue(introspectedColumn.getTypeHandler())) {
				resultElement.addAttribute(new Attribute(
						"typeHandler", introspectedColumn.getTypeHandler())); //$NON-NLS-1$
			}

			answer.addElement(resultElement);
		}
	}

	/**
	 * addResultMapConstructorElements: . <br/>
	 *
	 */
	private void addResultMapConstructorElements(XmlElement answer,IntrospectedTable introspectedTable) {
		// 得到当前表的名字
		String tableName = introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime();
		
		XmlElement constructor = new XmlElement("constructor"); //$NON-NLS-1$

		for (IntrospectedColumn introspectedColumn : introspectedTable
				.getPrimaryKeyColumns()) {
			XmlElement resultElement = new XmlElement("idArg"); //$NON-NLS-1$

			resultElement
					.addAttribute(new Attribute(
							"column", (tableName+"_"+MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)).toUpperCase())); //$NON-NLS-1$
			resultElement.addAttribute(new Attribute("jdbcType", //$NON-NLS-1$
					introspectedColumn.getJdbcTypeName()));
			resultElement.addAttribute(new Attribute("javaType", //$NON-NLS-1$
					introspectedColumn.getFullyQualifiedJavaType()
							.getFullyQualifiedName()));

			if (stringHasValue(introspectedColumn.getTypeHandler())) {
				resultElement.addAttribute(new Attribute(
						"typeHandler", introspectedColumn.getTypeHandler())); //$NON-NLS-1$
			}

			constructor.addElement(resultElement);
		}

		List<IntrospectedColumn> columns;
		if (isSimple) {
			columns = introspectedTable.getNonPrimaryKeyColumns();
		} else {
			columns = introspectedTable.getBaseColumns();
		}
		for (IntrospectedColumn introspectedColumn : columns) {
			XmlElement resultElement = new XmlElement("arg"); //$NON-NLS-1$

			resultElement
					.addAttribute(new Attribute(
							"column", (tableName+"_"+MyBatis3FormattingUtilities.getRenamedColumnNameForResultMap(introspectedColumn)).toUpperCase())); //$NON-NLS-1$
			resultElement.addAttribute(new Attribute("jdbcType", //$NON-NLS-1$
					introspectedColumn.getJdbcTypeName()));
			resultElement.addAttribute(new Attribute("javaType", //$NON-NLS-1$
					introspectedColumn.getFullyQualifiedJavaType()
							.getFullyQualifiedName()));

			if (stringHasValue(introspectedColumn.getTypeHandler())) {
				resultElement.addAttribute(new Attribute(
						"typeHandler", introspectedColumn.getTypeHandler())); //$NON-NLS-1$
			}

			constructor.addElement(resultElement);
		}
		answer.addElement(constructor);
	}
}
