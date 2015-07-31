package com.sxt.test.freemarker;

import java.io.File;
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

public class Test1 {
	public static void main(String[] args) throws Exception {
		// ����Freemarker����ʵ��
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("templates"));

		// ��������ģ��
		Map root = new HashMap();
		root.put("user", "�ϸ�");

		// javabean�����Զ�ת��������������ǰ��ѧϰ��EL���ʽ��
		User u = new User();
		u.setUname("����");
		root.put("user1", u);
		User u2 = new User("����", new Address("�й�", "����"));
		root.put("user2", u2);

		// map/list����
		List list = new ArrayList();
		list.add(new Address("�й�", "����"));
		list.add(new Address("�й�", "�Ϻ�"));
		list.add(new Address("����", "ŦԼ"));
		root.put("lst", list);

		// ��ͨ����??
		root.put("num0", 18);
		root.put("b2", true);
		root.put("date1", new Date());
		root.put("random", new Random().nextInt(100));
		root.put("htm2", "<b>����</b>");

		// ����ģ���ļ�
		Template t1 = cfg.getTemplate("a.ftl");

		// ��ʾ���ɵ�����
		Writer out = new OutputStreamWriter(System.out);
		t1.process(root, out);
		out.flush();

	}
}
