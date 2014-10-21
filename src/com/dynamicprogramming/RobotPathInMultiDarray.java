/**
 * 
 */
package com.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Dany
 *
 */
public class RobotPathInMultiDarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int res=new RobotPathInMultiDarray().pathCountWithPath(0, 0, 2, 2, new ArrayList<String>(), 0);
		System.out.println(res);
		
		
		System.out.println("Using Hashmap DS");
		int res1=new RobotPathInMultiDarray().pathCountWithPathUsingHashmap(0, 0, 2, 2, new HashMap<Integer, String>(), 0);
		System.out.println(res1);

	}

	public int pathCount(int x, int y, int m, int n)
	{
		if((x==m)&&(y==n))
			return 1;
		if((x>3)||(y>3))
			return 0;
		return pathCount(x+1, y, m, n)+pathCount(x, y+1, m, n);
	}

	public int pathCountWithPath(int x, int y, int m, int n, ArrayList<String> path, int level)
	{
		if((x==m)&&(y==n))
		{
			System.out.println("Test "+level);

			String pos="("+x+","+y+")";
			if(isIndexExist(path, level))
				path.set(level, pos);
			else
				path.add(level, pos);

			printPath(path, 0, level);
			return 1;
		}
		if((x>m)||(y>n))
			return 0;

		String pos="("+x+","+y+")";
		if(isIndexExist(path, level))
			path.set(level, pos);
		else
			path.add(level, pos);

		return pathCountWithPath(x+1, y, m, n,path,level+1)+pathCountWithPath(x, y+1, m, n, path, level+1);
	}

	public int pathCountWithPathUsingHashmap(int x, int y, int m, int n, HashMap<Integer,String> path, int level)
	{
		if((x==m)&&(y==n))
		{
			System.out.println("Test "+level);

			String pos="("+x+","+y+")";
			path.put(level, pos);

			printPath(path, 0, level);
			return 1;
		}
		if((x>m)||(y>n))
			return 0;

		String pos="("+x+","+y+")";
		path.put(level, pos);

		return pathCountWithPathUsingHashmap(x+1, y, m, n,path,level+1)+pathCountWithPathUsingHashmap(x, y+1, m, n, path, level+1);
	}

	public void printPath(HashMap<Integer, String> path, int startIndex, int endIndex)
	{
		for(int i=startIndex;i<=endIndex;i++)
		{

			System.out.print(path.get(i)+',');
		}
		System.out.println();
	}

	public void printPath(ArrayList<String> path, int startIndex, int endIndex)
	{
		for(int i=startIndex;i<=endIndex;i++)
		{

			System.out.print(path.get(i)+',');
		}
		System.out.println();
	}

	public boolean isIndexExist(ArrayList<String> path, int index)
	{
		try{

			String s=path.get(index);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

}
