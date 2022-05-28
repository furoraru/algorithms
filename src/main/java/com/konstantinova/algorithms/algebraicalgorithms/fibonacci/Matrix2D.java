package com.konstantinova.algorithms.algebraicalgorithms.fibonacci;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;


@Data
@Builder
public class Matrix2D {
    private BigInteger x11;
    private BigInteger x12;
    private BigInteger x21;
    private BigInteger x22;

    public static final Matrix2D BASE = Matrix2D.builder()
            .x11(BigInteger.valueOf(1L)).x12(BigInteger.valueOf(1L))
            .x21(BigInteger.valueOf(1L)).x22(BigInteger.valueOf(0L))
            .build();
    public static final Matrix2D IDENTITY = Matrix2D.builder()
            .x11(BigInteger.valueOf(1L)).x12(BigInteger.valueOf(0L))
            .x21(BigInteger.valueOf(1L)).x22(BigInteger.valueOf(0L))
            .build();

    public Matrix2D multiply(Matrix2D base) {
        Matrix2D result = Matrix2D.builder().build();
        result.x11 = this.x11.multiply(base.x11).add(this.x12.multiply(base.x21));
        result.x12 = this.x11.multiply(base.x12).add(this.x12.multiply(base.x22));
        result.x21 = result.x12;
        result.x22 = this.x21.multiply(base.x12).add(this.x22.multiply(base.x22));
        return result;
    }
}
