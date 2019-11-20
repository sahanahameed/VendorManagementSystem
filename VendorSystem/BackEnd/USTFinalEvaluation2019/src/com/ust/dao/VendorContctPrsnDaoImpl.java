/*------------DAO----------------*/

package com.ust.dao;

//import required packages

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.Login;
import com.ust.model.VendorContactPerson;

//Class representing VendorContctPrsnDaoImpl
public class VendorContctPrsnDaoImpl {

	/*========================= To interact with database =======================================================*/

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	/*========================  Method to Validate Username and Password ==================================*/
	public Login getUserLogin(String username, String password) {

		String sql = "select userId from tableLogin" + " where username=?" +" and password=?" ;
				return template.queryForObject(sql, new Object[] {username,password},
						new BeanPropertyRowMapper<Login>(Login.class));
		

	}

	
	
	/*============================= Method to get all Vendors ================================*/
	public List<VendorContactPerson> getAllVendors() {
		return template
				.query("select vendorId,vendorName,vendorAddress,vendorLocation,vService,vPincode,vIsActive,contactId,"
						+ "contactName,pDepartment,pEmail,pPhone,pIsActive"
						+ " from tableVendor join tablePerson using(vendorId) order by vendorId,contactId",
						new RowMapper<VendorContactPerson>() {
							public VendorContactPerson mapRow(ResultSet rs,
									int row) throws SQLException {
								VendorContactPerson objVC = new VendorContactPerson();
								objVC.setVendorId(rs.getInt(1));
								objVC.setVendorName(rs.getString(2));
								objVC.setVendorAddress(rs.getString(3));
								objVC.setVendorLocation(rs.getString(4));
								objVC.setvService(rs.getString(5));
								objVC.setvPincode(rs.getInt(6));
								objVC.setvIsActive(rs.getString(7));
								objVC.setContactId(rs.getInt(8));
								objVC.setContactName(rs.getString(9));
								objVC.setpDepartment(rs.getString(10));
								objVC.setpEmail(rs.getString(11));
								objVC.setpPhone(rs.getString(12));
								objVC.setpIsActive(rs.getString(13));
								return objVC;
							}
						});
	}

	/*========================== Method to get vendorInformation by their vendorId ==============================*/

	public List<VendorContactPerson> getVendorInfoById(int vendorId) {
		return template
				.query("select vendorId,vendorName,vendorAddress,vendorLocation,vService,vPincode,contactId,contactName,pDepartment"
						+ ",pEmail,pPhone from tableVendor join tablePerson using(vendorId) where vendorId= "
						+ vendorId + "", new RowMapper<VendorContactPerson>() {
					public VendorContactPerson mapRow(ResultSet rs, int row)
							throws SQLException {
						VendorContactPerson objVCP = new VendorContactPerson();
						objVCP.setVendorId(rs.getInt(1));
						objVCP.setVendorName(rs.getString(2));
						objVCP.setVendorAddress(rs.getString(3));
						objVCP.setVendorLocation(rs.getString(4));
						objVCP.setvService(rs.getString(5));
						objVCP.setvPincode(rs.getInt(6));
						objVCP.setContactId(rs.getInt(7));
						objVCP.setContactName(rs.getString(8));
						objVCP.setpDepartment(rs.getString(9));
						objVCP.setpEmail(rs.getString(10));
						objVCP.setpPhone(rs.getString(11));
						
						return objVCP;
					}
				});
	}

	/*============================ Method to disable vendor from tableVendor ========================== */

	public int disableVendor(int contactId) {
		String sql = "update tableVendor set vIsActive='No' where vendorId=(select vendorId"
				+ " from tablePerson where contactId=?)";
		return template.update(sql, new Object[] { contactId });
	}

	

	/*========================= Method to insert vendor and update vendor ================================*/

	public int insertVendor(VendorContactPerson objVCP) {
		String vendorStatus = "Yes";
		String sql1 = "insert into tableVendor(vendorName,vendorAddress,vendorLocation,vService,vPincode,vIsActive)"
				+ "values(?,?,?,?,?,?)";
		template.update(
				sql1,
				new Object[] { objVCP.getVendorName(),
						objVCP.getVendorAddress(), objVCP.getVendorLocation(),
						objVCP.getvService(), objVCP.getvPincode(),
						vendorStatus });

		String sql2 = "select max(vendorId) from tableVendor";
		int vendorId = template.queryForObject(sql2, Integer.class);

		String personStatus = "Yes";
		String sql3 = "insert into tablePerson(contactName,vendorId,pDepartment,pEmail,pPhone,pIsActive)"
				+ "values(?,?,?,?,?,?)";
		return template.update(
				sql3,
				new Object[] { objVCP.getContactName(), vendorId,
						objVCP.getpDepartment(), objVCP.getpEmail(),
						objVCP.getpPhone(), personStatus });
	}

	public int updateVendor(VendorContactPerson objVCP) {
		String sql = "update tableVendor set vendorName = '"
				+ objVCP.getVendorName() + "',vendorAddress = '"
				+ objVCP.getVendorAddress() + "',vendorLocation = '"
				+ objVCP.getVendorLocation() + "',vService = '"
				+ objVCP.getvService() + "',vPincode = " + objVCP.getvPincode()
				+ "" + "where vendorId = " + objVCP.getVendorId() + "";
		template.update(sql, new Object[] {});

		String sql1 = "update tablePerson set contactName = '"
				+ objVCP.getContactName() + "',pDepartment = '"
				+ objVCP.getpDepartment() + "',pEmail = '" + objVCP.getpEmail()
				+ "',pPhone = '" + objVCP.getpPhone() + "' where vendorId = "
				+ objVCP.getVendorId() + "";
		return template.update(sql1, new Object[] {});
	}

	/*=================== Method to get VendorInformation by Searching ==============================*/

	public List<VendorContactPerson> getVendorBySearch(String searchString) {
		return template
				.query("select vendorId,vendorName,vendorAddress,vendorLocation,vService,vPincode,contactId,contactName,pDepartment"
						+ ",pEmail,pPhone from tableVendor join tablePerson using(vendorId)"
						+ "where vendorLocation like'"
						+ searchString
						+ "%' or vendorName like'"
						+ searchString
						+ "%' or contactName like'"
						+ searchString
						+ "%' or vService like '" + searchString + "%'",
						new RowMapper<VendorContactPerson>() {
							public VendorContactPerson mapRow(ResultSet rs,
									int row) throws SQLException {
								VendorContactPerson objVC = new VendorContactPerson();
								objVC.setVendorId(rs.getInt(1));
								objVC.setVendorName(rs.getString(2));
								objVC.setVendorAddress(rs.getString(3));
								objVC.setVendorLocation(rs.getString(4));
								objVC.setvService(rs.getString(5));
								objVC.setvPincode(rs.getInt(6));
								
								objVC.setContactId(rs.getInt(7));
								objVC.setContactName(rs.getString(8));
								objVC.setpDepartment(rs.getString(9));
								objVC.setpEmail(rs.getString(10));
								objVC.setpPhone(rs.getString(11));
								
								return objVC;
							}
						});
	}
}
