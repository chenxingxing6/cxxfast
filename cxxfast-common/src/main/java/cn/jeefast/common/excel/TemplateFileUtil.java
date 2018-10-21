package cn.jeefast.common.excel;

import org.springframework.util.ResourceUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Excel工具类
 * 
 * @author theodo
 * @email 36780272@qq.com
 * @date 2017年11月26日 上午10:40:10
 */
public class TemplateFileUtil {

    public static FileInputStream getTemplates(String tempName) throws FileNotFoundException {
        return new FileInputStream(ResourceUtils.getFile("classpath:excel-templates/"+tempName));
    }
}
