package com.fms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fms.beans.Contract;
import com.fms.repository.ContractRepository;

public class ContractDAOImpl implements ContractDAO {


	@Override
	public Boolean addContract(Contract contract) {
		
		Contract contract1=ContractRepository.contractRepo.put(contract.getContractNo(), contract);
		if(contract1 == null){
		return true;
		}
		return false;
	}

	@Override
	public Boolean deleteContract(Integer contractNo) {
		Contract contract = ContractRepository.contractRepo.remove(contractNo);
		if(contract != null) {
		return true;
		} 
		return false;
	}

	@Override
	public Contract searchContract(Integer contractNo) {
		return ContractRepository.contractRepo.get(contractNo);
		
	}



	@Override
	public List<Contract> displayAllContract() {

	
		Iterator<Entry<Integer, Contract>> iterator = ContractRepository.contractRepo.entrySet().iterator();

		List<Contract> contracts = new ArrayList<Contract>();
		
		while (iterator.hasNext()) {

			Map.Entry<Integer,Contract> pair = iterator.next();
			contracts.add((Contract)pair.getValue());
			
		}

		return contracts;
	}



}
