package zzy;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Tets {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        A a = new A();
        a.setName("zzy");a.setAge(18);a.setSex("male");
        Class clazz = A.class;
        Method[] methods = clazz.getDeclaredMethods();
        Field[] fields = clazz.getDeclaredFields();
        for (Method method:methods) {
            if (method.getName().startsWith("get")){
                System.out.println(method.invoke(a));
            }
        }
    }
}

class A implements Serializable {
    private String name;
    private String sex;
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
