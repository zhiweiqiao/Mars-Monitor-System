package com.BLL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import com.DAL.SqlFrameDal;
import com.DAO.User;

/**
 * @author Zhiwei Qiao 
 * This class is used to query simulator database. 
 */

public class HistoryFrameBll {

	SqlFrameDal hd = new SqlFrameDal();

	public JTable getAll() throws Exception {
		String sql = "select * from Sensor"; //Return all data
		return hd.getUsers(sql);
	}
	
	public JTable getTemperature(String date1,String date2) throws Exception {
		String sql = "select No, Time, Temperature from Sensor where Time >= '" + date1 +"' and Time <= '" + date2 + "'";
		 //Return temperature
		return hd.getUsers(sql);
		}	
	
	public JTable getPressure(String date1,String date2) throws Exception {
		String sql = "select No, Time, Pressure from Sensor where Time >= '" + date1 +"' and Time <= '" + date2 + "'";
		 //Return pressure
		return hd.getUsers(sql);
		}	
	
	public JTable getHumidity(String date1,String date2) throws Exception {
		String sql = "select No, Time, Humidity from Sensor where Time >= '" + date1 +"' and Time <= '" + date2 + "'";
		 //Return humidity
		return hd.getUsers(sql);
		}	
	
	public JTable getOxygen(String date1,String date2) throws Exception {
		String sql = "select No, Time, OxygenLevel from Sensor where Time >= '" + date1 +"' and Time <= '" + date2 + "'";
		 //Return oxygen level
		return hd.getUsers(sql);
		}	
}
