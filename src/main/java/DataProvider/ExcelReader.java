package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static XSSFWorkbook wb;
	
	public static Object[][] getDataFromSheet(String pathoftestfile, String sheetname)
	{
		System.out.println("************Loading data from Excel************");
		Object arr[][]=null;
		
		try
		{
			wb=new XSSFWorkbook(new FileInputStream(new File(pathoftestfile)));
			//Load excel file
			
			XSSFSheet sheet=wb.getSheet(sheetname);
			//select sheet
			
			int rows=sheet.getPhysicalNumberOfRows();
			int columns=sheet.getRow(0).getPhysicalNumberOfCells();
			//find rows and columns
			
			arr=new Object[rows-1][columns];//using -1 as file can have header, if no header use 0
			//create array object using the number of rows and columns from the sheet
			
			for(int i=1;i<rows;i++)//using 1 as file can have header, if no header use 0
			{
				for(int j=0;j<columns;j++)
				{
					arr[i-1][j]= getdatatype(sheetname, i, j);//using -1 as file can have header, if no header use 0
				}
			}
			//store data from excel into array
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("Unable to find the file"+e.getMessage());
		}
		catch(IOException e)
		{
			System.out.println("unable to open the file"+e.getMessage());
		}
		//handling exceptions
		
		System.out.println("************Data Loaded from Excel************");
		
		return arr;
		
	}
	
	public static String getdatatype(String sheet, int row, int column)
	{
		XSSFCell cell=wb.getSheet(sheet).getRow(row).getCell(column);
		String data = "";
		if(cell.getCellType()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellType()==CellType.NUMERIC)
		{
			data=String.valueOf(cell.getNumericCellValue());
		}
		else if(cell.getCellType()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}
	
}
