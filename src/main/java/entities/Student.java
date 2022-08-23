package entities;

public class Student {
    private long id;
    private String name;
    private String code;
    private int age;
    private String className;
    private String address;
    private float mark;

    public Student() {
    }

    public Student(String name, String code, int age, String className, String address, float mark) {
        this.name = name;
        this.code = code;
        this.age = age;
        this.className = className;
        this.address = address;
        this.mark = mark;
    }

    //region getter-setter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }
    //endregion
}
