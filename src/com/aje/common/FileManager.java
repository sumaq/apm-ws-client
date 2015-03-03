package com.aje.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	public static void getFilesFromDirectory(String _folder){
		final File folder = new File(_folder);
		    for (final File fileEntry : folder.listFiles()) {
		            System.out.println(fileEntry.getName());
		    }
	}
	
	public static void moveTo (String _fileSource, String _directoryTarget){
    	try{
    	   File afile = new File(_fileSource);
    	   // Efecto sobrescribir : Si el archivo destino existe, borrarlo
    	   File fileDest = new File(_directoryTarget + afile.getName());
    	   if (fileDest.exists()){
    		   fileDest.delete();
    	   }
    	   // Si la carpeta destino no existe, crearla
    	   File dirDest = new File(_directoryTarget);
    	   if (!dirDest.exists()){
    		   dirDest.mkdir();
    	   }
    	   // Mover archivo al destino
     	   if(afile.renameTo(new File(_directoryTarget + afile.getName()))){
     		System.out.println("File is moved successful!");
     	   }else{
     		System.out.println("File is failed to move!");
     	   }
       	}catch(Exception e){
     		System.out.println(e.toString());//e.printStackTrace();
     	}
	} 

	public static List<String> ReadDirectory(String _folder, 
									 		 String _startWith,
									 		 String _filterExtension) {
        List<String> lista = new ArrayList<String>(); 
		try{
	        File aFile = new File(_folder);
		 	File[] listOfFiles = aFile.listFiles();
	        String fileName = "";
	        String extension = "";
	        if (aFile.isDirectory()) {
	             listOfFiles = aFile.listFiles();
	            if(listOfFiles!=null) {
	                for(int i=0; i < listOfFiles.length; i++  ) {
	                    if (listOfFiles[i].isFile()) {
	                        fileName = listOfFiles[i].toString();
	                        int dotPos = fileName.lastIndexOf(".");
	                        String startString = listOfFiles[i].getName().substring(0, _startWith.length());
	                        if (dotPos > 0) {
	                            extension = fileName.substring(dotPos);
	                        }                       
	                        if (extension.toUpperCase().equals(_filterExtension.toUpperCase()) &&
	                        	startString.toUpperCase().equals(_startWith.toUpperCase())) {
	                        	lista.add(listOfFiles[i].toString());
	                        	//System.out.println(listOfFiles[i].getName());
	                        }
	                    }           
	                    //if(listOfFiles[i].isDirectory()) {
	                    //    ReadDirectory(listOfFiles[i].getName(),_filterExtension);
	                    //}
	                }
	            }
	        }
	       	}catch(Exception e){
	     		System.out.println(e.toString());
	       	}
		return lista;
	    }	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileSource = "D:\\APFIL882.TXT"; 
		String directoryTarget = "D:\\aTest\\";
		
		//FileManager.moveTo(fileSource, directoryTarget);
		FileManager.getFilesFromDirectory("D:\\aTest\\");
	}

}
