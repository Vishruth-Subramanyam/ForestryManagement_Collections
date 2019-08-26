package com.fms.dao;

import java.util.List;

import com.fms.beans.Contract;

public interface ContractDAO {
	public Boolean addContract(Contract contract);
	public Boolean deleteContract(Integer contractNo);
	public Contract searchContract(Integer contractNo);
	public List<Contract> displayAllContract();

}
