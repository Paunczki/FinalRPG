import java.io.*;

public class Text { 
	private String file;
	
	public Text(String i) {
		setFile(i);
	}
	public Text(String j, int k) {
		setFile(j);
		
	}
	public void setFile(String j) {
		file = j;
	}
	public String getFile() {
		return file;
	}
	
	public void Text2Screen() throws Exception{ 
		File file = new File(this.file); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 

		while ((st = br.readLine()) != null) {
			char[] lines = st.toCharArray();
			if (lines.length <= 0) {
				System.out.println();
				Thread.sleep(1000);
			}

			for (int j = 0; j < lines.length; j++) {
				char x = lines[j];
				System.out.print(x);
				Thread.sleep(15);
				if (j == lines.length - 1) {
					System.out.println();
					Thread.sleep(750);
				}
			}

		}
	}
	public void TextToScreen(int k) throws Exception{ 
		File file = new File(this.file); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		String st; 

		while ((st = br.readLine()) != null) {
			char[] lines = st.toCharArray();
			if (lines.length <= 0) {
				System.out.println();
				Thread.sleep(k);
			}

			for (int j = 0; j < lines.length; j++) {
				char x = lines[j];
				System.out.print(x);
				Thread.sleep(15);
				if (j == lines.length - 1) {
					System.out.println();
					Thread.sleep(k);
				}
			}

		}
	}
} 