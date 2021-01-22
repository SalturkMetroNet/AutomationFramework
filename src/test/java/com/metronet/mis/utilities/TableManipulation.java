package com.metronet.mis.utilities;

import com.metronet.mis.pojos.Address;
import com.metronet.mis.pojos.Subscriber;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TableManipulation
{
    public static List<Address> readAddressesFromExcelFile(String excelFilePath) throws IOException
    {
        List<Address> listAddress = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream(new File(excelFilePath));

        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();

        String city = "";
        String street = "";
        String type = "";
        String active = "";

        for (int i = 0; i < 11; i++)
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

    public static void writeExcel(List<Subscriber> subscriberList, String excelFilePath) throws IOException
    {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();

        int rowCount = 0;

        for (Subscriber subscriber : subscriberList)
        {
            Row row = sheet.createRow(++rowCount);
            writeSubscriber(subscriber, row);
        }

        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
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
}
