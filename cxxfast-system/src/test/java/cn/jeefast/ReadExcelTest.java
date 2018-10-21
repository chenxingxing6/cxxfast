package cn.jeefast;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import cn.jeefast.system.entity.SysUser;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Excel工具类测试
 * 
 * @author theodo
 * @email 36780272@qq.com
 * @date 2017年11月26日 上午10:40:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReadExcelTest {

    //读取单个单元格
    @Test
    public void testRead() throws Exception {
        //Excel文件
        HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:excel-templates/sysuser-info.xls")));
        //Excel工作表
        HSSFSheet sheet = wb.getSheetAt(0);

        //表头那一行
        HSSFRow titleRow = sheet.getRow(0);

        //表头那个单元格
        HSSFCell titleCell = titleRow.getCell(0);

        String title = titleCell.getStringCellValue();

        System.out.println("标题是："+title);
    }

    //读取到列表
    @Test
    public void testReadList() throws Exception {
        List<SysUser> list = new ArrayList<SysUser>();
        
        HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:excel-templates/sysuser-info.xls")));

        HSSFSheet sheet = book.getSheetAt(0);

        for(int i=2; i<sheet.getLastRowNum()+1; i++) {
            HSSFRow row = sheet.getRow(i);
            String username = row.getCell(0).getStringCellValue(); //名称
            String email = row.getCell(1).getStringCellValue(); //url
            String mobile = row.getCell(2).getStringCellValue();
            String deptName = row.getCell(3).getStringCellValue();
            //String createTime = row.getCell(4).getStringCellValue();
            
            SysUser sysUser = new SysUser();
            sysUser.setUsername(username);
            sysUser.setEmail(email);
            sysUser.setMobile(mobile);
            sysUser.setDeptName(deptName);
            //sysUser.setCreateTime(createTime);

            list.add(sysUser);
        }

        System.out.println("共有 " + list.size() + " 条数据：");
        for(SysUser user : list) {
            System.out.println(user);
        }
    }
}
