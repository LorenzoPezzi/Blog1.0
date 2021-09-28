package com.generation.util;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * Class Date:
 * represents a Date
 * (day, month, year)  
 * @author FP80
 * @lastupdated 31/08/2021
 *
 */
public class Date 
{
	public static Date today = null;
	static {
		today = new Date(Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
                Calendar.getInstance().get(Calendar.MONTH)+1,
                Calendar.getInstance().get(Calendar.YEAR));
	}
	
	
	public static Set<Date> CREATED = new HashSet<Date>();
	static {
		CREATED.add(today);
	}
	private Date(String dataS) {
		if(dataS==null)
			throw new RuntimeException("Cannot work on null string");
		if(dataS.length() > 10)
			throw new RuntimeException("Stringa con lunghezza non valida");
		
		
		String[] parts = dataS.split("/");
		

		try {

			
			int g = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			int a = Integer.parseInt(parts[2]);
			
			if(parts[0].length() != 2)
				throw new RuntimeException("lunghezza giorno non valida");
			if(parts[1].length() != 2)
				throw new RuntimeException("lunghezza mese non valida");
			if(parts[2].length() != 4)
				throw new RuntimeException("lunghezza anno non valida");
			
			if(!setYear(a))
				throw new RuntimeException("Anno non valido");
			if(!setMonth(m))
				throw new RuntimeException("Mese non valido");
			if(!setDay(g))
				throw new RuntimeException("Giorno non valido");

			

		}catch(NumberFormatException e) {
			throw new RuntimeException("Non posso usare la stringa che hai inserito");
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new RuntimeException("Non hai inserito abbastanza numeri");
		}
		
	}
	
	public Date(int day, int month, int year)
	{
		// uso i vari set per riempire
		// il nuovo oggetto che sto creando
		// il primo setter che mi dice di no
		// genera un'eccezione
		// il costruttore restituisce SEMPRE
		// un oggetto
		if(!setYear(year))
			throw new RuntimeException("Bad year "+year);
		if(!setMonth(month))
			throw new RuntimeException("Bad month "+month);
		if(!setDay(day))
			throw new RuntimeException("Bad day for day "+day+" month "+month+" for year "+year);
	}
	

	public static Date make(String stringdate) {

		Date date = new Date(stringdate);

		
		if(Date.CREATED == null) {
			Date.CREATED.add(date);
			System.out.println("Data aggiunta");
			return date;
		}
			
		for(Date d : Date.CREATED)
			if(d.equals(date)) {
				return d;
			}
		Date.CREATED.add(date);
		return date;
	}
	
	public static Date make(Date date) {
		for(Date d : Date.CREATED)
			if(d.equals(date)) {
				return d;
			}
		Date.CREATED.add(date);
		return date;
	}
	 
	// public: visibili da tutti
	// final: non possono essere cambiate. Sono COSTANTI
	// static: NON DEL SINGOLO OGGETTO MA DELLA CLASSE!
	// COSTANTI STATICHE
	public final static int MINYEAR = 1800;
	public final static int MAXYEAR = 3021;
	
	
	// proprietà dell'oggetto di classe Date
	// variabili di OGGETTO, variabili dell'INDIVIDUO
	private int day,month,year;
	
	// un setter è un metodo che si occupa di impostare
	// il valore di una proprietà che tipicamente non è visibile
	// SCRITTURA CONTROLLATA
	public void setMonthStupido(int month)
	{
		// month è un PARAMETRO. E' il nuovo valore che vorre impostare
		// dentro il mio oggetto!
		if(month<1 || month>12)
			return;
		// nei metodi void return TERMINA IL METODO. TUTTO QUI
		// se il mese era corretto io modifico lo STATO del mio oggetto
		// in particolare la proprietà MONTH
		this.month = month;
	}
	
