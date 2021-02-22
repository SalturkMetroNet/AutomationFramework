package com.metronet.mis.utilities.ui;

import com.metronet.mis.pages.ves.*;

public class Pages
{
    private LoginPageVES loginPageVES;
    private NewPageVES newPageVES;
    private OrderSummaryPageVES orderSummaryPageVES;
    private ReviewOrderPageVES reviewOrderPageVES;
    private SearchPageVES searchPageVES;
    private ServicesPageVES servicesPageVES;

    public Pages()
    {
        this.loginPageVES = new LoginPageVES();
        this.newPageVES = new NewPageVES();
        this.orderSummaryPageVES = new OrderSummaryPageVES();
        this.reviewOrderPageVES = new ReviewOrderPageVES();
        this.searchPageVES = new SearchPageVES();
        this.servicesPageVES = new ServicesPageVES();
    }

    public LoginPageVES getLoginPageVES()
    {
        return loginPageVES;
    }

    public NewPageVES getNewPageVES()
    {
        return newPageVES;
    }

    public OrderSummaryPageVES getOrderSummaryPageVES()
    {
        return orderSummaryPageVES;
    }

    public ReviewOrderPageVES getReviewOrderPageVES()
    {
        return reviewOrderPageVES;
    }

    public SearchPageVES getSearchPageVES()
    {
        return searchPageVES;
    }

    public ServicesPageVES getServicesPageVES()
    {
        return servicesPageVES;
    }


}
