package com.niuzj.test;

import com.niuzj.model.Person;
import com.niuzj.util.JaxbXmlUtil;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test01 {

    @Test
    public void test01() throws JAXBException {
        Person person = new Person();
        person.setAge(10);
        person.setName("niuzheju");
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        person.setItem(list);
        Map<String, String> map = new HashMap<>();
        map.put("page", String.valueOf(1));
        map.put("total", String.valueOf(10));
        person.setProp(map);
        person.setTimestamp(System.currentTimeMillis());
        String s = JaxbXmlUtil.ObjectToString(person);
        System.out.println(s);
    }

    @Test
    public void test02() throws JAXBException {
        Person person = JaxbXmlUtil.xmlToObject("<person>\n" +
                "    <age>10</age>\n" +
                "    <username>niuzheju</username>\n" +
                "</person>", Person.class);
        System.out.println(person);
    }
}
