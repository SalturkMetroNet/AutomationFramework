package com.metronet.mis.pojos;

public class Subscriber
{
    private String firstName;
    private String lastName;
    private String contactEmail;
    private String contactPhone;
    private String dateOfBirth;
    private String serviceAddress;
    private String subId;
    private String newPhoneNumber;

    public Subscriber(String firstName, String lastName, String contactEmail, String contactPhone, String dateOfBirth, String serviceAddress)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.dateOfBirth = dateOfBirth;
        this.serviceAddress = serviceAddress;
        this.subId = "";
        this.newPhoneNumber = "-";
    }

    @Override
    public String toString()
    {
        return "Subscriber Info:" + "\n" +
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Contact Email: " + contactEmail + '\n' +
                "Contact Phone: " + contactPhone + '\n' +
                "Date Of Birth: " + dateOfBirth + '\n' +
                "Service Address: " + serviceAddress + '\n' +
                "Subscriber ID: " + subId + '\n' +
                "Assigned Phone Number: " + newPhoneNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getContactEmail()
    {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail)
    {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone()
    {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    public String getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getServiceAddress()
    {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress)
    {
        this.serviceAddress = serviceAddress;
    }

    public String getSubId()
    {
        return subId;
    }

    public void setSubId(String subId)
    {
        this.subId = subId;
    }

    public String getNewPhoneNumber()
    {
        return newPhoneNumber;
    }

    public void setNewPhoneNumber(String newPhoneNumber)
    {
        this.newPhoneNumber = newPhoneNumber;
    }

}
