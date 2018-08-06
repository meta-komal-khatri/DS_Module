package ds_session_2_que3;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.sun.rowset.internal.Row;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class GetProgramListFromExcel{
	//College college=new College();
	public List<Program> getProgramListFromExcel() {
		List<Program> excelProgramList=new LinkedList<Program>();
		
			Workbook workbook = null;
			try {
				workbook = Workbook.getWorkbook(new java.io.File("C:\\Users\\popla\\OneDrive\\Documents\\Program.xls"));
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Sheet sheet1 = workbook.getSheet(0);
			String[] programArray;
			for(int i=0;i<sheet1.getRows();i++){
				programArray=new String[sheet1.getColumns()];
				for(int j=0;j<sheet1.getColumns();j++){
					programArray[j]= sheet1.getCell(j,i).getContents();

				}
				excelProgramList.add(new Program(programArray[0],Integer.parseInt(programArray[1])));
			}
			
			
		
   return excelProgramList;
	}
}
