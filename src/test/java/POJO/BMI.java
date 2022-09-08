package POJO;

import com.poiji.annotation.ExcelCellName;
import lombok.Data;

@Data
public class BMI {
    @ExcelCellName("Age")
    private String age;
    @ExcelCellName("Gender")
    private String gender;
    @ExcelCellName("Height")
    private String height;
    @ExcelCellName("Weight")
    private String weight;
    @ExcelCellName("ExpectedResults")
    private String expectedResults;

}
