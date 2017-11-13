public class Principal {

	public static void main(String[] args) {
		Parser parser = new Parser();
		parser.parseFicheroXml("fichero2.xml");
		parser.parseDocument();
		parser.print();
			
	}

}
