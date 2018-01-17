class TestCompteBancaire {
	public static void main(String arg[]){

		CompteBancaire C2 = new CompteBancaire();
		CompteBancaire C3 = new CompteBancaire("BENAOU",1000);
		System.out.println(C3.toString());
		Client C4 = new Client("Abdellaoui","457 Avenue Jean Monnet 17000 La Rochelle","0621652705","C012345DE3R");
		System.out.println(C4.toString());
	}

}
