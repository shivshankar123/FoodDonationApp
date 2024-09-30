package Data.models;

import org.json.simple.JSONObject;

public class Donation {
    private String donationId;
    private String donorId;
    private String foodType;
    private double quantity;
    private String unit;
    private String expirationDate;

    public Donation(String donationId, String donorId, String foodType, double quantity, String unit, String expirationDate) {
        this.donationId = donationId;
        this.donorId = donorId;
        this.foodType = foodType;
        this.quantity = quantity;
        this.unit = unit;
        this.expirationDate = expirationDate;
    }

    public String getDonationId() { return donationId; }
    public String getDonorId() { return donorId; }
    public String getFoodType() { return foodType; }
    public double getQuantity() { return quantity; }
    public String getUnit() { return unit; }
    public String getExpirationDate() { return expirationDate; }

    public JSONObject toJSON() {
        JSONObject donationObj = new JSONObject();
        donationObj.put("donationId", donationId);
        donationObj.put("donorId", donorId);
        donationObj.put("foodType", foodType);
        donationObj.put("quantity", quantity);
        donationObj.put("unit", unit);
        donationObj.put("expirationDate", expirationDate);
        return donationObj;
    }
}
