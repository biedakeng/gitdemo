package biebf.git.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @deacription java 8的新版排序，多维度自定义排序规则
 * @author biebf
 * @since 2020/6/11 9:09
 * @version 1.0
 */
public class ListSortDemo {

    public static void main(String[] args) throws Exception {
        List<Student> stuList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        stuList.add(new Student("wang", "18", sdf.parse("2007/04/01")));
        stuList.add(new Student("li", "19", sdf.parse("2007/05/01")));
        stuList.add(new Student("liu", "20", sdf.parse("2006/04/01")));
        stuList.add(new Student("xi", "20", sdf.parse("2006/04/01")));
        stuList.add(new Student("li", "17", sdf.parse("2007/05/01")));
        stuList.add(new Student("wang", "19", sdf.parse("2007/06/01")));

        // 单独排序1（只使用一个字段进行排序，用一个新的list 进行接收）
        List<Student> result1 = stuList.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        result1.forEach(System.out::println);

        System.out.println("======================================");

        // age升序
        Comparator<Student> byIdAsc = Comparator.comparing(Student::getAge);

        // 单独排序2
        List<Student> result2 = stuList.stream().sorted(byIdAsc).collect(Collectors.toList());
        result2.forEach(System.out::println);

        System.out.println("======================================");

        // 联合排序
        // named不分区大小写降序
        Comparator<Student> byNameDesc = Comparator.comparing(Student::getName, String.CASE_INSENSITIVE_ORDER).reversed();
        // birthday 降序
        Comparator<Student> byDateDesc = Comparator.comparing(Student::getBirthday).reversed();
        Comparator<Student> finalComparator = byDateDesc.thenComparing(byIdAsc).thenComparing(byNameDesc);
        List<Student> result3 = stuList.stream().sorted(finalComparator).collect(Collectors.toList());
        result3.forEach(System.out::println);
    }

}

class Student {
    private Long id;
    private String name;
    private String age;
    private Date birthday;

    public Student() {
    }

    public Student(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, String age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getBirthdayStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", birthday=" + getBirthdayStr() + "]";
    }

}


