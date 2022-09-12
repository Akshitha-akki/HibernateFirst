package com.hibernate.hibernatefirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        
       Student std1 = new Student();
        std1.setName("Deepthi");
        std1.setCity("Bhopal");
      /*  Student std2 = new Student();
        std2.setId(6);
        std2.setName("Rama");
        std2.setCity("Bangloor");
        Student std21 = new Student();
        std21.setId(7);
        std21.setName("Jaya");
        std21.setCity("Bangloor");
        Student std211 = new Student();
        std211.setId(8);
        std211.setName("Ashritha");
        std211.setCity("Bangloor");
        
        System.out.println("Data has been inserted!");
        
        List<Student> list = new ArrayList<Student>();
        //list.add(std1);
        list.add(std2);
        list.add(std21);
        //list.add(std211);
     //   s.beginTransaction();/*
       s.save(std1);
        s.save(std2);
        s.save(std21);
       // s.save(std211); 
        
       /* Query query = s.createQuery("from Student");
        List<Student> arr = query.list();
        for(Student e : arr)
        {
        	System.out.println("Id : "+e.getId()+"\nName : "+e.getName()+"\nCity : "+e.getCity());
        }   */
        //Using of name
       /* Query query = s.getNamedQuery("findStudentId");
        query.setInteger("Id1", 2);
        List<Student> list = query.list();
        for(int i=0;i<list.size();i++)
        {
        	System.out.println("Id :"+list.get(i).getId() +"\nName : "+list.get(i).getName());
        }
        if(!list.isEmpty())
        {
        	Student std = (Student) list.get(0);
        	System.out.println("-->"+std);
        }
        System.out.println();
        
        Query query1 = s.getNamedQuery("findStudentName");
        query1.setParameter("name1","Deekshith");
        List<Student> list1 = query1.list();
        for(int i=0;i<list1.size();i++)
        {
        	System.out.println("Name : "+list1.get(i).getName());
        }
        if(!list1.isEmpty())
        {
        	Student std = (Student) list1.get(0);
        	System.out.println("**"+std);
        }
        
        Query query2 = s.getNamedQuery("findStudentNameByM");
        //query2.setParameter("name1","De");
        List<Student> list2 = query2.list();
        for(int i=0;i<list2.size();i++)
        {
        	System.out.println("Name : "+list2.get(i).getName());
        }
        
        
        Query query3 = s.getNamedQuery("getStudentOrderBy");
        //query2.setParameter("name1","De");
        List<Student> list3 = query3.list();
        System.out.println("NameOrderBy : ");
        for(int i=0;i<list3.size();i++)
        {
        	System.out.println(list3.get(i).getName());
        }
        
        Query q1 = s.createQuery("select count(*) from Student");
        System.out.println("Count : "+q1.list().get(0));
        
        Query q11 = s.createQuery("select count(distinct city) from Student");
        List<Student> l1 = q11.list();
        System.out.println("Count : "+q11.list().get(0));
        for(int i=0;i<l1.size();i++)
        {
        	System.out.println(l1.get(i).getCity());
        }
      /*  Query q2 = s.createQuery("select count(s.id),s.city from Student s group by s.city");
        List<Object[]> list = q2.list();
        for(Object[] arr: list)
        {
        	System.out.println(Arrays.toString(arr));
        } */
        
     /*   Query q2 = s.createQuery("select count(id),city from Student group by city order by count(city) desc");
        List<Object[]> list = q2.list();
        for(Object[] arr: list)
        {
        	System.out.println(Arrays.,toString(arr));
        }
      */
       /* Query q2 = s.createQuery("select count(id),city from Student group by city having count(id)>1");
        List<Object[]> list = q2.list();
        for(Object[] arr: list)
        {
        	System.out.println(Arrays.toString(arr));
        }
        */
   /*  Query q2 = s.createQuery("select count(id),city from Student group by city having count(id)>1 order by count(id)");
        List<Object[]> list = q2.list();
        for(Object[] arr: list)
        {
        	System.out.println(Arrays.toString(arr));
        }
     /* Query q1 = s.createQuery("update Student d set d.name =:n , d.city=:c where id=:id ");
	     q1.setParameter("n","Uday");
	     q1.setParameter("c","Bombay");
	     q1.setParameter("id",3);
	     
	     int status = q1.executeUpdate();
	     System.out.println(status);*/
       
        tx.commit();
        s.close();
        sf.close();
    }
}
