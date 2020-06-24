package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.ProductType;
import com.example.demo.service.impl.ProductTypeServiceImpl;

@RestController
@Controller
public class ProductTypeController {

	@Autowired
	private ProductTypeServiceImpl productTypeService;

	// 添加产品类别
	@ResponseBody
	@RequestMapping(value = "/productType/add", method = RequestMethod.POST)
	public Object addProdcutType(HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		String productTypeName = req.getParameter("productTypeName").trim();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// String createTime = new Date().toString();
		// dateFormat.parse(createTime);
		ProductType productType = new ProductType();

		productType.setProductTypeName(productTypeName);

		productType.setCreateTime(new Date());

		boolean res = productTypeService.addProductType(productType);
		if (res) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "添加成功");
			return jsonObject;
		} else {
			jsonObject.put("code", 0);
			jsonObject.put("msg", "添加失败");
			return jsonObject;
		}
	}

	// 删除产品类别
	@RequestMapping(value = "/productType/delete", method = RequestMethod.GET)
	public Object deleteProductType(HttpServletRequest req) {
		String productTypeId = req.getParameter("productTypeId");
		return productTypeService.deleteProductTypeById(Long.parseLong(productTypeId));
	}

	// 返回所有产品类别
	@RequestMapping(value = "/productTypeList", method = RequestMethod.GET)
	public Object allProduct() {
		return productTypeService.allProductType();
	}

	// 更新产品类别信息
	@ResponseBody
	@RequestMapping(value = "/productType/update", method = RequestMethod.POST)
	public Object updateProductType(HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		String productTypeId = req.getParameter("productTypeId").trim();
		String productTypeName = req.getParameter("productTypeName").trim();
		String updateTimeString = req.getParameter("updateTime").trim();

		ProductType productType = new ProductType();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date updateTime = new Date();
		try {
			updateTime = dateFormat.parse(updateTimeString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		productType.setProductTypeId(Long.parseLong(productTypeId));
		productType.setProductTypeName(productTypeName);
		productType.setUpdateTime(updateTime);

		boolean res = productTypeService.updateProductType(productType);
		if (res) {
			jsonObject.put("code", 1);
			jsonObject.put("msg", "修改成功");
			return jsonObject;
		} else {
			jsonObject.put("code", 0);
			jsonObject.put("msg", "修改失败");
			return jsonObject;
		}
	}
}
