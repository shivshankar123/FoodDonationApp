package Data.models;

public class Recipient {
    private String id;
    private String name;
    private String contactInfo;

    public Recipient(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }
}
