package info.unbelievable9.shiro.demo.service;

import info.unbelievable9.shiro.demo.dao.SysPermissionDao;
import info.unbelievable9.shiro.demo.dao.SysPermissionDaoImpl;
import info.unbelievable9.shiro.demo.entity.SysPermission;

/**
 * Created on : 2018/7/11
 * Author     : Unbelievable9
 **/
public class SysPermissionServiceImpl implements SysPermissionService {

    private SysPermissionDao sysPermissionDao = new SysPermissionDaoImpl();

    @Override
    public SysPermission createSysPermission(SysPermission sysPermission) {
        return sysPermissionDao.createSysPermission(sysPermission);
    }

    @Override
    public void deleteSysPermission(Long sysPermissionId) {
        sysPermissionDao.deleteSysPermission(sysPermissionId);
    }
}
