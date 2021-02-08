package com.metronet.mis.pojos;

/**
 * Address class to contain the information
 */
public class Address
{
    private String city;
    private String street;
    private String type;
    private String active;

    public Address(String city, String street, String type, String active)
    {
        this.city = city;
        this.street = street;
        this.type = type;
        this.active = active;
    }

    @Override
    public String toString()
    {
        return "Address{" +
                "City='" + city + '\'' +
                ", Street='" + street + '\'' +
                ", Type='" + type + '\'' +
                ", Active=" + active +
                '}';
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getActive()
    {
        return active;
    }

    public void setActive(String active)
    {
        this.active = active;
    }
}
