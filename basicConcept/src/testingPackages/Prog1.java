package testingPackages;

class Prog1{
	public static void main(String[] args) {
		System.out.println("Inside class 1");
	}
}
/**
 * Every class nad interface should be packaged, for grouping and resolving attributes in namespaces.
 * Default package is "src" but it is not recommended if class or interface is inside any folder of src.
 * package name structure|namespace should follow the folder structure of its .java file.
 * Every package are independent and have flat structure, i.e., package a.b.c.file1.java is not associated or contained in|with package a.b.file2.java
 */