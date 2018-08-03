package ds_session_2_que3;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class GetStudentListFromExcel {
	public List<Program> getStudentListFromExcel(){
		List<Program> excelProgramList=new LinkedList<Program>();
		try{
			Workbook workbook = Workbook.getWorkbook(new java.io.File("C:\\Users\\User30\\Documents\\sheet.xls"));
			Sheet sheet1 = workbook.getSheet(0);
			String[] programArray=new String[sheet1.getColumns()];
			for(int i=0;i<sheet1.getRows();i++){
				for(int j=0;i<sheet1.getColumns();j++){
					if(j==1){
					programArray[j]= sheet1.getCell(j,i).getContents();
					}

				}
				excelProgramList.add(new Program(programArray[0],Integer.parseInt(programArray[1])));
			}
			
		} catch (BiffException biffexception) {

			biffexception.printStackTrace();

		} catch (IOException ioexception) {

			ioexception.printStackTrace();

		}
		return excelProgramList;
	}
}
