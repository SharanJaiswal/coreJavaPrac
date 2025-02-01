package kk.oops.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * To examine class, its methods, fields, modifiers, constructors, interfaces, at runtime; and to change the behavior(field values) of classes at runtime.
 * We use an object of "Class" class. For every class in an application when it is loaded on requirement, JVM also loads the "Class" object associated with our each class.
 * This "Class" object for a given class has a metadata info. Only get methods are present. Makes program slow at runtime.
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // ways to get Class object for a given class:
        try {
            Class c1 = Class.forName("kk.oops.reflections.Main");   // 1
            c1 = Main.class;    // 2
            Main mobj = new Main();
            c1 = mobj.getClass();   // 3
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        Class<Main> c1 = Main.class;
        System.out.println(Modifier.toString(c1.getModifiers()));
        System.out.println(c1.getName());

        Method[] methods = c1.getMethods(); // returns only an array of public methods, even which is inherited from class like "Object". Similarly .getFields() only public fields.
        for (Method method : methods) {
            System.out.println("Name: " + method.getName() + " -- Ret typ: " + method.getReturnType() + " -- class: " + method.getDeclaringClass());
        }

        // to get private methods: provision is present to get all methods native to Class object's associated class
        methods = c1.getDeclaredMethods();  // similarly, .getDeclaredFields()
        System.out.println("============");
        for (Method method : methods) {
            System.out.println("Name: " + method.getName() + " -- Ret typ: " + method.getReturnType() + " -- class: " + method.getDeclaringClass());
        }

        // invoking a method
        // first get a Class object, then geta method by giving method name and type of param
        Method sleepMethod = c1.getMethod("eat", int.class, boolean.class, String.class);   // If "sleeps" method name is put then it will throw an exception stating "sleeps" pvt.
        Object classObj = c1.newInstance();
        sleepMethod.invoke(classObj, 1, true, "hello"); // similarly for accessible field setting new value: first get field by providing field name, then field.set(Class_object, newVal);
        // field.setAccessible(true); // makes pvt field available to set. Similarly, we can break singleton class by breaking its private constructor and then get a new instance of that class.
    }

    public void eat(int intP, boolean boolP, String strP) {
        System.out.println("eatbody");
    }
    private void sleeps(int intP, boolean boolP, String strP) {}
}
