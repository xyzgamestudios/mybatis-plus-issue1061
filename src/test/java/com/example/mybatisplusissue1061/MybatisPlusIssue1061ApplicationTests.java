package com.example.mybatisplusissue1061;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusissue1061.entity.Admin;
import com.example.mybatisplusissue1061.mapper.AdminMapper;
import com.example.mybatisplusissue1061.utils.EncryptionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusIssue1061ApplicationTests {

    @Resource
    private AdminMapper mapper;

    @Test
    public void testPageData() {
        Page<Admin> page = new Page<>(1, 10);

        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Admin::getUsername, "a");

        IPage<Admin> adminIPage = mapper.selectPage(page, queryWrapper);
        System.out.println(adminIPage.getRecords());
    }

    @Test
    public void testSave() {
        Admin admin = new Admin();
        admin.setAdminId(IdUtil.fastSimpleUUID());
        admin.setUsername("admin");
        String salt = IdUtil.simpleUUID();
        admin.setSalt(salt);
        admin.setPassword(EncryptionUtils.sha256Hex("123456", salt));

        mapper.insert(admin);
    }

}
