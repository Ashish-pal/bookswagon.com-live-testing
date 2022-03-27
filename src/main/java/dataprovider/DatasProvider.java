package dataprovider;

import org.testng.annotations.DataProvider;

import utilities.Excel;

public class DatasProvider {

	Excel exobj = new Excel();
	@DataProvider(name = "credentialData")
	public Object[][] getData(){
		int rows = exobj.getRowCount("Sheet1");
		int columns = exobj.getColumnCount("Sheet1");
		int actualrows = rows - 1;
		Object[][] data = new Object[actualrows][columns];
		for(int i=0;i<actualrows;i++) {
			for(int j=0;j<columns;j++) {
				data[i][j] = exobj.getCellData("Sheet1", j, i+2);
			}
		}
		return data;
	}
}