	// un setter BOOLEANO. Cosa vuol dire
	// il setter di prima a volte funzionava a volte no
	// e IL CHIAMANTE non lo sapeva.
	// io mi chiamo setMonth e nella vita faccio una cosa: modifico il mese
	// e sono anche abbastanza furbo da dire al CHIAMANTE true o false
	// true se ho modificato il mese, false altrimenti
	private boolean setMonth(int month)
	{
		// month: parametro o proprietà? PARAMETRO
		if(month<1 || month>12)
			return false;
		// il metodo DEVE, DEVE, DEVE produrre un boolean
		// this.month è un parametro o una proprietà?
		// una proprietà dell'oggetto di classe Date
		// this di che tipo è? Date
		// prendo me stesso (this)
		// di me stesso (io sono una data)
		// prendo il campo month
		// e lo metto uguale a month che mi arriva
		// come parametro
		this.month = month;
		// sono riuscito a modificare. restituisco true
		return true;
	}
	
	
	private boolean setYear(int year)
	{
		if(year<MINYEAR || year>MAXYEAR)
			return false;
		// se l'anno è valido lo imposto
		this.year = year;
		return true;
	}
	
	private boolean setDay(int day)
	{
		// day è un PARAMETRO
		
		// se day è fra 1 e 28 lo accetto comunque
		if(day>=1 && day<=28)
		{
			// this.day è una proprietà
			this.day = day;
			return true;
		}
		// non abbiamo ancora il mese!
		if(month==0)
			return false;
		
		
		
		// i vettori partono da ZERO!
		// i giorni DEI MESI
		int[] monthDays = new int[]	
				{0, 31, year % 4 ==0 ? 29 : 28, 31, 30, 31, 30, 31,31, 30,31,30,31};
		
		/*
		 * 		0 ->	0
		 * 		1 ->	31
		 * 		2 ->	per year = 2021, 28
		 * 		3 -> 	31
		 * 		4 ->	30
		 * 		...
		 * 
		 */
		
		// monthDays[6] 		-> quanto vale? 30
		// monthDays[month]		-> cosa è month? month è la proprietà dell'oggetto in cui sono
		// monthDays[month]		-> i giorni del MIO mese
		// se il parametro è >=1 e <= dei ogiorni del MESE
		// month, è una proprietà o un parametro? proprietà.
		if(day>=1 && day<=monthDays[month])
		{
			// il giorno è valido e lo IMPOSTO
			this.day = day;
			// e restituisco true
			return true;
		}
		
		return false;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	@Override
	public String toString()
	{
		return  day+"/"+month+"/"+year;
	}
	
	
	//true se sono più grande dell'altra
	public boolean greaterThan(Date other) {
		
		if(this.getYear() > other.getYear())
			return true;
		if(this.getYear()==other.getYear() && this.getMonth() > other.getMonth())
			return true;
		if(this.getYear() == other.getYear() && this.getMonth() == other.getMonth() && this.getDay() > other.getDay())
			return true;
		
		return false;
	}
	
	public boolean lesserThan(Date other) {
		return !this.greaterThan(other) && this.equals(other);
	}
	
	public boolean greaterOrEqualsTo(Date other) {
		return this.greaterThan(other) || this.equals(other);
	}
	
	public boolean lesserOrEqualsTo(Date other) {
		return this.lesserThan(other) || this.equals(other);
	}
	
	
	public String toAmerican() {
		String smonth = month < 10 ? "0"+month : month+"";
		String sday = day< 10 ? "0"+day : day+"";
		return year+"-"+smonth+"-"+sday;
	}
	
	
	public static Date toEuropean(String s) {
		return Date.make(s.split("-")[2]+"/"+s.split("-")[1]+"/"+s.split("-")[0]);
	}
	
	@Override
    public boolean equals(Object other)
    {

        if(other==null)
            return false;
        if(this==other)
            return true;
        if(!(other instanceof Date))
            return false;
        Date otherdate = (Date) other;
        return 
                otherdate.getDay()         == this.getDay()     &&
                otherdate.getMonth()     == this.getMonth()     &&
                otherdate.getYear()     == this.getYear()    ;

    }
	
	
}
