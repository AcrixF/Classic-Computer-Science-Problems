package org.neoa.ch02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.neoa.ch02.dna.Gene;

import static org.assertj.core.api.Assertions.assertThat;

public class GeneTest {

    private Gene SUT;
    private static final String RAW_GENE_SEQUENCE = "ACGTGGCTCTCTAACGTACGTACGTACGGGGTTTATATATACCCTAGGACTCCCTTT";

    @BeforeEach
    void setup() {
        SUT = new Gene(RAW_GENE_SEQUENCE);
    }

    @Test
    void containsCodonSequenceReturnsTrueWhenKeyFoundInGeneStream() {
        Gene.Codon acg = new Gene.Codon("ACG");
        boolean result = SUT.containsCodonSequence(acg);
        assertThat(result).isTrue();
    }

    @Test
    void containsCodonSequenceReturnsFalseWhenKeyNotFoundInGeneStream() {
        Gene.Codon acg = new Gene.Codon("GAT");
        boolean result = SUT.containsCodonSequence(acg);
        assertThat(result).isFalse();
    }

}
