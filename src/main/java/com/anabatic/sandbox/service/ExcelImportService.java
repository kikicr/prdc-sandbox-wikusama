package com.anabatic.sandbox.service;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface ExcelImportService {
	public List<Map<String,Object>> getMapListFromSheet(InputStream in,int sheet);
}
