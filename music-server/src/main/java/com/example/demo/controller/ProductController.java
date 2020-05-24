package com.example.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
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
import com.example.demo.service.impl.ProductServiceImpl;

@RestController
@Controller
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;
	
	@Configuration
	public class MyPicConfig implements WebMvcConfigurer{
		
		public void addResourceHandler(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/img/productPic/**").addResourceLocations("file:D:/EclipseWorkSpace/music-website/music-server/img/productPic/");
		}
	}
	
	
	//添加产品
	@ResponseBody
	@RequestMapping(value="/product/add", method=RequestMethod.POST)
	public Object addProduct(HttpServletRequest req) {
		
		JSONObject jsonObject = new JSONObject();
		String productId = req.getParameter("productId").trim();
		String productName = req.getParameter("productName").trim();
		String productIntro = req.getParameter("productIntro").trim();
		String productPic = req.getParameter("productPic").trim();
		
		Product product = new Product();
		product.setProductId(Long.parseLong(productId));
		product.setProductName(productName);
		product.setProductIntro(productIntro);
		product.setProductPic(productPic);
		
		boolean res = productService.addProduct(product);
		
		if(res) {
			jsonObject.put("code", 1);
			jsonObject.put("msg","添加成功");
			return jsonObject;
		}else {
			jsonObject.put("code", 0);
			jsonObject.put("msg","添加失败");
			return jsonObject;
		}
	
		
	}
	
	
	//返回所有产品
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public Object allProduct() {
		return productService.allProducts();
	}
	
	
	//返回指定id的Product
	@RequestMapping(value="/product/detail", method=RequestMethod.GET)
	public Object productOfId(HttpServletRequest req) {
		String id = req.getParameter("PRODUCT_ID");
		return productService.productOfId(Long.parseLong(id));
		
	}
	
	
	
	
	
	
	
	
	
}
