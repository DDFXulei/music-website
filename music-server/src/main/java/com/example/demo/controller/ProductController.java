package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.domain.Product;
import com.example.demo.domain.Singer;
import com.example.demo.service.impl.ProductServiceImpl;

@RestController
@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@Configuration
	public class MyProductConfig implements WebMvcConfigurer {
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/img/productPic/**")
					.addResourceLocations("file:"+System.getProperty("user.dir")+"/img/productPic/");
		}
	}

	// 添加产品
	@ResponseBody
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public Object addProduct(HttpServletRequest req) {

		JSONObject jsonObject = new JSONObject();
		String productId = req.getParameter("productId").trim();
		String productName = req.getParameter("productName").trim();
		String productTitle = req.getParameter("productTitle").trim();
		String productIntro = req.getParameter("productIntro").trim();
		String productTypeId = req.getParameter("productTypeId").trim();

		Product product = new Product();
		product.setProductId(Long.parseLong(productId));
		product.setProductName(productName);
		product.setProductIntro(productIntro);
		product.setProductTypeId(Long.parseLong(productTypeId));

		boolean res = productService.addProduct(product);

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

	// 更新产品头像
	@ResponseBody
	@RequestMapping(value = "/product/avatar/update", method = RequestMethod.POST)
	public Object updateProductPic(@RequestParam("file") MultipartFile avatorFile,
			@RequestParam("productId") Long productId) {
		JSONObject jsonObject = new JSONObject();

		if (avatorFile.isEmpty()) {
			jsonObject.put("code", 0);
			jsonObject.put("message", "文件上传失败");
			return jsonObject;
		}
		String fileName = System.currentTimeMillis() + avatorFile.getOriginalFilename();
		String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
				+ System.getProperty("file.separator") + "productPic";
		File file1 = new File(filePath);
		if (!file1.exists()) {
			file1.mkdir();
		}

		File dest = new File(filePath + System.getProperty("file.separator") + fileName);
		String storeAvatorPath = "/img/productPic/" + fileName;
		try {
			avatorFile.transferTo(dest);
			Product product = new Product();
			product.setProductId(productId);
			product.setProductPic(storeAvatorPath);
			boolean res = productService.updateProductPic(product);
			if (res) {
				jsonObject.put("code", 1);
				jsonObject.put("pic", storeAvatorPath);
				jsonObject.put("msg", "上传成功");
				return jsonObject;
			} else {
				jsonObject.put("code", 0);
				jsonObject.put("msg", "上传失败");
				return jsonObject;
			}

		} catch (IOException e) {
			jsonObject.put("code", 0);
			jsonObject.put("msg", "上传失败" + e.getMessage());
			return jsonObject;
		} finally {
			return jsonObject;
		}

	}

	// 更新产品参数图片
	@ResponseBody
	@RequestMapping(value = "/product/param/update", method = RequestMethod.POST)
	public Object updateProductParam(@RequestParam("file") MultipartFile avatorFile,
			@RequestParam("productId") Long productId) {
		JSONObject jsonObject = new JSONObject();

		if (avatorFile.isEmpty()) {
			jsonObject.put("code", 0);
			jsonObject.put("message", "文件上传失败");
			return jsonObject;
		}
		String fileName = System.currentTimeMillis() + avatorFile.getOriginalFilename();
		String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img"
				+ System.getProperty("file.separator") + "productPic/param/";
		File file1 = new File(filePath);
		if (!file1.exists()) {
			file1.mkdir();
		}

		File dest = new File(filePath + System.getProperty("file.separator") + fileName);
		String storeAvatorPath = "/img/productPic/param/" + fileName;
		try {
			avatorFile.transferTo(dest);
			Product product = new Product();
			product.setProductId(productId);
			product.setProductParam(storeAvatorPath);
			boolean res = productService.updateProductParam(product);
			if (res) {
				jsonObject.put("code", 1);
				jsonObject.put("pic", storeAvatorPath);
				jsonObject.put("msg", "上传成功");
				return jsonObject;
			} else {
				jsonObject.put("code", 0);
				jsonObject.put("msg", "上传失败");
				return jsonObject;
			}

		} catch (IOException e) {
			jsonObject.put("code", 0);
			jsonObject.put("msg", "上传失败" + e.getMessage());
			return jsonObject;
		} finally {
			return jsonObject;
		}

	}

	// 返回所有产品
	@RequestMapping(value = "/productList", method = RequestMethod.GET)
	public Object allProducts() {
		return productService.allProducts();
	}

	// 更新产品信息
	@ResponseBody
	@RequestMapping(value = "/product/update", method = RequestMethod.POST)
	public Object updateSingerMsg(HttpServletRequest req) {
		JSONObject jsonObject = new JSONObject();
		String productId = req.getParameter("productId").trim();
		String productName = req.getParameter("productName").trim();
		String productTitle = req.getParameter("productTitle").trim();
		String productTypeId = req.getParameter("productTypeId").trim();
		String productIntro = req.getParameter("productIntro").trim();
		Product product = new Product();
		Date updateTime = new Date();
		product.setProductId(Long.parseLong(productId));
		product.setProductName(productName);
		product.setProductTitle(productTitle);
		product.setProductTypeId(Long.parseLong(productTypeId));
		product.setProductIntro(productIntro);
		product.setUpdateTime(updateTime);
		
		boolean res = productService.updateProduct(product);
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

	// 返回指定id的Product
	@RequestMapping(value = "/product/detail", method = RequestMethod.GET)
	public Object productOfId(HttpServletRequest req) {
		String id = req.getParameter("productId");
		return productService.productOfId(Long.parseLong(id));

	}

	// 返回指定标题对应的Product
	@RequestMapping(value = "/productList/likeName/detail", method = RequestMethod.GET)
	public Object productListOfName(HttpServletRequest req) {
		String productName = req.getParameter("productName").trim();
		return productService.productOfName('%' + productName + '%');
	}

	// 返回指定类型的产品
	@RequestMapping(value = "/productList/type/detail", method = RequestMethod.GET)
	public Object songListOfStyle(HttpServletRequest req) {
		String productType = req.getParameter("productType").trim();
		return productService.productOfType(Long.parseLong(productType));
	}

	// 删除歌手
	@RequestMapping(value = "/product/delete", method = RequestMethod.GET)
	public Object deleteSinger(HttpServletRequest req) {
		String productId = req.getParameter("productId");
		return productService.deleteProduct(Long.parseLong(productId));
	}

}
