package dz_15_01_23;

public class LuckyTicket {

	public static void main(String[] args) {

		int bilet = /*00*/3111;
		
		System.out.println(bilet);

		int i1, i2, i3, i4, i5, i6;
		boolean superlucky;
		String result;

		// ��������������� ���� ������ ������ - ������� � ���������
		// i1 = bilet / 100000;
		// i2 = bilet / 10000 - i1 * 10;
		// i3 = bilet / 1000 - i1 * 100 - i2 * 10;
		// i4 = bilet / 100 - i1 * 1000 - i2 * 100 - i3 * 10;
		// i5 = bilet / 10 - i1 * 10000 - i2 * 1000 - i3 * 100 - i4 * 10;
		// i6 = bilet % 10;

		// ��� �������. ������� ������ ����� ������ ��������
		i1 = (bilet / 100000) % 10;
		i2 = (bilet / 10000) % 10;
		i3 = (bilet / 1000) % 10;
		i4 = (bilet / 100) % 10;
		i5 = (bilet / 10) % 10;
		i6 = bilet % 10;

		// ����� ��������� ����������, ���� ����� ������ ������ ���� ����� ����� ������ ������
		result = (i1 + i2 + i3) == (i4 + i5 + i6) ? "����� ����������"	: "����� �� ����������";
		
		System.out.println(result);

		// ��������� ������� �����������������
		superlucky = (i1 == i2 && i1 == i3 && i1 == i4 && i1 == i5 && i1 == i6) // ���������� ���� ����
				     || ((i1 == i4) && (i2 == i5) && (i3 == i6))                // ��� ���������� ������ � ������ ������
				     || ((i1 == i6) && (i2 == i5) && (i3 == i4));               // ��� ���������� ��������� �����
		
		System.out.println(superlucky ? "...� ���� ���������������" : "");
	}

}
