package joseph.review.collector.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import joseph.review.collector.dto.ItemInfo;
import joseph.review.collector.dto.ItemResponse;

public class ExcelUtil {

	private static final Logger LOGGER = Logger.getLogger(ExcelUtil.class.getName());
	
	public void writeToExcel(String[] columns, List<ItemResponse> itemsInfo) throws Exception {
		Workbook workbook = new XSSFWorkbook();
		CreationHelper createHelper = workbook.getCreationHelper();

        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));

        Sheet sheet = workbook.createSheet("Employee");
        Font headerFont = createHeaderFont(workbook);
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        Row headerRow = sheet.createRow(0);

        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(ItemResponse itemInfo: itemsInfo) {
        	for(ItemInfo info : itemInfo.getItems()) {
	            Row row = sheet.createRow(rowNum++);
	
	            row.createCell(0).setCellValue(info.getName());
	            row.createCell(1).setCellValue(info.getCustomerRating());
	
	            /* How to set date of birth cell:
	            Cell dateOfBirthCell = row.createCell(2);
	            dateOfBirthCell.setCellValue(employee.getDateOfBirth());
	            dateOfBirthCell.setCellStyle(dateCellStyle);
	            */
        	}
        }

        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("GeneratedReport.xlsx");
	        workbook.write(fileOut);
	        fileOut.close();
	        workbook.close();
		} catch (FileNotFoundException e) {
			String errorMsg = "FileNotFoundException when trying to open file output stream ";
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw new Exception(errorMsg, e);
		} catch (IOException e) {
			String errorMsg = "IOException when trying to write/close file";
			LOGGER.log(Level.SEVERE, errorMsg, e);
			throw new Exception(errorMsg, e);
		}

	}
	
	private Font createHeaderFont(Workbook workbook) {
		Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());
        return headerFont;
	}

}
