import java.time.LocalDate;
import java.time.LocalDateTime;
public class PoliceCardIndex {
    private String PIB;
    private LocalDate birthDay;
    private float height;
    private String eyesColor;
    private String specialDescription;
    private LocalDate arrestTime;
    private LocalDate giveFreedomTime;
    public String getPIB() {
        return PIB;
    }
    public void setPIB(String PIB) {
        this.PIB = PIB;
    }
    public LocalDate getBirthDay() {
        return birthDay;
    }
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        this.height = height;
    }
    public String getEyesColor() {
        return eyesColor;
    }
    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }
    public String getSpecialDescription() {
        return specialDescription;
    }
    public void setSpecialDescription(String specialDescription) {
        this.specialDescription = specialDescription;
    }
    public LocalDate getArrestTime() {
        return arrestTime;
    }
    public void setArrestTime(LocalDate arrestTime) {
        this.arrestTime = arrestTime;
    }
    public LocalDate getGiveFreedomTime() {
        return giveFreedomTime;
    }
    public void setGiveFreedomTime(LocalDate giveFreedomTime) {
        this.giveFreedomTime = giveFreedomTime;
    }
}