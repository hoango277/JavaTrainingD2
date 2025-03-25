package ttcs.entity;

public class User {

    private String fullName;
    private String email;
    private String password;
    private Integer expInYears;
    private String proSkill;

    public User( String fullName, String email, String password) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.expInYears = null;
        this.proSkill = null;
    }
    public User( String fullName, String email, String password, Integer expInYears) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.expInYears = expInYears;
        this.proSkill = null;
    }
    public User( String fullName, String email, String password, String proSkill) {

        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.proSkill = proSkill;
        this.expInYears = null;
    }



    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getExpInYears() {
        return expInYears;
    }

    public String getProSkill() {
        return proSkill;
    }
}
