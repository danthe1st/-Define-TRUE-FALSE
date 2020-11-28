package io.github.danthe1st.truefalse;

import java.lang.reflect.Field;

import sun.misc.Unsafe;
/**
 * This sets up the fun stuff, do not view this class before running it
 * @author dan1st
 */
public class Curser {
	private static final Boolean TRUE=true;
	private static final Boolean FALSE=false;
	
	private static void set(Object name,Object value) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		set(String.valueOf(name).toUpperCase(),name.getClass(),value);
	}
	
	//DO NOT LOOK FURTHER IF YOU WANT TO AVOID SPOILERS!!!!!!!!!!!!!!!
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//NOOOOOOOOOOOOOOOOOOOOOOOOO
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//STOP
	//NOW
	
	
	
	//Ok, did you guess reflection? Partually correct.
	//Reflection allows you to access private and/or final attributes but not static final attributes.
	//pre-Java 12, this could be bypassed by removing the final modifier in the java.lang.reflect.Field object.
	//Since Java 12, it is not possible to modify reflection with reflection (or Unsafe), however. (https://bugs.java.com/bugdatabase/view_bug.do?bug_id=8210496)
	//This approach uses sun.misc.Unsafe in order to get the field base and offset of the attribute to change.
	//Then, Unsafe sets the value
	//Unsafe.getUnsafe() works only for classes loaded from the Bootstrap class loader so the Unsafe object needs to be loaded with reflection.
	//(It even works with private static final variables)
	
	private static Unsafe unsafe;
	
	private static void setUp() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		if (unsafe == null) {
			final Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
			unsafeField.setAccessible(true);
			unsafe = (Unsafe) unsafeField.get(null);
		}

	}
	
	public static void curseJava() throws Exception {
		setUp();
		set(true,FALSE);
		set(false,TRUE);
	}
	public static void curseJavaEvenMore() throws Exception {
		setUp();
		set(false,TRUE);
		set(true,TRUE);
		setInt("MAX_VALUE",Integer.class,0);
		setInt("MIN_VALUE",Integer.class,-1);
	}
	
	private static void setInt(String name,Class<?> cl,int value) throws NoSuchFieldException {
		final Field tr = cl.getDeclaredField(name);
        final Object staticFieldBase = unsafe.staticFieldBase(tr);
        final long staticFieldOffset = unsafe.staticFieldOffset(tr);
        unsafe.putInt(staticFieldBase, staticFieldOffset, value);
	}
	private static void set(String name,Class<?> cl,Object value) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		final Field tr = cl.getDeclaredField(name);
        final Object staticFieldBase = unsafe.staticFieldBase(tr);
        final long staticFieldOffset = unsafe.staticFieldOffset(tr);
        unsafe.putObject(staticFieldBase, staticFieldOffset, value);
	}
	
}

