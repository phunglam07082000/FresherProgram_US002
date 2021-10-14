package lphung.dxc.vn.dao;

import java.util.List;

import lphung.dxc.vn.entity.PolicyEntity;

public interface IPolicyDao {

	boolean createPolicy(PolicyEntity policy);

	List<PolicyEntity> findAll();

	PolicyEntity findById(int id);

}
