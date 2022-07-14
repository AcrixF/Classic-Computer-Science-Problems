package org.neoa.ch02.dna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Gene {

    private ArrayList<Codon> codons = new ArrayList<>();

    public Gene(String gene) {
        for (int i = 0; i < gene.length() - 3; i +=3) {
            codons.add(new Codon(gene.substring(i, i + 3)));
        }
    }

    // Linear approach.
    public boolean containsCodonSequenceLinear(Codon key) {
        for (Codon codon: codons) {
            if (codon.compareTo(key) == 0)
                return true;
        }
        return false;
    }

    // Binary Search approach.
    public boolean containsCodonSequenceBinary(Codon key) {
        List<Codon> sortedCodons = new ArrayList<>(codons);
        Collections.sort(sortedCodons);

        int low = 0;
        int high = sortedCodons.size() - 1;

        while(low <= high) {
            int middle = (low + high) / 2;
            int comparison = codons.get(middle).compareTo(key);
            if (comparison < 0)
                low = middle + 1;
            else if (comparison > 0)
                high = middle - 1;
            else
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
