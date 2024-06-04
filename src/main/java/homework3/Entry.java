package homework3;

public class Entry implements Comparable<Entry> {
    // implement the relevant data attributes
    private String name;
    private String street_address;
    private String city;
    private String postcode;
    private String country;
    private String phone_number;

    public Entry(String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.street_address = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phone_number = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getStreetAddress() {
        return street_address;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    @Override
    public int compareTo(Entry other) {
        // implement the actual compareTo logic (remove next line)
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString() {
        return "Name: " + this.name + "\n" +
                "Street Address: " + this.street_address + "\n" +
                "City: " + this.city + "\n" +
                "Postal code: " + this.postcode + "\n" +
                "Country: " + this.country + "\n" +
                "Phone Number: " + this.phone_number + "\n";
    }
}