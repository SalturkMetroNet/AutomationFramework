package com.metronet.mis.test_data_generation.Scripts;

import com.metronet.mis.pojos.Address;
import com.metronet.mis.utilities.db.DBUtilities;
import org.junit.Test;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GetAddress
{
    @Test
    public void test()
    {
        try
        {
            List<Address> addresses = DBUtilities.getData();
            for (Address each : addresses)
            {
                System.out.println(each.toString());
            }
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    @Test
    public void test1()
    {
        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        System.out.println(dateFormat.format(date));
    }
}
