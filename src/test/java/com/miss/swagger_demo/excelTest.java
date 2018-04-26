package com.miss.swagger_demo;

import com.miss.swagger_demo.utils.Excel2Html;
import com.miss.swagger_demo.utils.OpenOfficeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author miss
 * <p>
 * Created by miss on 2018/4/24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class excelTest {
    private static final Logger logger = LoggerFactory.getLogger(excelTest.class);

    @Test
    public void excel2pdf()
    {
        String infilePath = "F:\\FILES\\define\\test.xls";
        String outfilePath = "F:\\FILES\\define\\testdefine.pdf";

        try {
            OpenOfficeUtils.convert(infilePath, outfilePath);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Test
    public void excel2html()
        {
        String infilePath = "F:\\FILES\\define\\test.xls";
        String outfilePath = "F:\\FILES\\define\\testhtmlfalse.html";
        String filepath = Excel2Html.readExcelToHtml(infilePath,outfilePath,false);
        logger.info(filepath);
    }
}
