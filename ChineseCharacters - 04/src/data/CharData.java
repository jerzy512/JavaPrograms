package data;

public class CharData {
	private String theChar;
	private String pinyin;
	private String meaning;
	
	
	public CharData(String theChar, String pinyin, String meaning) {
		this.theChar = theChar;
		this.pinyin = pinyin;
		this.meaning = meaning;
	}
	
	public String getTheChar() {
		return theChar;
	}
	public void setTheChar(String theChar) {
		this.theChar = theChar;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
}
