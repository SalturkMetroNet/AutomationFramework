package com.metronet.mis.TestDataGeneration;

import com.github.javafaker.Faker;
import org.junit.Test;

import java.text.SimpleDateFormat;

public class Practicetest
{
    @Test
    public void test()
    {
        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.numerify("###-###-####"));
        System.out.println(sdf.format(faker.date().birthday()));
    }
}
