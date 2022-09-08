package POJO;



public class bmiData {

    private String age;

    private String gender;

    private String height;

    private String weight;

    private String expectedResults;

    public bmiData(String age, String gender, String height, String weight, String expectedResults) {
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.expectedResults = expectedResults;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getExpectedResults() {
        return expectedResults;
    }
}
