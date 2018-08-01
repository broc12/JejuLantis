package com.khd.jejulantis.admin.insurance.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khd.jejulantis.admin.insurance.DAO.InsuranceDao;
import com.khd.jejulantis.model.Insurance;
@Service("insuranceService")
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	InsuranceDao InsuranceDao;
	@Override
	public List<Insurance> insuranceListService(String manager_id) {
		return InsuranceDao.insuranceList(manager_id);
	}
	@Override
	public List<Insurance> insuranceContentService(int insurance_no) {
		return InsuranceDao.insuranceContent(insurance_no);
	}
	@Override
	public void deleteService(int insurance_no) {
		InsuranceDao.insuranceDUpdate(insurance_no);
	}
	@Override
	public void insertService(Insurance insurance) {
		InsuranceDao.insuranceInsert(insurance);
	}
	@Override
	public void updateService(Insurance insurance) {
		InsuranceDao.insuranceUpdate(insurance);
	}
	@Override
	public List<Insurance> carKindSelectBoxService(String manager_id) {
		return InsuranceDao.carKindSelectBox(manager_id);
	}
	@Override
	public List<Insurance> branchNoSelectService(String manager_id) {
		return InsuranceDao.branchNoSelect(manager_id);
	}
}