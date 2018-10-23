package com.niuzj.model;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;
import java.util.Map;
//参考https://www.cnblogs.com/h--d/p/7050099.html
//标识一个类可以被转换为xml
@XmlRootElement
//指定哪些属性可以被转换为xml元素
@XmlAccessorType(XmlAccessType.FIELD)
//指定转换为xml后元素的顺序
@XmlType(propOrder = {"age", "name", "item", "prop", "timestamp"})
//生成元素后按字母排序
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class Person {

    //指定转换为xml后的元素名称,默认为属性名
    @XmlElement(name = "username")
    private String name;

    private Integer age;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Long timestamp;

    //集合类型需要在外面包装一层标签
    @XmlElementWrapper(name = "items")
    private List<Integer> item;

    @XmlElementWrapper(name = "pros")
    private Map<String, String> prop;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Map<String, String> getProp() {
        return prop;
    }

    public void setProp(Map<String, String> prop) {
        this.prop = prop;
    }

    public List<Integer> getItem() {
        return item;
    }

    public void setItem(List<Integer> item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", timestamp=" + timestamp +
                ", item=" + item +
                ", prop=" + prop +
                '}';
    }
}
