package lphung.dxc.vn.service;

import java.util.List;

import lphung.dxc.vn.entity.PolicyEntity;

public interface IPolicyService {

	boolean createPolicy(PolicyEntity policy);

	List<PolicyEntity> findAll();

	PolicyEntity findById(int id);

}
