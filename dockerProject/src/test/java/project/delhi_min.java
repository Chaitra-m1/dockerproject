package project;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class delhi_min {
@Test
public void min() throws IOException{
		// TODO Auto-generated method stub
		  List<Integer> excel_value=new ArrayList<Integer>();
		    List<Integer> difference=new ArrayList<Integer>();
			String filepath="C:\\Users\\user\\eclipse-workspace\\dockerProject\\excel\\up_price.xlsx";
			FileInputStream inputstream=new FileInputStream(filepath);
			XSSFWorkbook  workbook = new XSSFWorkbook(inputstream);
			XSSFSheet sheet=workbook.getSheetAt(0);
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(1).getLastCellNum();
			
			for(int i=1;i<17;i++)
			{
				XSSFRow row=sheet.getRow(i);
				
				for(int j=1;j<2;j++)
				{
					//System.out.println(i);
					XSSFCell cell=row.getCell(1);
					//System.out.println(cell);
					int excel_min_value=(int) cell.getNumericCellValue();
					excel_value.add(excel_min_value);
					
					/*switch(cell.getCellType())
					{
						case NUMERIC:cell.getNumericCellValue();break;
					}*/
				}
				
			}
			for(int i=0;i<16;i++)
			{
		System.out.println(excel_value.get(i));
			}
			System.out.println("-------------------");
		  List<String> request_type = new ArrayList<String>();
		   List<Integer> request_type_min = new ArrayList<Integer>();
		   List<String> request_type_model = new ArrayList<String>();
			Response res =    given()
			.contentType(ContentType.JSON)
			
			.when()
			.get("http://192.168.0.24:8001/api?fromDate=2021-01-15&toDate=2021-01-30&variety=Desi&market=Ghaziabad&state=UP");
		
			/*for(int i=0;i<15;i++)
			{
				request_type.add(res.jsonPath().get("prices['Max Price (Rs./Quintal)']["+i+"]").toString());
		
		
		
			}*/
			
			for(int i=0;i<16;i++)//check last number in excel if i starts with 0 then excel last_index-1
			{
				String min_text=res.jsonPath().get("prices['Min Price (Rs./Quintal)']["+i+"]").toString();
				
				double min_value=Double.parseDouble(min_text);
				int value=(int)min_value;
				request_type_min.add(value);
		
		
		
			}
			/*for(int i=0;i<15;i++)
			{
				request_type_model.add(res.jsonPath().get("prices['Modal Price (Rs./Quintal)']["+i+"]").toString());
		
		
		
			}*/
			for(int i=0;i<16;i++)
			{
				
				System.out.println(request_type_min.get(i));
			}
			
			
			XLUtility xlutil=new XLUtility(filepath);
			//header in excel sheet
			xlutil.setCellData1("Sheet1", 0, 2, "pred_min_price");
			xlutil.setCellData1("Sheet1", 0, 3, "Difference");
			int j=0;
					for(int i=1;i<17;i++)
			{
				
			xlutil.setCellData("Sheet1",i,2,request_type_min.get(j++));
				
			
			}
			System.out.println("done");
			
			for(int i=0;i<16;i++)
			{
			int diff =	request_type_min.get(i)-excel_value.get(i);
			System.out.println("predicited_min_value = "+request_type_min.get(i)+"  and actual min value = "+excel_value.get(i)+"  difference is = "+diff);
			}
			System.out.println("##############33");
			for(int i=0;i<16;i++)
			{
				difference.add(request_type_min.get(i)-excel_value.get(i));
			}
			
			int k=0;
			for(int i=1;i<17;i++)
			{
				
				xlutil.setCellData("Sheet1",i,3,difference.get(k++));
			}

	}

}
