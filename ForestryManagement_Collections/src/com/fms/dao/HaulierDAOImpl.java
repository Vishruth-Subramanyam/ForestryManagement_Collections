package com.fms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fms.beans.Haulier;
import com.fms.repository.HaulierRepository;

public class HaulierDAOImpl implements HaulierDAO{

	

	@Override
	public Boolean addHaulier(Haulier haulier) {

		Haulier haulier1=HaulierRepository.haulierRepo.put(haulier.getHaulierId(), haulier);
		if(haulier1 == null){
		return true;
		}
		return false;
	}

	@Override
	public Boolean deleteHaulier(Integer haulierId) {
		Haulier haulier = HaulierRepository.haulierRepo.remove(haulierId);
		if(haulier != null) {
		return true;
		} 
		return false;
	}

	@Override
	public Haulier searchHaulier(Integer haulierId) {
		return HaulierRepository.haulierRepo.get(haulierId);
	}

	@Override
	public List<Haulier> displayAllHaulier() {
		
		Iterator<Entry<Integer, Haulier>> iterator = HaulierRepository.haulierRepo.entrySet().iterator();
		List<Haulier> hauliers = new ArrayList<Haulier>();
		
		while (iterator.hasNext()) {

			Map.Entry<Integer,Haulier> pair = iterator.next();
			hauliers.add((Haulier)pair.getValue());
			

		}

		return hauliers;
		
	}

}
