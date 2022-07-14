package org.neoa.ch02.dna;

import java.util.Comparator;

public class Gene {

    public enum Nucleotide {
        A, C, G, T
    }

    public static class Codon implements Comparable<Codon> {
        public final Nucleotide fist;
        public final Nucleotide second;
        public final Nucleotide thrid;


        private final Comparator<Codon> comparator = Comparator.comparing((Codon c) -> c.fist)
                .thenComparing((Codon c) -> c.second)
                .thenComparing((Codon c) -> c.thrid);

        public Codon(String codon) {
            fist = Nucleotide.valueOf(codon.substring(0, 1));
            second = Nucleotide.valueOf(codon.substring(1, 2));
            thrid = Nucleotide.valueOf(codon.substring(2, 3));
        }

        @Override
        public int compareTo(Codon other) {
            return comparator.compare(this, other);
        }
    }


}
