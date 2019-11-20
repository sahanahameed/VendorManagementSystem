/*---------CONTROLLER--------------*/

package com.ust.controller;

//import required packages
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.VendorContctPrsnDaoImpl;

import com.ust.model.Login;
import com.ust.model.VendorContactPerson;

@RestController
public class VendorContctPrsnController {

	@Autowired
	VendorContctPrsnDaoImpl objVCDao;

	/*====================== Login method ========================================*/
	
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	public Login getUserLogin(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return objVCDao.getUserLogin(username, password);
	}

	/*========================== Method to display all the Vendors ==================================*/

	@RequestMapping(value = "/api/vendors", method = RequestMethod.GET)
	public List<VendorContactPerson> getAllVendors() {
		List vendorList = objVCDao.getAllVendors();
		return vendorList;
	}

	/*==================  Method to insert Vendor and update Vendor  =================================*/

	@RequestMapping(value = "/api/saveVendor", method = { RequestMethod.POST,
			RequestMethod.PUT })
	public void saveVendor(@RequestBody VendorContactPerson objVC) {
		if (objVC.getVendorId() != 0) {
			objVCDao.updateVendor(objVC);
		} else {
			objVCDao.insertVendor(objVC);
		}
	}

	/*=======================Method to get Vendor by corresponding id ==========================================================*/

	@RequestMapping(value = "/api/getVendor/{vendorId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public VendorContactPerson getVendorInfoById(
			@ModelAttribute("objVendr") VendorContactPerson objVendr,
			@PathVariable("vendorId") int vendorId) {
		List list = objVCDao.getVendorInfoById(vendorId);
		objVendr=(VendorContactPerson) list.get(0);
		return objVendr;
	}

	/*======================  Method to search vendor  ===========================================================*/

	@RequestMapping(value = "/api/vendor/{searchString}", method = RequestMethod.GET)
	public List<VendorContactPerson> getVendorBySearch(
			@PathVariable("searchString") String searchString) {
		List list = objVCDao.getVendorBySearch(searchString);
		return list;
	}

	/*======================== Method to disable vendor by vendorId ========================================================= */

	@RequestMapping(value = "/api/disableVendor/{vendorId}", method = RequestMethod.PUT)
	void disableVendor(@PathVariable("vendorId") int vendorId) {
		objVCDao.disableVendor(vendorId);
	}
}
