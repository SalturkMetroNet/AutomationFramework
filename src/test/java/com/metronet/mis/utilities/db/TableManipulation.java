package com.metronet.mis.utilities.db;

import com.metronet.mis.pojos.Address;
import com.metronet.mis.pojos.Parameter;
import com.metronet.mis.pojos.Subscriber;
import com.metronet.mis.utilities.common.ConfigurationReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableManipulation
{
    public static void writeSubToExcel(Subscriber subscriber, int i)
    {
        if (!new File(ConfigurationReader.getProperty("subinfo")).exists())
        {
            FileOutputStream fileOutputStream = null;
            try
            {
                fileOutputStream = new FileOutputStream(ConfigurationReader.getProperty("subinfo"));
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }

            Workbook workbook = new XSSFWorkbook();

            Sheet sheet = workbook.createSheet("Subs");

            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("First Name");
            cell = row.createCell(1);
            cell.setCellValue("Last Name");
            cell = row.createCell(2);
            cell.setCellValue("Contact Email Address");
            cell = row.createCell(3);
            cell.setCellValue("Contact Phone Number");
            cell = row.createCell(4);
            cell.setCellValue("Date of Birth");
            cell = row.createCell(5);
            cell.setCellValue("Service Address");
            cell = row.createCell(6);
            cell.setCellValue("Subscriber ID");

            row = sheet.createRow(i);

            cell = row.createCell(0);
            cell.setCellValue(subscriber.getFirstName());
            cell = row.createCell(1);
            cell.setCellValue(subscriber.getLastName());
            cell = row.createCell(2);
            cell.setCellValue(subscriber.getContactEmail());
            cell = row.createCell(3);
            cell.setCellValue(subscriber.getContactPhone());
            cell = row.createCell(4);
            cell.setCellValue(subscriber.getDateOfBirth());
            cell = row.createCell(5);
            cell.setCellValue(subscriber.getServiceAddress());
            cell = row.createCell(6);
            cell.setCellValue(subscriber.getSubId());

            try
            {
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {

            FileInputStream fileInputStream = null;
            Workbook workbook=null;
            try
            {
                fileInputStream = new FileInputStream(ConfigurationReader.getProperty("subinfo"));
                workbook = new XSSFWorkbook(fileInputStream);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);

            cell.setCellValue(subscriber.getFirstName());
            cell = row.createCell(1);
            cell.setCellValue(subscriber.getLastName());
            cell = row.createCell(2);
            cell.setCellValue(subscriber.getContactEmail());
            cell = row.createCell(3);
            cell.setCellValue(subscriber.getContactPhone());
            cell = row.createCell(4);
            cell.setCellValue(subscriber.getDateOfBirth());
            cell = row.createCell(5);
            cell.setCellValue(subscriber.getServiceAddress());
            cell = row.createCell(6);
            cell.setCellValue(subscriber.getSubId());

            try
            {
                fileInputStream.close();
                FileOutputStream fileOutputStream = new FileOutputStream(ConfigurationReader.getProperty("subinfo"));
                workbook.write(fileOutputStream);
                workbook.close();
                fileOutputStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static List<Address> readAddressesFromExcelFile(String excelFilePath) throws IOException
    {
        List<Address> listAddress = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(excelFilePath);

        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        String city = "";
        String street = "";
        String type = "";
        String active = "";

        int batchLimit = Integer.parseInt(ConfigurationReader.getProperty("batchlimit"));

        for (int i = 0; i < batchLimit; i++)
        {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext())
            {
                Cell nextCell = cellIterator.next();
                int columnIndex = nextCell.getColumnIndex();

                switch (columnIndex)
                {
                    case 0:
                        city = (String) getCellValue(nextCell);
                        break;
                    case 1:
                        street = (String) getCellValue(nextCell);
                        break;
                    case 2:
                        type = (String) getCellValue(nextCell);
                        break;
                    case 3:
                        active = (String) getCellValue(nextCell);
                        break;
                }
            }
            Address address = new Address(city, street, type, active);
            listAddress.add(address);
        }

        workbook.close();
        fileInputStream.close();

        return listAddress;
    }

    public static Parameter getParameters(String excelFilePath)
    {

        FileInputStream fileInputStream = null;
        List<String> temp = new ArrayList<>();
        Workbook workbook = null;
        try
        {
            fileInputStream = new FileInputStream(excelFilePath);
            workbook = new XSSFWorkbook(fileInputStream);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Sheet firstSheet = workbook.getSheetAt(0);
        Row row = firstSheet.getRow(1);
        Cell cell;

        for (int i = 0; i < 30; i++)
        {
            cell = row.getCell(i);
            String tempStr = getCellValue(cell) + "";
            tempStr = tempStr.charAt(0)+"";
            temp.add(tempStr);
        }

        return new Parameter(temp);
    }

    private static Object getCellValue(Cell cell)
    {
        switch (cell.getCellType())
        {
            case STRING:
                return cell.getStringCellValue();

            case BOOLEAN:
                return cell.getBooleanCellValue();

            case NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }

    public static void checkAndWriteExcel(List<Subscriber> subscriberList, String excelFilePath) throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook();

        for (Subscriber subscriber : subscriberList)
        {
            if (!new File(excelFilePath).exists())
            {
                writeExcelNew(subscriber, fileOutputStream, workbook);
            }
            else
            {
                writeExcelExisting(subscriber, fileOutputStream, workbook);
            }
            workbook.write(fileOutputStream);
        }
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();
    }

    public static void writeExcelNew(Subscriber subscriber, FileOutputStream fileOutputStream, Workbook workbook) throws IOException
    {
        Sheet sheet = workbook.createSheet("Subs");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("First Name");
        cell = row.createCell(1);
        cell.setCellValue("Last Name");
        cell = row.createCell(2);
        cell.setCellValue("Contact Email Address");
        cell = row.createCell(3);
        cell.setCellValue("Contact Phone Number");
        cell = row.createCell(4);
        cell.setCellValue("Date of Birth");
        cell = row.createCell(5);
        cell.setCellValue("Service Address");
        cell = row.createCell(6);
        cell.setCellValue("Subscriber ID");

        Row row2 = sheet.createRow(1);

    }

    public static void writeExcelExisting(Subscriber subscriber, FileOutputStream fileOutputStream, Workbook workbook) throws IOException
    {
        Sheet sheet = workbook.getSheetAt(1);
        int rowCount = sheet.getLastRowNum();

        Row row = sheet.createRow(rowCount);
        writeSubscriber(subscriber, row);
    }

    private static void writeSubscriber(Subscriber subscriber, Row row)
    {
        Cell cell = row.createCell(0);
        cell.setCellValue(subscriber.getFirstName());
        cell = row.createCell(1);
        cell.setCellValue(subscriber.getLastName());
        cell = row.createCell(2);
        cell.setCellValue(subscriber.getContactEmail());
        cell = row.createCell(3);
        cell.setCellValue(subscriber.getContactPhone());
        cell = row.createCell(4);
        cell.setCellValue(subscriber.getDateOfBirth());
        cell = row.createCell(5);
        cell.setCellValue(subscriber.getServiceAddress());
        cell = row.createCell(6);
        cell.setCellValue(subscriber.getSubId());
    }


}
