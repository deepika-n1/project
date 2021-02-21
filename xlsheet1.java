package exel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class xlsheet1 
{
	@Test
	public void test() throws EncryptedDocumentException, FileNotFoundException, IOException, Exception
	{
		Workbook wk=WorkbookFactory.create(new FileInputStream("./TestData/l2.xlsx"));
		Sheet sh = wk.getSheet("Sheet1");
		if(sh==null)
		{
			sh=wk.createSheet();
		}
		int mul;
		for(int j=0;j<10;j++)
		{
			for(int i=0;i<9;i++)
			{
				Row r = sh.getRow(j);
				if(r==null)
				{
					r=sh.createRow(j);
				}
				
				Cell c = r.getCell(i);
				if(c==null)
				{
					c=r.createCell(i);
				}
				mul=(i+2)*(j+1);	
				c.setCellValue(mul);	
			}
		}
		
		FileOutputStream fos=new FileOutputStream("./TestData/l2.xlsx");
		wk.write(fos);
		fos.close();
		wk.close();
	}


	@Test
	public static void testA() throws Exception
	{
		FileInputStream fis=new FileInputStream("./TestData/l2.xlsx");
		Workbook wk=WorkbookFactory.create(fis);
		Sheet sh2 = wk.createSheet();
		Sheet sh1 = wk.getSheetAt(0);
		
		int rows=sh1.getLastRowNum();
		int cols=sh1.getRow(1).getLastCellNum();
		
		for(int r=0;r<=rows;r++)
		{
			Row r1 = sh1.getRow(r);
			
			
			for(int c=0;c<cols;c++)
			{
				Cell c1 = r1.getCell(c);
				
				double n = c1.getNumericCellValue();

				for(int k=0;k<10;k++)
				{
					for(int m=0;m<10;m++)
					{
						
						Row r3 = sh2.getRow(k);
						if(r3==null)
						{
							r3=sh2.createRow(k);
						}
						
						Cell c4 = r3.getCell(m);
						if(c4==null)
						{
							c4=r3.createCell(m);
						}
					
						
						c4.setCellValue(n);
					}
					
				}
				
			}
			FileOutputStream fout=new FileOutputStream("./TestData/l2.xlsx");
			wk.write(fout);
			fout.close();
			fis.close();
				
		}
		
	}
}
	


	





