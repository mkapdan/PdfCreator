package com.kaptan.document.config;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;

/**
 * 
 * This class summarize frequently used font. Characher is in Turkish Default ||
 * FontFamily is Arial Narrow || you can change font by using
 * changeFont(BaseFont base).
 * 
 * @author mustafa.kapdan
 *
 */
public class FrequentlyUsedFontStyles {

	private static String TURKISH_DOS_CHARACTER = "ibm857";
	private static String TURKISH_ISO_CHARACTER = "iso-8859-9";
	private static String TURKISH_Mac_CHARACTER = "x-mac-turkish";
	private static String TURKISH_WINDOWS_CHARACTER = "windows-1254";
	private static FontFamily ALTERNATIVE_FONT = Font.FontFamily.TIMES_ROMAN;
	public static Font TITLE;
	public static Font IMPORTANT_NOTE;
	public static Font SUB_TITLE;
	public static Font BOLD_TEXT;
	public static Font NORMAL_TEXT;
	public static Font FOOTER_TEXT;

	private FontFamily family;
	private float size; // default
	private int style; // default

	public FrequentlyUsedFontStyles(Builder builder) {
		this.family = builder.family;
		this.style = builder.style;
		this.size = builder.size;

	}

	static {
		initArial();
	}

	/**
	 * Default Arial
	 */
	private static void initArial() {
		BaseFont base = null;
		try {
			base = BaseFont.createFont("fonts/ARIALN.TTF", TURKISH_WINDOWS_CHARACTER, BaseFont.EMBEDDED);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			changeFont(base);

		}
	}

	public static void changeFont(BaseFont base) {
		if (null == base) {
			TITLE = new Font(ALTERNATIVE_FONT, 13, Font.BOLD);
			IMPORTANT_NOTE = new Font(ALTERNATIVE_FONT, 11, Font.NORMAL, BaseColor.RED);
			SUB_TITLE = new Font(ALTERNATIVE_FONT, 12, Font.BOLD);
			BOLD_TEXT = new Font(ALTERNATIVE_FONT, 11, Font.BOLD);
			NORMAL_TEXT = new Font(ALTERNATIVE_FONT, 11, Font.NORMAL);
			FOOTER_TEXT = new Font(ALTERNATIVE_FONT, 8, Font.NORMAL);
		} else {
			TITLE = new Font(base, 13, Font.BOLD);
			IMPORTANT_NOTE = new Font(base, 11, Font.NORMAL, BaseColor.RED);
			SUB_TITLE = new Font(base, 12, Font.BOLD);
			BOLD_TEXT = new Font(base, 11, Font.BOLD);
			NORMAL_TEXT = new Font(base, 11, Font.NORMAL);
			FOOTER_TEXT = new Font(base, 8, Font.NORMAL);
		}
	}

	public static class Builder {
		private final FontFamily family;
		private final float size;
		private int style = 0; // default

		public Builder(FontFamily family, float size) {
			this.family = family;
			this.size = size;
		}

		public Builder waterColor(int style) {
			this.style = style;
			return this;
		}

		public FrequentlyUsedFontStyles build() {
			return new FrequentlyUsedFontStyles(this);
		}

	}
}
