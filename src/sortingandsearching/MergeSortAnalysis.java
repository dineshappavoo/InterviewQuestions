package sortingandsearching;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class for generating performance report of the sorting implementations
 * 
 */
public class MergeSortAnalysis {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		new MergeSortAnalysis()
				.processInAndOutFile(
						"/input1048576.txt",
						"/output.txt");
	}

	public void processInAndOutFile(String inFile, String outFile)
			throws FileNotFoundException {
		File infile = new File(inFile);
		File outPutFile = new File(outFile);
		PrintWriter pwInput = new PrintWriter(outPutFile);

		try {
			Scanner scanner = new Scanner(infile);
			int arrSize = scanner.nextInt();
			int[] inpuArr = new int[arrSize];
			int[] auxArray = new int[arrSize];
			while (scanner.hasNext()) {
				for (int j = 0; j < arrSize; j++) {
					inpuArr[j] = scanner.nextInt();
				}
				StringBuffer outLine = new StringBuffer();
				long inTime = System.currentTimeMillis();
				new MergeSort().mergeSort(inpuArr, 0, inpuArr.length - 1);
				long pTime = System.currentTimeMillis();
				outLine.append(" Time in Secs MergeSort (1): " + (pTime - inTime));
				inTime = System.currentTimeMillis();
				new MergeSortAuxilary().mergeSort(inpuArr, auxArray, 0,
						inpuArr.length - 1);
				pTime = System.currentTimeMillis();
				outLine.append(" Time in Secs MergeSort (2): " + (pTime - inTime));
				inTime = System.currentTimeMillis();
				MergeSortAlternateMerge.mergeSort(inpuArr, auxArray, 0,
						inpuArr.length - 1);
				pTime = System.currentTimeMillis();
				outLine.append(" Time in Secs MergeSort (3): " + (pTime - inTime));
				inTime = System.currentTimeMillis();
				new QuickSort().quickSort(inpuArr, 0, inpuArr.length - 1);
				pTime = System.currentTimeMillis();
				outLine.append(" Time in Secs QuickSort: " + (pTime - inTime));
				pwInput.println(outLine);
			}
			scanner.close();
			pwInput.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
