
package tw.com.ktv.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;

import lombok.Data;

/**
 * HSSFCellStyle 對應項目 (視需求, 可再增加)
 * 
 * @author chrisryo
 * @since 2015-03-28
 */
@Data
public class HSSFCellStyleDto {

    /** 左右位置 */
    private short alignment;

    /** 上下位置 */
    private short verticalAlignment;

    /** 自動換行 */
    private boolean wrapText;

    public HSSFCellStyleDto(HSSFCellStyle style) {
        this.alignment = style.getAlignment();
        this.verticalAlignment = style.getVerticalAlignment();
        this.wrapText = style.getWrapText();
    }

    public void editHSSFCellStyle(HSSFCellStyle style, HSSFFont font) {
        style.setAlignment(this.alignment);
        style.setVerticalAlignment(this.verticalAlignment);
        style.setWrapText(this.wrapText);
        style.setFont(font);
    }
}
