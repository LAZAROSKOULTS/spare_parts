package my;
import java.util.ArrayList;

/*
 * ������� ��� �������� ����� ���� ��������� ��������������� ��������� ��������������,
 *  �� ������ ������������� ��� ����������� �� ���� �� ��������� ��� ���������
 *  ��� ��� ������������� ��� �����������. 
 *  ��� ���� ������-��������� ��������� �� �������� ��������:
 *  ����� ����������, ������������� ���, ���������, ����� ���������,
 *  �������� ��� ����� �������� ��� ����������.
 *  � ������� ���� �� �������� ������������ ������������ ��� ������ � ����������� �� ������������ ���,
 *  �������� ��� ������������� � ����������.
 */
public class Customer {
	private String Workshop_Name;
	private double afm;
	private String address; //�� �����; e-mail � �������� ���������;
	private String PartinentName; ///WTF?
	private int phone;// ������ ��� String �� ����� �� ������� ������ (+30)...
	private ArrayList<String> CoopCompanies;//���� ������ �� ������������� ��� ����� ������� �� ���� ������ �� id ��� ������..
	

	public Customer(String name,double afm,String address,String PartinentName,int phone,ArrayList<String> CoopCompanies) {
		Workshop_Name=name;
		this.afm=afm;
		this.address=address;
		this.PartinentName = PartinentName;
		this.phone = phone;
		this.CoopCompanies = new ArrayList<String>();
		
		for(String cop : CoopCompanies){
			CoopCompanies.add(cop);
		}
		
	}

	
	
}
