import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MyJunit {
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public  @interface MyBefore{
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAfter{

    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyTest{

    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class c = Class.forName("MyCalculateTest");
        Object cinstance = c.newInstance();

        Method[] ms = c.getDeclaredMethods();

        ArrayList<Method> befms = new ArrayList<>();
        ArrayList<Method> aftms  = new ArrayList<>();
        ArrayList<Method> tstms = new ArrayList<>();

        for(Method m:ms){
            if(m.isAnnotationPresent(MyTest.class))     tstms.add(m);
            if(m.isAnnotationPresent(MyBefore.class))   befms.add(m);
            if(m.isAnnotationPresent(MyAfter.class))    aftms.add(m);
        }

        for(Method m:befms)
            m.invoke(cinstance,null);
        for(Method m:tstms)
            m.invoke(cinstance,null);
        for(Method m:aftms)
            m.invoke(cinstance,null);
    }

}


