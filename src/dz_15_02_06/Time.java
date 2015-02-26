// � �������� ����� ����� ���� long. ��������� ������ ������ ��������� ���������:
// �) �������� ������� �� 1) �������� ������� 2) �� ������ ����� UNIX �� ������� �������� ���, �������, ������, ����, �����, �����. 
// ���� ������� ��� ������, �� ��������� ��������������� �������� � �������� ������� ������ � ���� �������.

package dz_15_02_06;

import java.util.Random;

public class Time {
	
	public static void main(String[] args) {

		Random rnd = new Random();
		
		long ms_in_sec = 1000l;
		long ms_in_min = 60 * ms_in_sec;
		long ms_in_hour = 60 * ms_in_min;
		long ms_in_day = 24 * ms_in_hour;
		long ms_in_week = 7 * ms_in_day;
		//long ms_in_month_avg = (long) (30.436875 * ms_in_day);  // 30.436875 ���� - ������� ����������������� ������ �� �������������� ���������
		//long ms_in_year_avg = (long) (365.2425 * ms_in_day);    // 365.2425 ���� - ������� ����������������� ���� � ������ ����������		
		
		long currT, currD, currY, currMo, currW, currH, currM, currS;
		long unixT, unixD, unixY, unixMo, unixW, unixH, unixM, unixS;
		long diffT, diffD, diffY, diffMo, diffW, diffH, diffM, diffS;
		
		int month_days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int month_days_leap[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int year, month;
		boolean isLeapYear;
		
		currT = System.currentTimeMillis();
//		System.out.println("������� �����:" + currT);
		
		// ��������� ����� � ��������� �� 50 ��� ����� �� 50 ��� ������ �� �������� �������		
		long timeT = currT + rnd.nextInt(50 * 365 * 24 * 60 * 60) * (rnd.nextBoolean() ? 1000l : -1000l);	
		timeT = currT + (373) * ms_in_day;
		System.out.println("���� �����: " + timeT);
		
// ==== �������� �� ������ ������ ������ ====
		
		diffT = timeT - currT; // ������� ����� �������� ������� � ������� �������� � �������������
		
		currD = currT / ms_in_day;
		
		// ��������������� ������������� ����, ������ � ��� � ������ ����� UNIX �� �������� �������
		year = 1970;
		isLeapYear = false;
		month = 0;
		while (currD >= (isLeapYear ? 366 : 365)) {		
			currD -= isLeapYear ? 366 : 365;
			currT -= isLeapYear ? 366 * ms_in_day : 365 * ms_in_day;
			year++;
			isLeapYear = (year % 100 != 0) ? (year % 4 == 0) : (year % 400 == 0);
		}
		currY = year - 1970;			

		while (currD >= (isLeapYear ? month_days_leap[month] : month_days[month])) {
			currD -= isLeapYear ? month_days_leap[month] : month_days[month];
			currT -= isLeapYear ? month_days_leap[month] * ms_in_day : month_days[month] * ms_in_day;
			month++;
		}
		currMo = month;

		currW = currD / 7;
		currD -= currW * 7;
		currT -= currW * ms_in_week + currD * ms_in_day;

		currH = currT / ms_in_hour;
		currT -= currH * ms_in_hour;
		currM = currT / ms_in_min;
		currT -= currM * ms_in_min;
		currS = currT / ms_in_sec;
		currT -= currS * ms_in_sec;	// � currT ������ �������� ������ ������������				

//		System.out.print("�� ������ ����� UNIX �� �������� ������� ������ ");
//		System.out.printf("%d � %d ��� %d ��� %d �� %02d � %02d � %02d �\n", currY, currMo, currW, currD, currH, currM, currS);	

		// �� �������� ������� ����������� ������ ������ � ������� �������. 
		// ����� �������� ����������, �� ����� ��� �������� ������ �� ���������.
		// ���� ����� �� ������� �� ������� �� ��� �� ���� ������, ��������� ��� ���� ������ �����.
		diffMo = 0;				
		if (diffT > 0) {

			diffS = (diffT / ms_in_sec) % 60;
			diffM = (diffT / ms_in_min) % 60;
			diffH = (diffT / ms_in_hour) % 24;

			long moRemainder, moLastDay;

			diffD = diffT / ms_in_day;
			moRemainder = (isLeapYear ? month_days_leap[month] : month_days[month]) - (currW * 7 + currD + 1);			
			diffD -= moRemainder;
			moLastDay = isLeapYear ? month_days_leap[month] : month_days[month];
			month++;
			if (month > 11) {
				month = 0;
				year++;
				isLeapYear = (year % 100 != 0) ? (year % 4 == 0) : (year % 400 == 0);
			}
			while (diffD >= (isLeapYear ? month_days_leap[month] : month_days[month])) {
				diffD -= (isLeapYear ? month_days_leap[month] : month_days[month]);
				diffT -= (isLeapYear ? month_days_leap[month] * ms_in_day : month_days[month] * ms_in_day);
				diffMo++;
				month++;
				if (month > 11) {
					month = 0;
					year++;
					isLeapYear = (year % 100 != 0) ? (year % 4 == 0) : (year % 400 == 0);
				}
			}
			
			//diffD += moRemainder;
//			if (diffD > (isLeapYear ? month_days_leap[month] : month_days[month])) {
//				diffD -= (isLeapYear ? month_days_leap[month] : month_days[month]);				
//				month++;
//				diffMo++;
//			} else {
				if (diffD >= currW * 7 + currD + 1) {
					diffD -= currW * 7 + currD + 1;
					diffMo++;
				} else {
					
				}
//			}
			
//			if (diffD == currW * 7 + currD) {
//				diffD = 0;
//				diffMo++;
//			} else if (diffD < currW * 7 + currD) {
//				diffD += moRemainder;
//			} else {
//				//??
//			}
//			
			

//			if (diffD + moRemainder == moLastDay) {
//				diffD = 0;
//				diffMo++;				
//			} else if (diffD + moRemainder < moLastDay) {
//				diffD += moRemainder;
//			} else {
//				diffD = diffD + moRemainder - moLastDay;
//				diffMo++;
//			}			
			diffW = diffD / 7;
			diffD -= diffW * 7;
			diffY = diffMo / 12;
			diffMo -= diffY * 12;
			
			System.out.print("������� ��������� � �������. �� ����� ������� ��������:\n");

		} else {

			diffT = -diffT;

			diffS = (diffT / ms_in_sec) % 60;
			diffM = (diffT / ms_in_min) % 60;
			diffH = (diffT / ms_in_hour) % 24;

			long moRemainder;

			diffD = diffT / ms_in_day;
			moRemainder = currW * 7 + currD;			
			diffD -= moRemainder;			
			month--;
			if (month < 0) {
				month = 11;
				year--;
				isLeapYear = (year % 100 != 0) ? (year % 4 == 0) : (year % 400 == 0);
			}
			while (diffD >= (isLeapYear ? month_days_leap[month] : month_days[month])) {				
				diffD -= (isLeapYear ? month_days_leap[month] : month_days[month]);				
				diffMo++;
				month--;
				if (month < 0) {
					month = 11;
					year--;
					isLeapYear = (year % 100 != 0) ? (year % 4 == 0) : (year % 400 == 0);
				}
			}			

			if (diffD - moRemainder == 0) {
				diffD = 0;
				diffMo++;				
			} else if (diffD - moRemainder < 0) {
				diffD -= moRemainder;
			} else {
				diffD = diffD - moRemainder;
				diffMo++;
			}			
			diffW = diffD / 7;
			diffD -= diffW * 7;
			diffY = diffMo / 12;
			diffMo -= diffY * 12;
			
			System.out.print("������� ��� ���������. � ���� ������� ������:\n");

		}
		
		System.out.printf("%d � %d ��� %d ��� %d �� %02d � %02d � %02d �\n", diffY, diffMo, diffW, diffD, diffH, diffM, diffS);
		
		
// ==== �������� �� ������ ������ ������ ====
		
		unixT = timeT;		
		
		// ��������������� ������������� ����, ������ � ��� � ������ ����� UNIX � ������� �������
		year = 1970;
		isLeapYear = false;
		
		if (unixT >= 1000) {
			unixD = unixT / ms_in_day;
			while (unixD >= (isLeapYear ? 366 : 365)) {		
				unixD -= isLeapYear ? 366 : 365;
				unixT -= isLeapYear ? 366 * ms_in_day : 365 * ms_in_day;
				year++;
				isLeapYear = (year % 100 != 0) ? (year % 4 == 0) : (year % 400 == 0);
			}
			unixY = year - 1970;			

			month = 0;
			while (unixD >= (isLeapYear ? month_days_leap[month] : month_days[month])) {
				unixD -= isLeapYear ? month_days_leap[month] : month_days[month];
				unixT -= isLeapYear ? month_days_leap[month] * ms_in_day : month_days[month] * ms_in_day;
				month++;
			}
			unixMo = month;

			unixW = unixD / 7;
			unixD -= unixW * 7;
			unixT -= unixW * ms_in_week + unixD * ms_in_day;

			unixH = unixT / ms_in_hour;
			unixT -= unixH * ms_in_hour;
			unixM = unixT / ms_in_min;
			unixT -= unixM * ms_in_min;
			unixS = unixT / ms_in_sec;
			unixT -= unixS * ms_in_sec;
			
			System.out.printf("�� ������ ����� UNIX �� �������:\n%d � %d ��� %d ��� %d �� %02d � %02d � %02d �\n", unixY, unixMo, unixW, unixD, unixH, unixM, unixS);
		}
		else if (unixT <= -1000) {
			unixT = -unixT;
			unixD = unixT / ms_in_day;
			while (unixD >= (isLeapYear ? 366 : 365)) {		
				unixD -= isLeapYear ? 366 : 365;
				unixT -= isLeapYear ? 366 * ms_in_day : 365 * ms_in_day;
				year--;
				isLeapYear = (year % 100 != 0) ? (year % 4 == 0) : (year % 400 == 0);
			}
			unixY = 1970 - year;			

			month = 11;
			while (unixD >= (isLeapYear ? month_days_leap[month] : month_days[month])) {
				unixD -= isLeapYear ? month_days_leap[month] : month_days[month];
				unixT -= isLeapYear ? month_days_leap[month] * ms_in_day : month_days[month] * ms_in_day;
				month--;
			}
			unixMo = 11 - month;

			unixW = unixD / 7;
			unixD -= unixW * 7;
			unixT -= unixW * ms_in_week + unixD * ms_in_day;

			unixH = unixT / ms_in_hour;
			unixT -= unixH * ms_in_hour;
			unixM = unixT / ms_in_min;
			unixT -= unixM * ms_in_min;
			unixS = unixT / ms_in_sec;
			unixT -= unixS * ms_in_sec;		
			
			System.out.printf("�� ������ ����� UNIX ��������:\n%d � %d ��� %d ��� %d �� %02d � %02d � %02d �\n", unixY, unixMo, unixW, unixD, unixH, unixM, unixS);
		}
		else {
			System.out.println("����� ������� ��������� � ������� ����� UNIX.");
		}
		


			
		
//		if (diffT >= 0) {
//			
//			long diffDays, diffD, diffY, diffMo, diffW, diffH, diffM, diffS;
//			
//			diffDays = diffT / ms_in_day;
//			if (diffDays > (isLeapYear ? month_days_leap[month] - unixW * 7 - unixD : month_days_leap[month] - unixW * 7 - unixD)) {
//				
//			}
			
			//while (diffD == 0) {
				
			//}
			
		//}
		
		
		
//		long diffT, diffS, diffM, diffH, diffD, diffW, diffMo, diffY;
//		
//		diffT = timeT - currT;
//		
//		if (diffT <= 0) {
//			System.out.print("������� ��� ���������.\n"
//					+ "� ���� ������� ������ ");
//			diffT = -diffT;
//		}
//		else {
//			System.out.print("������� ��������� � �������.\n"
//					+ "�� ����� ������� �������� ");
//		}		
//
//		
//		diffS = (diffT / ms_in_sec) % 60;
//		diffM = (diffT / ms_in_min) % 60;
//		diffH = (diffT / ms_in_hour) % 24;		
//		diffT -= diffH * ms_in_hour + diffM * ms_in_min + diffS * ms_in_sec;
//		
//		diffD = diffT / ms_in_day;
//		int year = 1970;		 
//		while (diffD >= ((year % 4) == 0 ? 366 : 365)) {
//			diffD -= (year % 4) == 0 ? 366 : 365;
//			year++;			
//		}
//		diffY = year - 1970;
//		
//		int month_days[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		int month_days_leap[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//		int month = 0;
//		System.out.println(diffD);
//		while (diffD >= ((year % 4) == 0 ? month_days_leap[month] : month_days[month])) {
//			diffD -= (year % 4) == 0 ? month_days_leap[month] : month_days[month];
//			month++;
//		}
//		diffMo = month;
//		
//		diffW = diffD / 7;
//		diffD -= diffW * 7;
//		
//		//System.out.println(diffT);
//		//System.out.printf("%d %d\n", ms_in_year, ms_in_month);
//		
////		diffY = diffT / ms_in_year;
////		diffT -= diffY * ms_in_year;  
////		diffMo = diffT / ms_in_month;
////		diffT -= diffMo * ms_in_month;
////		diffW = diffT / ms_in_week;
////		diffT -= diffW * ms_in_week;
////		diffD = diffT / ms_in_day;
//		
//		System.out.print(diffY + " � " + diffMo + " ��� " + diffW + " ��� " + diffD + " � " + diffH + " � " + diffM + " � " + diffS + " �\n");		
//		
//		diffT = timeT;
//		
//		if (diffT / 1000 == 0) {
//			System.out.print("����� ������� ��������� � ������� ����� UNIX.");
//		}
//		else {
//			if (diffT < 0) {
//				System.out.print("�� ������ ����� UNIX �������� ");
//				diffT = -diffT;
//			}
//			else {
//				System.out.print("�� ������ ����� UNIX �� ������� ");
//			}
//
//			diffS = (diffT / ms_in_sec) % 60;
//			diffM = (diffT / ms_in_min) % 60;
//			diffH = (diffT / ms_in_hour) % 24;		
//			diffT -= diffH * ms_in_hour + diffM * ms_in_min + diffS * ms_in_sec;
//
//			diffY = diffT / ms_in_year;
//			diffT -= diffY * ms_in_year;  
//			diffMo = diffT / ms_in_month;
//			diffT -= diffMo * ms_in_month;
//			diffW = diffT / ms_in_week;
//			diffT -= diffW * ms_in_week;
//			diffD = diffT / ms_in_day;
//
//			System.out.print(diffY + " � " + diffMo + " ��� " + diffW + " ��� " + diffD + " � " + diffH + " � " + diffM + " � " + diffS + " �\n");
//		}


	}
	
}
