package biebf.git.demo;

import java.lang.reflect.Field;
import java.util.Date;

/**
 *
 * @author biebf
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        System.out.println(String.class.getName());
        System.out.println(Integer.class);
        System.out.println(Date.class);
        Person p = new Person();
        injectDefaultValue(p);
        System.out.println(p.toString());
    }

    private static void injectDefaultValue(Object object) throws Exception{
        Field [] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            // private 属性值访问权限
            field.setAccessible(true);
            String dataType = field.getType().getTypeName();
            Object value = field.get(object);
            if(null != value){
                continue;
            }
            if(String.class.getName().equals(dataType)){
                field.set(object, "");
            }
            if(Integer.class.getName().equals(dataType)){
                field.set(object, 0);
            }
            if(Boolean.class.getName().equals(dataType)) {
                field.set(object, true);
            }
            if(Date.class.getName().equals(dataType)){
                field.set(object, new Date());
            }
        }
    }
}

class Person {
    private String name;
    private Integer age;
    private Boolean sex;
    private Date birthday;

    public Person() {
    }

    public Person(String name, Integer age, Boolean sex, Date birthday) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }
}