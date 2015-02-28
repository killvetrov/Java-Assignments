package dz_15_02_27;

public class Mark {
	// ����� Mark ������������ ��� �������� ���������� � ���������� ������. 
	// ���� ������: long date (���� � utc), int value (�������� ������ �� 0 �� 12).
	
	private long date;
	private int value;
	
	public Mark(int value) {
		this.date = System.currentTimeMillis();
		if (value >= 0 && value <= 12)  
			this.value = value;
		else
			System.out.printf("����������� Mark(%d) - ���������� ��������� �������� ������.%n", value);
	}
	
	public long getDate() { 
		return date; 
	}
	
	public void setDate(long date) {
		this.date = date;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		if (value >= 0 && value <= 12)  
			this.value = value;
		else
			System.out.printf("Mark.setValue(%d) - ���������� ��������� �������� ������.%n", value);
	}	
	
}
