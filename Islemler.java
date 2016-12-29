package proje1;

import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.util.Stack;

import javax.swing.table.DefaultTableModel;

import javafx.scene.chart.PieChart.Data;

public class Islemler 
{
	int son=0;
	int koordinatlar[][]=new int[400][2];
	int maliyetler[][]=new int[400][400];
	AnaFrm ana;
	String sonuc="";
	int yollar[][]=new int[400][1];
	Islemler(AnaFrm a)
	{
		ana=a;
		
	}
	
	public void DugumEkle(int x,int y)
	{

		koordinatlar[son][0]=x;
		koordinatlar[son][1]=y;	
		son++;
		
	}
	
	public int kisa_bul(int baslangic)
	{
		int kisa=0;
		int uzunluk=400;
		for(int i=0;i<son;i++)
		{
			if(uzunluk>=maliyetler[baslangic][i] && i!=baslangic)
			{
				uzunluk=maliyetler[baslangic][i];
				kisa=i;
				
			}
		}
		
		return kisa;
		
				
	}
	

	public void maliyet()
	{
		
		for(int i=0;i<son;i++)
		{
			
			for(int j=i;j<son;j++)
			{
					if((koordinatlar[j]!=null && koordinatlar[i]!=null)&& i!=j)
					{
						maliyetler[i][j]=(Math.abs(koordinatlar[i][0]-koordinatlar[j][0]))+(Math.abs(koordinatlar[i][1]-koordinatlar[j][1]));
						sonuc+=maliyetler[i][j]+"  "+i+"-"+j+"\n";
					}	
			}
			
		}

		
	}
	

	public void yol()
	{
				
				ana.data=ana.data2;
				ana.table.setGridColor(Color.green);
	 
				int cizilen[]=new int[400];
				boolean donecek=true;
				
				for(int i=0;i<son;i++)
				{
					
					
						for(int j=i-1;j>=0;j--)
						{
							if(i==kisa_bul(j) && j==kisa_bul(i))
							donecek=false;
						}
											

						
						if(donecek==true)
						{
							cizilen[i]=i;
							ciz(i,kisa_bul(i));
						}
					
					donecek=true;
					
					
					
		
				}
				
				
				for(int i=son-1;i>=0;i--)
				{
             
					ana.data[koordinatlar[i][0]][koordinatlar[i][1]]="D"+i;
    	  
    	   
				}	
				
				
				
				
ana.table.setModel(new DefaultTableModel(ana.data,new String[] {"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"}
));
ana.table.setBounds(36, 33, 419, 320);
		




	}
	
	public int maliyet_hesapla()
	{
		int maliyet=0;
			for(int i=0;i<20;i++)
			{
				for(int j=0;j<20;j++)
				{
					if(ana.data[i][j]!="")
					{
						maliyet++;
					}
				}
				
			}
			
			
		return maliyet;
		
		
	}
	public void ciz(int nokta1,int nokta2)
	{
		int x,y;
		x=koordinatlar[nokta1][0]-koordinatlar[nokta2][0];
		y=koordinatlar[nokta1][1]-koordinatlar[nokta2][1];
		int xbas = 0;
		int ybas=0;
		int xson = 0;
		int yson=0;
		
		if(x<0)
		{
			xbas=koordinatlar[nokta1][0];
			xson=koordinatlar[nokta2][0];
			
			
		}
		
		if(x>0)
		{
			xbas=koordinatlar[nokta2][0];
			xson=koordinatlar[nokta1][0];
			
		}
		if(y<0)
		{
			ybas=koordinatlar[nokta1][1];
			yson=koordinatlar[nokta2][1];
			
		}
		
		if(y>0)
		{
			ybas=koordinatlar[nokta2][1];
			yson=koordinatlar[nokta1][1];
			
		}
		
		
		
		for(int i=xbas;i<=xson;i++)
		{
			ana.data[i][(koordinatlar[nokta2][1])]="X";
			
		}
		
		for(int i=ybas;i<=yson;i++)
		{
			ana.data[(koordinatlar[nokta1][0])][i]="X";
			
		}
		
	}
	
}
