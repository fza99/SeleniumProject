package newpackage;
import java.io.File;
// Needed to make Selenium work with Excel
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class Parameters {
	
    // You can change the information of your data file here
    public static final String FILE_PATH = "C:\\Users\\HP\\eclipse\\SeleniumProjrct//testData.xls"; // File Path
    public static final String SHEET_NAME = "Data"; // Sheet name
    public static final String TABLE_NAME = "testData"; // Name of data table

    public static final int WAIT_TIME = 30; // Delay time to wait the website
					    // launch completely
    public static final String BASE_URL = "http://www.demo.guru99.com/";

    // Expected output
    public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
    public static final String EXPECT_ERROR = "User or Password is not valid";
	public static final String EXPECT_URL = "https://www.demo.guru99.com/V4/manager/Managerhomepage.php";

    /* You can change the Path of FireFox base on your environment here */
    public static final String FIREFOX_PATH = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";


    public static String[][] getDataFromExcel(String FILE_PATHth,
    		
		String sheetName, String tableName) throws Exception {
		// Declare a 2 dimensions array to store all the test data read from
		// excel
		String[][] tabArray = null;

		// get the workbook file. Provide the path of excel file
		Workbook workbook = Workbook.getWorkbook(new File(FILE_PATH));
		// get the sheet name
		Sheet sheet = workbook.getSheet(SHEET_NAME);

		int startRow, startCol, endRow, endCol, ci, cj;

		// find cell position which contain first appear table name
		Cell tableStart = sheet.findCell(TABLE_NAME);
		// Row position of FIRST appear table name
		startRow = tableStart.getRow();
		// Col position of FIRST appear table name
		startCol = tableStart.getColumn();

		// find cell position which contain last appear table name
		Cell tableEnd = sheet.findCell(TABLE_NAME, startCol + 1, startRow + 1,
				100, 64000, false);
		// Row position of LAST appear table name
		endRow = tableEnd.getRow();
		// Col position of LAST appear table name
		endCol = tableEnd.getColumn();

		tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
		ci = 0;

		// Store all data in an array
		for (int i = startRow + 1; i < endRow; i++, ci++) {
			cj = 0;
			for (int j = startCol + 1; j < endCol; j++, cj++) {
				//Get content of each cell and store to each array element.
				tabArray[ci][cj] = sheet.getCell(j, i).getContents();
			}
		}

		return (tabArray);
	}


}
