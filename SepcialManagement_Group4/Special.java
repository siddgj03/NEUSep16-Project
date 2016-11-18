import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qiqi on 2016/11/15.
 */
public class Special {

    private int specialID;
    private String dealerWebID;
    private String specialTitle;
    private Double discountValue;
    private Double discountPercentage;
    private Date specialStartDate;
    private Date specialEndDate;
    private Integer carYear;
    private String carMake;
    private String carModel;
    private String trim;
    private Double carMinPrice;
    private Double carMaxPrice;

    public int getSpecialID() {
        return specialID;
    }

    public void setSpecialID(Integer specialID) {
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

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public double getDicountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double dicountPercentage) {
        this.discountPercentage = dicountPercentage;
    }

    public Date getSpecialStartDate() {
        return specialStartDate;
    }

    public void setSpecialStartDate(String specialStartDate) throws Exception {
        this.specialStartDate = stringToDate(specialStartDate);
    }

    public Date getSpecialEndDate() {
        return specialEndDate;
    }

    public void setSpecialEndDate(String specialEndDate) throws Exception {
        this.specialEndDate = stringToDate(specialEndDate);
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYearString) {
        if (carYearString == null || carYearString.equals("")) {
            carYear = new Integer(1990);
        } else {
            this.carYear = Integer.parseInt(carYearString);
        }
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

    public void setCarMinPrice(String carMinPrice) {
        if (carMinPrice == null || carMinPrice.equals("")) {
            this.carMinPrice = new Double(0.0);
        } else {
            this.carMinPrice = Double.parseDouble(carMinPrice);
        }
    }

    public double getCarMaxPrice() {
        return carMaxPrice;
    }

    public void setCarMaxPrice(String  carMaxPrice) {
        if (carMaxPrice == null || carMaxPrice.equals("")) {
            this.carMaxPrice = new Double(10000000.0);
        } else {
            this.carMaxPrice = Double.parseDouble(carMaxPrice);
        }

    }

    public Special(int specialID, String dealerWebID, String specialTitle, Double discountValue, Double discountPercentage, String specialStartDate, String specialEndDate, Integer carYear, String carMake, String carModel, String trim, Double carMinPrice, Double carMaxPrice) throws Exception {
        this.specialID = specialID;
        this.dealerWebID = dealerWebID;
        this.specialTitle = specialTitle;
        this.discountValue = discountValue;
        this.discountPercentage = discountPercentage;
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

    private static Date stringToDate(String s) throws Exception {
        if (s == null) {
            return null;
        }
        DateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            Date resultDate = date.parse(s + " 00:00:00");
            return resultDate;
        } catch (Exception e) {
            System.out.println("Invalid Date Input");
            e.printStackTrace();
        }
        return null;
    }

    private String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String dateString = sdf.format(date);
        return dateString;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(specialID + "|");
        sb.append(dealerWebID + "|");
        sb.append(specialTitle + "|");
        sb.append((discountValue == null ? "" : discountValue) + "|");
        sb.append((discountPercentage == null ? "" : discountPercentage) + "|");
        sb.append((specialStartDate == null ? "" : dateToString(specialStartDate)) + "|");
        sb.append((specialEndDate == null ? "" : dateToString(specialEndDate)) + "|");
        sb.append((carYear == null ? "" : carYear) + "|");
        sb.append((carMake == null ? "" : carMake) + "|");
        sb.append((carModel == null ? "" : carModel) + "|");
        sb.append((trim == null ? "" : trim) + "|");
        sb.append((carMinPrice == null ? "" : carMinPrice) + "|");
        sb.append((carMaxPrice == null ? "" : carMaxPrice));
        sb.append("\n");
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            Special newSpecial = new Special(001, "gmps-xyz", "Winter Sale", 250.0, null, "2016/11/01", "2017/01/01", 2017, "Chevrolet", "Camaro", "", null, 35000.0);
            System.out.println(newSpecial);
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}

