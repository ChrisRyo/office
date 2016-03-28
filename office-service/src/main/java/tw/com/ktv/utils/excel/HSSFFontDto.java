package tw.com.ktv.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFFont;

import lombok.Data;

/**
 * HSSFFont 對應項目 (視需求, 可再增加)
 * 
 * @author chrisryo
 * @since 2015-03-28
 */
@Data
public class HSSFFontDto {

    /** 字體 */
    private String fontName;

    /** 字體大小 */
    private short fontHeightInPoints;

    /** 字體粗細 */
    private short boldweight;

    /** 字體顏色 */
    private short color;

    public HSSFFontDto(HSSFFont font) {
        this.fontName = font.getFontName();
        this.fontHeightInPoints = font.getFontHeightInPoints();
        this.boldweight = font.getBoldweight();
        this.color = font.getColor();
    }
    
    public void editHSSFFont(HSSFFont font) {
        font.setFontName(this.fontName);
        font.setFontHeightInPoints(this.fontHeightInPoints);
        font.setBoldweight(this.boldweight);
        font.setColor(this.color);
    }
}