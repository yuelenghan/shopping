package com.my.shopping.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import com.my.shopping.model.User;
import com.my.shopping.util.DateUtil;
import com.my.shopping.util.JsonUtil;
import com.my.shopping.util.StringUtil;

public class UserAction extends BaseAction {
	private static final long serialVersionUID = 8969001276517035826L;

	private static final Logger logger = Logger.getLogger(UserAction.class);

	private String userName;
	private String password;
	private String phone;
	private String address;
	private String start;
	private String limit;

	public String createUser() {
		for (int i = 0; i < 145; i++) {
			User user = new User();
			user.setUserName(userName + "--" + i);
			user.setPassword(password);
			user.setPhone(phone);
			user.setAddress(address);
			user.setRdate(new Date());

			long userId = 0;

			try {
				userId = userManager.createUser(user);
				if (logger.isInfoEnabled()) {
					logger.info("createUser() - long userId=" + userId); //$NON-NLS-1$
				}
			} catch (Exception e) {
				logger.error("createUser()", e);
				return "error";
			}
		}

		return "success";
	}

	public void getData() {
		int startInt = 0;
		int limitInt = 20;
		if (!StringUtil.isNullStr(start)) {
			startInt = Integer.parseInt(start);
		}
		if (!StringUtil.isNullStr(limit)) {
			limitInt = Integer.parseInt(limit);
		}
		List<User> userList = userManager.queryUser(startInt, limitInt);
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		for (User u : userList) {
			String userName = u.getUserName();
			String password = u.getPassword();
			String phone = u.getPhone();
			String date = DateUtil.dateToString(u.getRdate());

			Map<String, String> map = new HashMap<String, String>();
			map.put("userName", userName);
			map.put("password", password);
			map.put("phone", phone);
			map.put("date", date);
			resultList.add(map);
		}
		long resultCount = userManager.getUserCount();

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("resultCount", resultCount);
		resultMap.put("resultList", resultList);
		try {
			JSONObject json = JsonUtil.mapToJson(resultMap);
			this.writeJsonToWindow(json);
		} catch (JSONException e) {
			logger.error(e);
		}
	}

	public void queryUser() {
		User user = userManager.getUserByName(userName);
		if (user != null) {
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			long resultCount = userManager.getUserCount();

			String userName = user.getUserName();
			String password = user.getPassword();
			String phone = user.getPhone();
			String date = DateUtil.dateToString(user.getRdate());

			Map<String, String> map = new HashMap<String, String>();
			map.put("userName", userName);
			map.put("password", password);
			map.put("phone", phone);
			map.put("date", date);
			resultList.add(map);

			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("resultCount", resultCount);
			resultMap.put("resultList", resultList);
			try {
				JSONObject json = JsonUtil.mapToJson(resultMap);
				this.writeJsonToWindow(json);
			} catch (JSONException e) {
				logger.error(e);
			}
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

}
