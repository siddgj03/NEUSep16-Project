package NEU_Project.DAO;

import NEU_Project.DTO.Special;

public class StringToSpecial {
        public static Special toSpecial(String line) throws Exception{
                boolean isDeleted = false;
                String[] info = line.toString().split("\\|");
                if (info.length < 12) {
                        isDeleted = true;
                }
                if (!isDeleted) {
                        Special newSpecial = new Special();
                        newSpecial.setSpecialID(info[0]);
                        newSpecial.setDealerWebID(info[1]);
                        newSpecial.setSpecialTitle(info[2]);
                        if (info[3] == null || info[3].equals("")) {
                                newSpecial.setDiscountPercentage(info[4]);
                        } else {
                                newSpecial.setDiscountValue(info[3]);
                        }
                        newSpecial.setSpecialStartDate(info[5]);
                        newSpecial.setSpecialEndDate(info[6]);
                        newSpecial.setCarYear(info[7]);
                        newSpecial.setCarMake(info[8]);
                        newSpecial.setCarModel(info[9]);
                        newSpecial.setTrim(info[10]);
                        newSpecial.setCarMinPrice(info[11]);
                        newSpecial.setCarMaxPrice(info[12]);
                        return newSpecial;
                } else {
                        return new Special();
                }

        }
}
