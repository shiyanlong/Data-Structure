package com.mo.arrList;

public class Student {
	private int no;
	private String name;
	private String sex;
	private int age;
	public Student(int no,String name,String sex,int age) {
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public static void main(String[] args) throws Exception {
		SeqList seqList = new SeqList(100);
		Student s1 = new Student(200001,"张三","男",20);
		Student s2 = new Student(200002,"李四","男",21);
		Student s3 = new Student(200003,"王五","女",22);
		seqList.insert(0, s1);
		seqList.insert(1, s2);
		seqList.insert(2, s3);
		for (int i = 0; i < seqList.size(); i++) {
			Student s = (Student)seqList.getData(i);
			System.out.println(s.getNo() + s.getName() + s.getSex() + s.getAge());
		}
	}
}
