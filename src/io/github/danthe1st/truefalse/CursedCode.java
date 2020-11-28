package io.github.danthe1st.truefalse;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class CursedCode {
	public static void main(String[] args) throws Exception {
		Curser.curseJava();
		if (Boolean.valueOf("false")) {
			System.out.println("should never happen, right?");
			if(Boolean.FALSE) {
				System.out.println("Wait, WHAAAAAAAAAAT?");
			}
			if(Boolean.TRUE) {
				System.out.println("everything is ok");
			}
			Curser.curseJavaEvenMore();
			if(Boolean.TRUE==Boolean.FALSE) {
				System.out.println("java is funny");
			}
			int minInt=(Integer) Integer.class.getField("MIN_VALUE").get(null);
			int maxInt=(Integer) Integer.class.getField("MAX_VALUE").get(null);
			System.out.println("Integers reach from "+minInt+" to "+maxInt+". Integers definetly have "+(Math.log10(maxInt-minInt)/Math.log10(2)+1)+" bits.");
			
			System.out.println("This program will self destruct when you press enter. You will be able to recompile it, however.");
			System.in.read();
			File dir=new File(CursedCode.class.getProtectionDomain().getCodeSource().getLocation().toURI());
			Files.walk(dir.toPath())
		      .sorted(Comparator.reverseOrder())
		      .map(Path::toFile)
		      .forEach(File::delete);

		}
	}
	
	
}
