package com.mawen.lambda.chapter08.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * 基于方法引用初始化 Compressor
 */
public class CompressorMethodRef {

    private final Function<OutputStream, OutputStream> compress;

    public CompressorMethodRef(Function<OutputStream, OutputStream> compress) {
        this.compress = compress;
    }

    public void compress(Path inFile, File outFile) throws IOException {
        try (OutputStream outStream = new FileOutputStream(outFile)) {
            Files.copy(inFile, compress.apply(outStream));
        }
    }


    public static void main(String[] args) throws IOException {
        Path inFile = null;
        File outFile = null;
        CompressorMethodRef gzipCompressor = new CompressorMethodRef(out -> {
            try {
                return new GZIPOutputStream(out);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
        gzipCompressor.compress(inFile, outFile);

        CompressorMethodRef zipCompressor = new CompressorMethodRef(ZipOutputStream::new);
        zipCompressor.compress(inFile, outFile);
    }

}
