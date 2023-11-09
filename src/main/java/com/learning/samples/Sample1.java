package com.learning.samples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Sample1 {
    public static void main(String args[] ) throws Exception {
        //Scanner read = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Long> cities = new HashMap<>();
        long capCityPostCode = 0;
        String capCityName = "";
        int noOfCity = 0;
        String queryCity1 = "";
        String queryCity2 = "";

        capCityName = reader.readLine();// read.nextLine();
        capCityPostCode = Long.parseLong(reader.readLine());// read.nextLong();
        noOfCity = Integer.parseInt(reader.readLine());// read.nextInt();

        for (int i = 0; i < noOfCity; i++) {
                String cityName = reader.readLine();// read.nextLine();
                long cityPostal = Long.parseLong(reader.readLine());// read.nextLong();
                cities.put(cityName, cityPostal);
        }
        queryCity1 = reader.readLine();// read.nextLine();
        queryCity2 = reader.readLine();// read.nextLine();

//        System.out.println("capCityName:" + capCityName);
//        System.out.println("capCityPostCode:" + capCityPostCode);
//        System.out.println("noOfCity:" + noOfCity);
//        System.out.println("cities:" + cities);
//        System.out.println("queryCity1:" + queryCity1);
//        System.out.println("queryCity2:" + queryCity2);

        if(null != cities.get(queryCity1) && null != cities.get(queryCity2)) {
            String res = (cities.get(queryCity1) - capCityPostCode) < (cities.get(queryCity2) - capCityPostCode) ? queryCity1 : queryCity2;
            System.out.println(res);
        }
    }
}
