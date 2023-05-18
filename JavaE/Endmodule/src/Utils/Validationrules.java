package Utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashSet;
import CustomException.PropertyException;
import com.code.Owner;
import com.code.Property_type;

public class Validationrules
{
@SuppressWarnings("unlikely-arg-type")
public static void checkduplicates(String adhar,HashSet<Owner>own) throws PropertyException
{
	if(own.contains(adhar))
	  throw new PropertyException("Duplicate adhar no!!!");
	System.out.println("No duplicate ");
}
public static LocalDate parseDate(String date) throws PropertyException
{
	LocalDate d1=LocalDate.parse(date);
	if(d1.isBefore(LocalDate.now()))
	 throw new PropertyException("invalid date ! date shoud be after todays date!!!");
	return d1;
}
public static Property_type validatetype(String type)
{
	Property_type t=Property_type.valueOf(type.toUpperCase());
	return t;
}
public static Owner validateAll(String adharno, String firstname, String lastname, String email, String address, String mobileno,
		String type, String availableDate, int rent,boolean isavailable,HashSet<Owner>own) throws PropertyException
{
	checkduplicates(adharno, own);
	LocalDate date=parseDate(availableDate);
	Property_type type1=validatetype(type);
	return new Owner(adharno,firstname,lastname, email,address, mobileno,type1, date,rent,isavailable);
}
}
