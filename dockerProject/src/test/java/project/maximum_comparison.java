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

public class maximum_comparison {
	@Test
	public void maximum() throws IOException
	{
		 List<Integer> excel_value=new ArrayList<Integer>();
		    List<Integer> difference=new ArrayList<Integer>();
			String filepath="C:\\Users\\user\\eclipse-workspace\\dockerProject\\maximum\\maximum_price.xlsx";
			FileInputStream inputstream=new FileInputStream(filepath);
			XSSFWorkbook  workbook = new XSSFWorkbook(inputstream);
			XSSFSheet sheet=workbook.getSheetAt(0);
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(1).getLastCellNum();
			
			for(int i=1;i<91;i++)
			{
				XSSFRow row=sheet.getRow(i);
				
				for(int j=1;j<2;j++)
				{
					XSSFCell cell=row.getCell(j);
					int excel_min_value=(int) cell.getNumericCellValue();
					excel_value.add(excel_min_value);
					
					/*switch(cell.getCellType())
					{
						case NUMERIC:cell.getNumericCellValue();break;
					}*/
				}
				
			}
			for(int i=0;i<90;i++)
			{
		System.out.println(excel_value.get(i));
			}
			System.out.println("-------------------");
		  List<String> request_type = new ArrayList<String>();
		   List<Integer> request_type_max = new ArrayList<Integer>();
		   List<String> request_type_model = new ArrayList<String>();
			Response res =    given()
			.contentType(ContentType.JSON)
			
			.when()
			.get("http://192.168.0.24:8001/api?fromDate=2021-01-01&toDate=2021-03-31&variety=Desi&market=Ghaziabad&state=UP");
		//http://192.168.0.24:8001/api?fromDate=2021-01-01&toDate=2021-03-31&variety=Potato&market=Azadpur&state=Delhi
			/*for(int i=0;i<15;i++)
			{
				request_type.add(res.jsonPath().get("prices['Max Price (Rs./Quintal)']["+i+"]").toString());
		
		
		
			}*/
			
			for(int i=0;i<90;i++)
			{
				String max_text=res.jsonPath().get("prices['Max Price (Rs./Quintal)']["+i+"]").toString();
				
				double max_value=Double.parseDouble(max_text);
				int value=(int)max_value;
				request_type_max.add(value);
		
		
		
			}
			/*for(int i=0;i<15;i++)
			{
				request_type_model.add(res.jsonPath().get("prices['Modal Price (Rs./Quintal)']["+i+"]").toString());
		
		
		
			}*/
			for(int i=0;i<90;i++)
			{
				
				System.out.println(request_type_max.get(i));
			}
			
			
			XLUtility xlutil=new XLUtility(filepath);
			//header in excel sheet
			xlutil.setCellData1("Sheet1", 0, 2, "pred_max_price");
			xlutil.setCellData1("Sheet1", 0, 3, "Difference");
			int j=0;
					for(int i=1;i<91;i++)
			{
				
			xlutil.setCellData("Sheet1",i,2,request_type_max.get(j++));
				
			
			}
			System.out.println("done");
			
			for(int i=0;i<90;i++)
			{
			int diff =	request_type_max.get(i)-excel_value.get(i);
			System.out.println("predicited_max_value = "+request_type_max.get(i)+"  and actual max value = "+excel_value.get(i)+"  difference is = "+diff);
			}
			System.out.println("##############33");
			for(int i=0;i<90;i++)
			{
				difference.add(request_type_max.get(i)-excel_value.get(i));
			}
			
			int k=0;
			for(int i=1;i<91;i++)
			{
				
				xlutil.setCellData("Sheet1",i,3,difference.get(k++));
			}
			
	}

}
