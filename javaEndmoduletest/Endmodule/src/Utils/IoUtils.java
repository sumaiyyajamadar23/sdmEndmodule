package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import com.code.Owner;

public class IoUtils
{
public static void store(String filename,HashSet<Owner> set) throws IOException

{
try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
{
	out.writeObject(set);
}
catch( IOException e)
{
System.out.println(e);	
}
}

public static HashSet<Owner>restore(String filename) throws ClassNotFoundException, IOException
{
	try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename)))
	{
		return (HashSet<Owner>)in.readObject();
	}
	catch(Exception e)
	{
		System.out.println(e);
		return new HashSet<Owner>();
	}
}
}

