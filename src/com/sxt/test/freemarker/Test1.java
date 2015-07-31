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
		// 创建Freemarker配置实例
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File("templates"));

		// 创建数据模型
		Map root = new HashMap();
		root.put("user", "老高");

		// javabean可以自动转化！类似于我们前面学习的EL表达式！
		User u = new User();
		u.setUname("老马");
		root.put("user1", u);
		User u2 = new User("老张", new Address("中国", "北京"));
		root.put("user2", u2);

		// map/list容器
		List list = new ArrayList();
		list.add(new Address("中国", "北京"));
		list.add(new Address("中国", "上海"));
		list.add(new Address("美国", "纽约"));
		root.put("lst", list);

		// 普通标量??
		root.put("num0", 18);
		root.put("b2", true);
		root.put("date1", new Date());
		root.put("random", new Random().nextInt(100));
		root.put("htm2", "<b>粗体</b>");

		// 加载模板文件
		Template t1 = cfg.getTemplate("a.ftl");

		// 显示生成的数据
		Writer out = new OutputStreamWriter(System.out);
		t1.process(root, out);
		out.flush();

	}
}
