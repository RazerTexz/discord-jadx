package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class BlowfishSerializer extends Serializer {
    private static SecretKeySpec keySpec;
    private final Serializer serializer;

    /* renamed from: com.esotericsoftware.kryo.serializers.BlowfishSerializer$1, reason: invalid class name */
    public class AnonymousClass1 extends Output {
        public AnonymousClass1(OutputStream outputStream, int i) {
            super(outputStream, i);
        }

        @Override // com.esotericsoftware.kryo.io.Output, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws KryoException {
        }
    }

    public BlowfishSerializer(Serializer serializer, byte[] bArr) {
        this.serializer = serializer;
        keySpec = new SecretKeySpec(bArr, "Blowfish");
    }

    private static Cipher getCipher(int i) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(i, keySpec);
            return cipher;
        } catch (Exception e) {
            throw new KryoException(e);
        }
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public Object copy(Kryo kryo, Object obj) {
        return this.serializer.copy(kryo, obj);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public Object read(Kryo kryo, Input input, Class cls) {
        return this.serializer.read(kryo, new Input(new CipherInputStream(input, getCipher(2)), 256), cls);
    }

    @Override // com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, Object obj) throws IOException, KryoException {
        CipherOutputStream cipherOutputStream = new CipherOutputStream(output, getCipher(1));
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(cipherOutputStream, 256);
        this.serializer.write(kryo, anonymousClass1, obj);
        anonymousClass1.flush();
        try {
            cipherOutputStream.close();
        } catch (IOException e) {
            throw new KryoException(e);
        }
    }
}
