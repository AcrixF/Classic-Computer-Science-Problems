package org.neoa.ch02.dna;

import java.util.ArrayList;
import java.util.Comparator;

public class Gene {

    private ArrayList<Codon> codons = new ArrayList<>();

    public Gene(String gene) {
        for (int i = 0; i < gene.length() - 3; i +=3) {
            codons.add(new Codon(gene.substring(i, i + 3)));
        }
    }

    // Linear approach.
    public boolean containsCodonSequence(Codon key) {
        for (Codon codon: codons) {
            if (codon.compareTo(key) == 0)
                return true;
        }
        return false;
    }


    public enum Nucleotide {
        A, C, G, T
    }

    public static class Codon implements Comparable<Codon> {
        public final Nucleotide fist;
        public final Nucleotide second;
        public final Nucleotide third;


        private final Comparator<Codon> comparator = Comparator.comparing((Codon c) -> c.fist)
                .thenComparing((Codon c) -> c.second)
                .thenComparing((Codon c) -> c.third);

        public Codon(String codon) {
            fist = Nucleotide.valueOf(codon.substring(0, 1));
            second = Nucleotide.valueOf(codon.substring(1, 2));
            third = Nucleotide.valueOf(codon.substring(2, 3));
        }

        @Override
        public int compareTo(Codon other) {
            return comparator.compare(this, other);
        }
    }


}
