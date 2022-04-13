package com.subho.entities;

import java.lang.reflect.Field;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.subho.annotation.processor.ODataInterface;
import com.subho.service.IVendorPersistence;

@Slf4j
public class VendorODataAgent implements ODataInterface {

	@Autowired
	IVendorPersistence vendorAPI;

	@Override
	public List<?> getEntitySet() {
		// TODO Auto-generated method stub
		System.out.println("VendorSet_GET_ENTITYSET called");
		return vendorAPI.findAll();
	}

	@Override
	public Object getEntity(Map<String, ?> keys) {
		// TODO Auto-generated method stub
		System.out.println("VendorSet_GET_ENTITY called");
		return vendorAPI.findById((Long) keys.get("id")).get();
	}

	@Override
	public List<?> getRelatedEntity(Object source, String relatedEntityName, Map<String, Object> keys,
			Field sourceField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEntity(Object dataToCreate) {
		// TODO Auto-generated method stub
		System.out.println("VendorSet_CREATE_ENTITY called");
		vendorAPI.save((Vendor) dataToCreate);
	}

	@Override
	public void deleteEntity(Map<String, ?> keys) {
		// TODO Auto-generated method stub
		System.out.println("VendorSet_DELETE_ENTITY called");
//		vendorAPI.deleteById((String)keys.get("id"));
		System.out.println("deleteEntity called");
		Long id = (Long)keys.get("Id");
		vendorAPI.deleteById(id);
		}

	@Override
	public void updateEntity(Object dataToUpdate) {
		// TODO Auto-generated method stub
		System.out.println("VendorSet_UPDATE_ENTITY called");
		vendorAPI.save((Vendor) dataToUpdate);
	}

}
