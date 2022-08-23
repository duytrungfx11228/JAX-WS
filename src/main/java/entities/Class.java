package entities;

public class Class {
    private long id;
    private String name;
    private String code;

    public Class() {
    }

    public Class(String name, String code) {
        this.name = name;
        this.code = code;
    }

    //region setter-getter
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
    //endregion
}
