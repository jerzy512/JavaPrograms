package program;

public class ChinChar {
	private String label;
	private String symbol;
	private String pinyin;
	private String sound;
	private String meaning;
	
	// Constructor
	
	public ChinChar(String label, String symbol, String pinyin, String sound, String meaning) {
		this.label = label;
		this.symbol = symbol;
		this.pinyin = pinyin;
		this.sound = sound;
		this.meaning = meaning;
	}
	
	final String getLabel() {
		return label;
	}
	final String getSymbol() {
		return symbol;
	}
	final String getPinyin() {
		return pinyin;
	}
	final String getSound() {
		return sound;
	}
	final String getMeaning() {
		return meaning;
	}
}
