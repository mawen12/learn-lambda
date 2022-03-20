package com.mawen.lambda.chapter08.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 在构造类时提供压缩
 */
public class Compressor {

    private final CompressionStrategy strategy;

    public Compressor(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        try (OutputStream outStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, strategy.compress(outStream));
        }
    }

    /**
     * 使用具体的策略类初始化 Compressor
     */
    public static void main(String[] args) throws IOException {
        Path inFile = null;
        File outFile = null;
        Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
        gzipCompressor.compress(inFile, outFile);

        Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
        zipCompressor.compress(inFile, outFile);
    }
}
