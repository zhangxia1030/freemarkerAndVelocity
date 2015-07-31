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
		//����Freemarker����ʵ��
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("templates")); 
		
		//��������ģ��
		Map root = new HashMap();

		List list = new ArrayList();
		list.add(new Address("�й�","����"));
		list.add(new Address("�й�","�Ϻ�"));
		list.add(new Address("����","ŦԼ"));
		root.put("list", list);
		
		//����ģ���ļ�
		Template t1 = cfg.getTemplate("excel.ftl");
		
		File file = new File("D://excel.xls");
		FileOutputStream fos = new FileOutputStream(file);
		Writer out = new OutputStreamWriter(fos);
		
		//��ʾ���ɵ�����
		t1.process(root, out);
		out.flush();
		
		
	}
}
