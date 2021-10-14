package lphung.dxc.vn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lphung.dxc.vn.dao.IPolicyDao;
import lphung.dxc.vn.entity.PolicyEntity;
import lphung.dxc.vn.service.IPolicyService;

@Service
public class PolicyService implements IPolicyService {

	@Autowired
	private IPolicyDao policyDao;

	public boolean createPolicy(PolicyEntity policy) {
		// TODO Auto-generated method stub
		return policyDao.createPolicy(policy);
	}

	public List<PolicyEntity> findAll() {

		return policyDao.findAll();
	}

	public PolicyEntity findById(int id) {

		return policyDao.findById(id);
	}

}
