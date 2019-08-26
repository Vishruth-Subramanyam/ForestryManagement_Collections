package com.fms.dao;

import java.util.List;

import com.fms.beans.Haulier;

public interface HaulierDAO {
	public Boolean addHaulier(Haulier haulier);
	public Boolean deleteHaulier(Integer haulierId);
	public Haulier searchHaulier(Integer haulierId);
	public List<Haulier> displayAllHaulier();
	

}
