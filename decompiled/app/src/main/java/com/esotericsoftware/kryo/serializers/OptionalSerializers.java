package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Util;
import java.io.IOException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* loaded from: classes.dex */
public final class OptionalSerializers {

    public static class OptionalDoubleSerializer extends Serializer<OptionalDouble> {
        private OptionalDoubleSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ OptionalDouble read(Kryo kryo, Input input, Class<OptionalDouble> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OptionalDouble optionalDouble) throws IOException, KryoException {
            write2(kryo, output, optionalDouble);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public OptionalDouble read2(Kryo kryo, Input input, Class<OptionalDouble> cls) {
            return input.readBoolean() ? OptionalDouble.of(input.readDouble()) : OptionalDouble.empty();
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, OptionalDouble optionalDouble) throws IOException, KryoException {
            output.writeBoolean(optionalDouble.isPresent());
            if (optionalDouble.isPresent()) {
                output.writeDouble(optionalDouble.getAsDouble());
            }
        }

        public /* synthetic */ OptionalDoubleSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class OptionalIntSerializer extends Serializer<OptionalInt> {
        private OptionalIntSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ OptionalInt read(Kryo kryo, Input input, Class<OptionalInt> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OptionalInt optionalInt) throws IOException, KryoException {
            write2(kryo, output, optionalInt);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public OptionalInt read2(Kryo kryo, Input input, Class<OptionalInt> cls) {
            return input.readBoolean() ? OptionalInt.of(input.readInt()) : OptionalInt.empty();
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, OptionalInt optionalInt) throws IOException, KryoException {
            output.writeBoolean(optionalInt.isPresent());
            if (optionalInt.isPresent()) {
                output.writeInt(optionalInt.getAsInt());
            }
        }

        public /* synthetic */ OptionalIntSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class OptionalLongSerializer extends Serializer<OptionalLong> {
        private OptionalLongSerializer() {
            setImmutable(true);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ OptionalLong read(Kryo kryo, Input input, Class<OptionalLong> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, OptionalLong optionalLong) throws IOException, KryoException {
            write2(kryo, output, optionalLong);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public OptionalLong read2(Kryo kryo, Input input, Class<OptionalLong> cls) {
            return input.readBoolean() ? OptionalLong.of(input.readLong()) : OptionalLong.empty();
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, OptionalLong optionalLong) throws IOException, KryoException {
            output.writeBoolean(optionalLong.isPresent());
            if (optionalLong.isPresent()) {
                output.writeLong(optionalLong.getAsLong());
            }
        }

        public /* synthetic */ OptionalLongSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static class OptionalSerializer extends Serializer<Optional> {
        private OptionalSerializer() {
            setAcceptsNull(false);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Optional copy(Kryo kryo, Optional optional) {
            return copy2(kryo, optional);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ Optional read(Kryo kryo, Input input, Class<Optional> cls) {
            return read2(kryo, input, cls);
        }

        @Override // com.esotericsoftware.kryo.Serializer
        public /* bridge */ /* synthetic */ void write(Kryo kryo, Output output, Optional optional) {
            write2(kryo, output, optional);
        }

        /* renamed from: copy, reason: avoid collision after fix types in other method */
        public Optional copy2(Kryo kryo, Optional optional) {
            return optional.isPresent() ? Optional.of(kryo.copy(optional.get())) : optional;
        }

        @Override // com.esotericsoftware.kryo.Serializer
        /* renamed from: read, reason: avoid collision after fix types in other method */
        public Optional read2(Kryo kryo, Input input, Class<Optional> cls) {
            return Optional.ofNullable(kryo.readClassAndObject(input));
        }

        /* renamed from: write, reason: avoid collision after fix types in other method */
        public void write2(Kryo kryo, Output output, Optional optional) {
            kryo.writeClassAndObject(output, optional.isPresent() ? optional.get() : null);
        }

        public /* synthetic */ OptionalSerializer(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static void addDefaultSerializers(Kryo kryo) {
        if (Util.isClassAvailable("java.util.Optional")) {
            kryo.addDefaultSerializer(Optional.class, new OptionalSerializer(null));
        }
        if (Util.isClassAvailable("java.util.OptionalInt")) {
            kryo.addDefaultSerializer(OptionalInt.class, new OptionalIntSerializer(null));
        }
        if (Util.isClassAvailable("java.util.OptionalLong")) {
            kryo.addDefaultSerializer(OptionalLong.class, new OptionalLongSerializer(null));
        }
        if (Util.isClassAvailable("java.util.OptionalDouble")) {
            kryo.addDefaultSerializer(OptionalDouble.class, new OptionalDoubleSerializer(null));
        }
    }
}
