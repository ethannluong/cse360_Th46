package application;

import java.io.*;
import java.util.ArrayList;
import java.io.File;  
import java.io.FileInputStream;

public class logFiles{
	public static ArrayList<ArrayList<String>> fileContents = new ArrayList<ArrayList<String>>();
	String logFileHeader = "Timestamp\t\tProject\t\tEmployeeID\t\tName\t\tStart\t\tStop\t\tLife Cyle Step\t\tCategory\t\tSub-Category";
	public boolean createNewLog(String path)
	{
		String filePath = nextAvaliableFileName(path,1);
		File file = new File(filePath);
		if(file.exists()||path=="")
		{
			return false;
		}
		try
		{
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(logFileHeader);
		bw.flush();
		bw.close();
		return true;
		} catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean combineExistingLogFiles(String inputPath, String outputPath, boolean wipePersonal)
	{
		int[] wipeIndexes = {0,0,1,1,0,0,0,0,0};  //wipe data in columns listed with a 1 given that wipePersonal is checked
		String nextLine;
		int i = 0;
		int i2 = 0;
		int length;
		if(inputPath==""||outputPath=="")
		{
			return false;
		}
		try
		{
			File outputFile = new File(outputPath);
			//read existing outputFile if it exists
			if(outputFile.exists())
			{
				FileReader fr2 = new FileReader(outputFile);
				BufferedReader br2 = new BufferedReader(fr2);
				while((nextLine=br2.readLine())!=null)
				{
					fileContents.add(new ArrayList<String>());
					i2 = 0;
					while(nextLine!="\t"&&nextLine!="")
					{
						int pos;
						pos = nextLine.indexOf('\t');
						if(pos!=-1)
						{
							fileContents.get(i).add(nextLine.substring(0,pos));
							length = nextLine.length();
							nextLine = nextLine.substring(pos+2,length);
						}
						else
						{
							fileContents.get(i).add(nextLine);
							break;
						}
						i2++;
					}
					i++;
				}
				br2.close();
			}
			File inputFile = new File(inputPath);
			FileReader fr1 = new FileReader(inputFile);
			BufferedReader br1 = new BufferedReader(fr1);
			//read input file
			br1.readLine();
			while((nextLine=br1.readLine())!=null)
			{
				fileContents.add(new ArrayList<String>());
				i2 = 0;
				while(nextLine!="\t"&&nextLine!="")
				{
					int pos;
					pos = nextLine.indexOf('\t');
					if(pos!=-1)
					{
						if(wipeIndexes[i2]==1&&wipePersonal)
						{
							fileContents.get(i).add("       ");
						}
						else
						{
							fileContents.get(i).add(nextLine.substring(0,pos));
						}
						length = nextLine.length();
						nextLine = nextLine.substring(pos+2,length);
					}
					else
					{
						fileContents.get(i).add(nextLine);
						break;
					}
					i2++;
				}
				i++;
			}
			br1.close();
			//append input file to output file
			File combinedFile = new File(outputPath);
			FileWriter fw = new FileWriter(combinedFile);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int j=0;j<fileContents.size();j++)
			{
				for(int w=0;w<fileContents.get(j).size();w++)
				{
					bw.write(fileContents.get(j).get(w)+"\t\t");
				}
				bw.write("\n");
			}
			bw.close();
			fileContents.clear();
			return true;
		} catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean appendToExistingLogFile(String filePath, String data)
	{
		try
		{
			FileWriter fw = new FileWriter(filePath, true);
			fw.write(data);
			fw.close();
			return true;
		} catch(IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public String nextAvaliableFileName(String path, int iteration)
	{
		String filePath = path+"\\Effort_Log"+iteration+".txt";
		File file = new File(filePath);
		if(file.exists())
		{
			return nextAvaliableFileName(path,iteration+1);
		}
		else
		{
			return filePath;
		}
	}
}
