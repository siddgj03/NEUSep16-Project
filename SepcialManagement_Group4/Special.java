
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
    private Integer discountValue;
    private Integer discountPercentage;
    private Date specialStartDate;
    private Date specialEndDate;
    private Integer carYear;
    private String carMake;
    private String carModel;
    private String trim;
    private Integer carMinPrice;
    private Integer carMaxPrice;

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

    public Integer getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(String discountValue) {
        if (discountValue == null || discountValue.length() == 0) {
            discountValue = null;
        }
        this.discountValue = Integer.parseInt(discountValue);
    }

    public Integer getDicountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        if (discountPercentage == null || discountPercentage.length() == 0) {
            discountPercentage = null;
        }
        this.discountPercentage = Integer.parseInt(discountPercentage);
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

    public Integer getCarMinPrice() {
        return carMinPrice;
    }

    public void setCarMinPrice(String carMinPrice) {
        if (carMinPrice == null || carMinPrice.equals("") || carMinPrice.length() == 0) {
            this.carMinPrice = new Integer(0);
        } else {
            this.carMinPrice = Integer.parseInt(carMinPrice);
        }
    }

    public Integer getCarMaxPrice() {
        return carMaxPrice;
    }

    public void setCarMaxPrice(String  carMaxPrice) {
        if (carMaxPrice == null || carMaxPrice.equals("") || carMaxPrice.length() == 0) {
            this.carMaxPrice = new Integer(10000000);
        } else {
            this.carMaxPrice = Integer.parseInt(carMaxPrice);
        }

    }

    public Special(int specialID, String dealerWebID, String specialTitle, Integer discountValue, Integer discountPercentage, String specialStartDate, String specialEndDate, Integer carYear, String carMake, String carModel, String trim, Integer carMinPrice, Integer carMaxPrice) throws Exception {
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

    public Special(int specialID) throws Exception {
        this.specialID = specialID;
        this.dealerWebID = "Dealer_Web_Id(Deleted)";
        this.specialTitle = "Special_Title(Deleted)";
        this.discountValue = 0;
        this.discountPercentage = 0;
        this.specialStartDate = stringToDate("1970/01/01");
        this.specialEndDate = stringToDate("1970/01/01");
        this.carYear = 0;
        this.carMinPrice = 0;
        this.carMaxPrice = Integer.MAX_VALUE / 2;
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

    protected String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String dateString = sdf.format(date);
        return dateString;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(specialID + "|");
        sb.append(dealerWebID + "|");
        sb.append(specialTitle + "|");
        sb.append((discountValue == null ? "" : String.valueOf(discountValue)) + "|");
        sb.append((discountPercentage == null ? "" : String.valueOf(discountPercentage)) + "|");
        sb.append((specialStartDate == null ? "" : dateToString(specialStartDate)) + "|");
        sb.append((specialEndDate == null ? "" : dateToString(specialEndDate)) + "|");
        sb.append((carYear == null ? "" : carYear) + "|");
        sb.append((carMake == null ? "" : carMake) + "|");
        sb.append((carModel == null ? "" : carModel) + "|");
        sb.append((trim == null ? "" : trim) + "|");
        sb.append((carMinPrice == null ? "" : String.valueOf(carMinPrice)) + "|");
        sb.append((carMaxPrice == null ? "" : String.valueOf(carMaxPrice)));
        sb.append("\n");
        return sb.toString();
    }

//    public static void main(String[] args) {
//        try {
//            Special newSpecial = new Special(001, "gmps-xyz", "Winter Sale", 250.0, null, "2016/11/01", "2017/01/01", 2017, "Chevrolet", "Camaro", "", null, 35000.0);
//            System.out.println(newSpecial);
//        } catch (Exception e) {
//            System.out.println("Invalid input");
//        }
//    }
}

