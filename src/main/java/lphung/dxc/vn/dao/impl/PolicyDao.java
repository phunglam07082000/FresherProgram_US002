package lphung.dxc.vn.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import lphung.dxc.vn.dao.IPolicyDao;
import lphung.dxc.vn.entity.PolicyEntity;

@Repository
public class PolicyDao implements IPolicyDao {

	@Autowired
	SessionFactory sessionFactoty;

	@Transactional
	public boolean createPolicy(PolicyEntity policy) {
		Session session = sessionFactoty.getCurrentSession();

		session.save(policy);

		return false;

	}

	@Transactional
	public List<PolicyEntity> findAll() {
		Session session = sessionFactoty.getCurrentSession();
		String sql = "from Policy";
		List<PolicyEntity> list = session.createQuery(sql).getResultList();

		return list;
	}
     @Transactional
	public PolicyEntity findById(int id) {
		Session session = sessionFactoty.getCurrentSession();
		String sql = "from Policy c where c.id=" + id;
		PolicyEntity policyEntity = (PolicyEntity) session.createQuery(sql).getSingleResult();

		return policyEntity;
	}
}
