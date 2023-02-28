package exercism;

import java.util.ArrayList;
import java.util.List;

public class ProteinTranslation {
  public static void main(String[] args) {
    ProteinTranslator pt = new ProteinTranslator();
    System.out.println(pt.translate("AUGUUUUCUUAAAUG"));
  }
}

class ProteinTranslator {

  String getProteinName(String rna) {
    switch (rna) {
      case "AUG":
        return "Methionine";
      case "UUU", "UUC":
        return "Phenylalanine";
      case "UUA", "UUG":
        return "Leucine";
      case "UCU", "UCC", "UCA", "UCG":
        return "Serine";
      case "UAU", "UAC":
        return "Tyrosine";
      case "UGU", "UGC":
        return "Cysteine";
      case "UGG":
        return "Tryptophan";
      case "UAA", "UAG", "UGA":
        return "STOP";
    }
    throw new IllegalArgumentException();
  }

  List<String> translate(String rnaSequence) {
    List<String> out = new ArrayList<>();

    for (String s : rnaSequence.split("(?<=\\G...)")) {
      String val = getProteinName(s);
      if (val == "STOP")
        break;
      out.add(val);
    }

    return out;
  }
}
