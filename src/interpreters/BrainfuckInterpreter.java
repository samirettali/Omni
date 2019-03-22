package interpreters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BrainfuckInterpreter {

	private int[] memory;
	private int memorySize;
	private int address;
	private int pointer;
	private int limit;
	private boolean debug;
	private boolean stop;
	private String output;
	private String source;


	public BrainfuckInterpreter() {
		memorySize = 250;
		memory = new int[memorySize];
		address = 0;
		pointer = 0;
		limit = 255;
		output = "";
		debug = false;
		stop = false;
	}

	public BrainfuckInterpreter(int memorySize, int limit, boolean stop) {

		this.memorySize = memorySize;
		memory = new int[memorySize];
		address = 0;
		pointer = 0;
		this.limit = limit;
		;
		output = "";
		debug = false;
		this.stop = stop;

	}

	public void readFile(String fileName) {

		source = "";

		try {
			BufferedReader br = new BufferedReader(new FileReader("file.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String program = sb.toString();
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void setSourceCode(String source) {
		this.source = source;
	}

	public void printSourceCode() {
		System.out.println(source);
	}

	public void setDebug() {
		debug = true;
	}

	public void setStop() {
		stop = true;
	}

	public void printMemory() {
		for (int i = 0; i < memorySize; i++)
			System.out.print(memory[i] + " ");
	}

	public void run() {

		//variabile del ciclo
		int count = 0;

		Scanner scanner = new Scanner(System.in);

		while (pointer < source.length()) {
			if (debug || stop) {
				for (int i = 0; i < source.length(); i++) {
					if (i != pointer)
						System.out.print(source.charAt(i));
					else
						System.out.print("{" + source.charAt(i) + "}");
				}

				System.out.println("\nlen\t" + source.length());
				System.out.println("pointer\t" + pointer);
				System.out.println("instr\t" + source.charAt(pointer));
				System.out.println("address\t" + address);
				System.out.println("value\t" + memory[address]);
				System.out.println("output\t" + output);
				System.out.println("limit\t" + limit);
				System.out.println("cells\t" + memorySize);
				printMemory();
				System.out.println("\n");
			}

			if (stop) {
				String x = scanner.nextLine();

			}

			switch (source.charAt(pointer)) {
				case '>':
					address++;
					if (address >= memorySize)
						address = 0;
					pointer++;
					break;

				case '<':
					address--;
					if (address < 0)
						address = memorySize - 1;
					pointer++;
					break;

				case '+':
					if (memory[address] < limit)
						memory[address]++;
					else
						memory[address] = 0;

					pointer++;
					break;

				case '-':
					if (memory[address] > 0)
						memory[address]--;
					else
						memory[address] = limit;

					pointer++;
					break;

				case '.':
					output += (char) memory[address];
					if (!debug && !stop)
						System.out.print((char) memory[address]);
					pointer++;
					break;

				case ',':
					memory[address] = (int) scanner.next().charAt(0);
					pointer++;
					break;

				case '[':
					count = 1;
					if (memory[address] == 0) {
						while (count > 0 || source.charAt(pointer - 1) != ']') {
							pointer++;
							if (source.charAt(pointer) == '[')
								count++;
							else if (source.charAt(pointer) == ']')
								count--;
						}
					} else
						pointer++;
					break;

				case ']':
					count = 0;
					if (memory[address] != 0) {
						while (source.charAt(pointer - 1) != '[' || count > 0) {
							pointer--;
							if (source.charAt(pointer) == ']')
								count++;
							else if (count > 0 && source.charAt(pointer) == '[')
								count--;
						}
					} else
						pointer++;
					break;

				case '#':
					stop = true;
					pointer++;
					break;

				case '\n':
				case '\t':
				case ' ':
					pointer++;
					break;

				default:
					System.out.println("Unexpected char \'" + source.charAt(pointer) + "\' at index " + pointer);
					break;


			}
		}


	}

	public static void test() {

		String helloworld = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";
		String helloworld2 = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
		String helloworld3 = ">++++++++[-<+++++++++>]<.>>+>-[+]++>++>+++[>[->+++<<+++>]<<]>-----.>->+++..+++.>-.<<+[>[+>+]>>]<--------------.>>.+++.------.--------.>+.>+.";
		String helloworld4 = "--<-<<+[+[<+>--->->->-<<<]>]<<--.<++++++.<<-..<<.<+.>>.>>.<<<.+++.>>.>>-.<<<+.";
		String helloworld5 = "--->->->>+>+>>+[++++[>+++[>++++>-->+++<<<-]<-]<+++]>>>.>-->-.>..+>++++>+++.+>-->[>-.<<]";
		String helloworld6 = "++<-[[<+>->+>--->-<<<]>+++]>+.<<<<<<<++.>>>..>.<<--.<<<--.>>+.>>>.+++.<.<<<-.<+.";
		String helloworld7 = "+>---->->+++>++>->+[++++++++[>++++++++>>+++++<<<-]<]>>.>++>.>..+>>.+>-->--[>-.<<]";
		String helloworld8 = "-<++[[<+>->->+++>+<<<]->]<<.---.<..<<.<<<---.<<<<-.>>-.>>>>>.+++.>>.>-.<<.";
		String fibonacci = "+[[<+>->+>+<<]>]";
		String triangular = "+[[<+>->++>-<<]>+]";
		String square = "+[[<+>->++>-<<]>++]";
		String pentagonal = "+[[<+>->++>-<<]>+++]";
		String helloworld9 = "->+++++>>>+>+>+>-->>++[+++[>++++++++<-]<+]>>.-[>->>>>>[+<]>--]>+>--.->---..>+++>.>>>++++[.<]";
		String helloworld10 = "->>++>+++>+>---->--[++++++[>+++++++++++<-]-<+]>>----.>+++.>-..+++.>>>.<.<.<.+++.------.<-.>>>+.";
		String boh = "[>++++++++++<-]>";
		String helloworld42 = "";
		String helloworld43 = "";
		String helloworld66 = "";
		String helloworld76 = "";
		String helloworld89 = "";


		BrainfuckInterpreter b = new BrainfuckInterpreter(50, 255, false);
		b.setSourceCode(helloworld);
		//b.setDebug();
		b.setStop();
		b.run();
		b.printMemory();
	}

}
