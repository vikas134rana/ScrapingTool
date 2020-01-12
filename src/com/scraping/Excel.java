package com.scraping;

public class Excel {

	/*-private XSSFWorkbook wb = null;
	private XSSFSheet sheet = null;

	List<String> columnHeaders = new ArrayList<String>(Arrays.asList("INFO", "ADDRESS", "PHONE", "WEBSITE"));

	public static void main(String[] args) throws IOException {
		List<Data> list = App.finalDataList;
		list.add(new Data());
		list.add(new Data());
		list.add(new Data());
		new Excel().createExcelWithData();
	}

	public void createExcelWithData() throws IOException {

		File excelFile = File.createTempFile("Data", ".xlsx");
		System.out.println(excelFile.getAbsolutePath());

		wb = new XSSFWorkbook();
		sheet = wb.createSheet();

		String rangeValue = "A2:D" + App.finalDataList.size()+1;
		System.out.println(rangeValue);
		
		setBorderWithRange(rangeValue);

		rangeValue = "A1:D1";

		setCornerBorderWithRange(rangeValue);
		System.out.println("Border set with Range: " + rangeValue);

		setBackgroundColorWithRange(rangeValue);
		setForeColorWithRange(rangeValue);
		System.out.println("BackGround Color set with Range: " + rangeValue);

		insertColumnHeader();
		System.out.println("Header is added inside excel");
//		
//		insertData();
//		System.out.println("Data is added inside excel");

		System.out.println("Excel file is created : " + excelFile.getAbsolutePath());

		try (FileOutputStream outputStream = new FileOutputStream(excelFile.getAbsolutePath())) {
			wb.write(outputStream);
		}

		wb.close();
	}

	private void insertColumnHeader() {

		Row headerRow = getOrCreateRow(0);
		for (int i = 0; i < columnHeaders.size(); i++) {
			String data = columnHeaders.get(i);
			getOrCreateCell(headerRow, i).setCellValue(data);
		}
	}

	private void insertData() {
		for (int i = 0; i < App.finalDataList.size(); i++) {
			Data data = App.finalDataList.get(i);

			XSSFRow row = sheet.createRow(i + 1);
			row.createCell(0).setCellValue(data.getInfo());
			row.createCell(1).setCellValue(data.getAddress());
			row.createCell(2).setCellValue(data.getPhone());
			row.createCell(3).setCellValue(data.getWebsite());
		}
	}

	private void setCornerBorderWithRange(String range) {
		CellRangeAddress region = CellRangeAddress.valueOf(range);
		BorderStyle borderStyle = BorderStyle.MEDIUM;
		RegionUtil.setBorderBottom(borderStyle, region, sheet);
		RegionUtil.setBorderTop(borderStyle, region, sheet);
		RegionUtil.setBorderLeft(borderStyle, region, sheet);
		RegionUtil.setBorderRight(borderStyle, region, sheet);
	}

	private void setBorderWithRange(String range) {
		CellRangeAddress region = CellRangeAddress.valueOf(range);
		BorderStyle borderStyle = BorderStyle.MEDIUM;

		for (int r = region.getFirstRow(); r <= region.getLastRow(); r++) {
			for (int c = region.getFirstColumn(); c <= region.getLastColumn(); c++) {

				Row row = getOrCreateRow(r);
				Cell cell = getOrCreateCell(row, c);
				CellStyle cellStyle = cell.getCellStyle();

				cellStyle.setBorderBottom(borderStyle);
				cellStyle.setBorderTop(borderStyle);
				cellStyle.setBorderRight(borderStyle);
				cellStyle.setBorderLeft(borderStyle);
				cell.setCellStyle(cellStyle);
			}
		}
	}

	private void setBackgroundColorWithRange(String range) {
		CellRangeAddress region = CellRangeAddress.valueOf(range);

		for (int r = region.getFirstRow(); r <= region.getLastRow(); r++) {
			for (int c = region.getFirstColumn(); c <= region.getLastColumn(); c++) {

				XSSFRow row = sheet.getRow(r) == null ? sheet.createRow(r) : sheet.getRow(r);
				Cell cell = row.getCell(c) == null ? row.createCell(c) : row.getCell(c);
				CellStyle style = cell.getCellStyle();
//				Setting Background color
				style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
				style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
				cell.setCellStyle(style);
			}
		}
	}

	private void setForeColorWithRange(String range) {
		CellRangeAddress region = CellRangeAddress.valueOf(range);

		for (int r = region.getFirstRow(); r <= region.getLastRow(); r++) {
			for (int c = region.getFirstColumn(); c <= region.getLastColumn(); c++) {

				XSSFRow row = sheet.getRow(r) == null ? sheet.createRow(r) : sheet.getRow(r);
				Cell cell = row.getCell(c) == null ? row.createCell(c) : row.getCell(c);
				CellStyle style = cell.getCellStyle();
//				Setting Background color
				Font font = wb.createFont();
				font.setColor(IndexedColors.WHITE.getIndex());
				style.setFont(font);
				cell.setCellStyle(style);
			}
		}
	}

	private Row getOrCreateRow(int rowNum) {
		return sheet.getRow(rowNum) == null ? sheet.createRow(rowNum) : sheet.getRow(rowNum);
	}

	private Cell getOrCreateCell(Row row, int cellNum) {
		return row.getCell(cellNum) == null ? row.createCell(cellNum) : row.getCell(cellNum);
	} */
    
}
