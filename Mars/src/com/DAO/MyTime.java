package com.DAO;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Zhiwei Qiao
 * System time
 */

public class MyTime 
{
	public String getTime()
	{
		SimpleDateFormat now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return now.format(new Date());
	}
}
