package com.sxt.test.freemarker;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class Test2 {
	public static void main(String[] args) throws Exception {
		//创建Freemarker配置实例
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("templates")); 
		
		//创建数据模型
		Map root = new HashMap();

		List list = new ArrayList();
		list.add(new Address("中国","北京"));
		list.add(new Address("中国","上海"));
		list.add(new Address("美国","纽约"));
		root.put("list", list);
		
		//加载模板文件
		Template t1 = cfg.getTemplate("excel.ftl");
		
		File file = new File("D://excel.xls");
		FileOutputStream fos = new FileOutputStream(file);
		Writer out = new OutputStreamWriter(fos);
		
		//显示生成的数据
		t1.process(root, out);
		out.flush();
		
		
	}
}
