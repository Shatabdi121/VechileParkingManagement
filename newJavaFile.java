
package newJavaFile;
class Base {
	public void Print()
	{
		System.out.println("Base");
	}
}

class Derived extends Base {
        @Override
	public void Print()
	{
		System.out.println("Derived");
	}
}

class newJavaFile {
	public static void DoPrint(Base o)
	{
		o.Print();
	}
	public static void main(String[] args)
	{
		Base x = new Base();
		Base y = new Derived();
		Derived z = new Derived();
		DoPrint(x);
		DoPrint(y);
		DoPrint(z);
	}
}
