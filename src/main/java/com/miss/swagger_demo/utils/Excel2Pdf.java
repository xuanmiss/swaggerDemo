package com.miss.swagger_demo.utils;




import com.aspose.cells.License;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


/**
 * @author miss
 * <p>
 * Created by miss on 2018/5/3
 */
public class Excel2Pdf {



    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = Excel2Pdf.class.getClassLoader().getResourceAsStream("license.xml");

            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 支持DOC, DOCX, OOXML, RTF, HTML, OpenDocument, PDF, EPUB, XPS, SWF等相互转换<br>
     *
     * @param args
     */
    public static void main(String[] args) {
        // 验证License
        if (!getLicense()) {
            return;
        }

        try {
            long old = System.currentTimeMillis();
            Workbook wb = new Workbook("F:\\FILES\\define\\test.xls");// 原始excel路径
            File pdfFile = new File("F:\\FILES\\define\\0508test.pdf");// 输出路径
            FileOutputStream fileOS = new FileOutputStream(pdfFile);

            wb.save(fileOS, SaveFormat.PDF);

            long now = System.currentTimeMillis();
            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) {
//        String address = "F:\\FILES\\define\\test.xls";
//        try {
//            File pdfFile = new File("F:\\FILES\\define\\0503.pdf");// 输出路径
//            Workbook wb = new Workbook(address);// 原始excel路径
//            FileOutputStream fileOS = new FileOutputStream(pdfFile);
//            wb.save(fileOS, SaveFormat.PDF);
//            fileOS.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}
