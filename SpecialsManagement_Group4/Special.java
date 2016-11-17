import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiqi on 2016/11/15.
 */
public class Special {
    private int specialID;

    public int getSpecialID() {
        return specialID;
    }

    public void setSpecialID(int specialID) {
        this.specialID = specialID;
    }

    public String getDealerWebID() {
        return dealerWebID;
    }

    public void setDealerWebID(String dealerWebID) {
        this.dealerWebID = dealerWebID;
    }

    public String getSpecialTitle() {
        return specialTitle;
    }

    public void setSpecialTitle(String specialTitle) {
        this.specialTitle = specialTitle;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountValue) {
        this.discountValue = discountValue;
    }

    public double getDicountPercentage() {
        return dicountPercentage;
    }

    public void setDicountPercentage(double dicountPercentage) {
        this.dicountPercentage = dicountPercentage;
    }

    public Date getSpecialStartDate() {
        return specialStartDate;
    }

    public void setSpecialStartDate(Date specialStartDate) {
        this.specialStartDate = specialStartDate;
    }

    public Date getSpecialEndDate() {
        return specialEndDate;
    }

    public void setSpecialEndDate(Date specialEndDate) {
        this.specialEndDate = specialEndDate;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public double getCarMinPrice() {
        return carMinPrice;
    }

    public void setCarMinPrice(double carMinPrice) {
        this.carMinPrice = carMinPrice;
    }

    public double getCarMaxPrice() {
        return carMaxPrice;
    }

    public void setCarMaxPrice(double carMaxPrice) {
        this.carMaxPrice = carMaxPrice;
    }

    private String dealerWebID;
    private String specialTitle;
    private double discountValue;
    private double dicountPercentage;
    private Date specialStartDate;
    private Date specialEndDate;
    private int carYear;
    private String carMake;
    private String carModel;
    private String trim;
    private double carMinPrice;
    private double carMaxPrice;

    public Special(int specialID, String dealerWebID, String specialTitle, double discountValue, double dicountPercentage, String specialStartDate, String specialEndDate, int carYear, String carMake, String carModel, String trim, double carMinPrice, double carMaxPrice) throws Exception {
        this.specialID = specialID;
        this.dealerWebID = dealerWebID;
        this.specialTitle = specialTitle;
        this.discountValue = discountValue;
        this.dicountPercentage = dicountPercentage;
        this.specialStartDate = stringToDate(specialStartDate);
        this.specialEndDate = stringToDate(specialEndDate);
        this.carYear = carYear;
        this.carMake = carMake;
        this.carModel = carModel;
        this.trim = trim;
        this.carMinPrice = carMinPrice;
        this.carMaxPrice = carMaxPrice;
    }

    public Special() {

    }

    private Date stringToDate(String s) throws Exception {
        DateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            Date resultDate = date.parse(s);
            return resultDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
