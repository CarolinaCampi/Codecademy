public class ProteinFinder {

/*
This program determines whether there is a protein in a strand of DNA.

A protein has the following qualities:
- It begins with a “start codon”: ATG.
- It ends with a “stop codon”: TGA.
- In between, each additional codon is a sequence of three nucleotides.

*/
  public static void doesItContainProtein(String dna){

    // Does the DNA strand contains the beggening codon?
    int indexOfATG = dna.indexOf("ATG");
    boolean hasBegginingCodon = (indexOfATG != -1);
    
    // Does the DNA strand have the stop codon?
    int indexOfTGA = dna.indexOf("TGA");
    boolean hasEndCodon = (indexOfATG != -1);
    
    // Create a protein substring
    String protein = dna.substring(indexOfATG + 3, indexOfTGA);

    if (hasBegginingCodon && hasEndCodon && protein.length() % 3 == 0){
        System.out.println(dna +  " --> contains a protein!");
    } else {
      System.out.println(dna + " --> NO protein");
    }
  }


  public static void main (String[] args){

    //  -. .-.   .-. .-.   .
    //    \   \ /   \   \ / 
    //   / \   \   / \   \  
    //  ~   `-~ `-`   `-~ `-
    String dna1 = "ATGCGATACGCTTGA";
    String dna2 = "ATGCGATACGTGA";
    String dna3 = "ATTAATATGTACTGA"; 

    doesItContainProtein(dna1);
    doesItContainProtein(dna2);
    doesItContainProtein(dna3);
    
  }
}
