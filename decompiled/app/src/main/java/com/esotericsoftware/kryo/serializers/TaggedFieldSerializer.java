package com.esotericsoftware.kryo.serializers;

import b.d.b.a.outline;
import b.e.a.Log;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.InputChunked;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.OutputChunked;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes.dex */
public class TaggedFieldSerializer<T> extends FieldSerializer<T> {
    private static final Comparator<FieldSerializer.CachedField> TAGGED_VALUE_COMPARATOR = new AnonymousClass1();
    private boolean[] annexed;
    private boolean[] deprecated;
    private int[] tags;
    private int writeFieldCount;

    /* renamed from: com.esotericsoftware.kryo.serializers.TaggedFieldSerializer$1, reason: invalid class name */
    public static class AnonymousClass1 implements Comparator<FieldSerializer.CachedField> {
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(FieldSerializer.CachedField cachedField, FieldSerializer.CachedField cachedField2) {
            return compare2(cachedField, cachedField2);
        }

        /* renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(FieldSerializer.CachedField cachedField, FieldSerializer.CachedField cachedField2) {
            return ((Tag) cachedField.getField().getAnnotation(Tag.class)).value() - ((Tag) cachedField2.getField().getAnnotation(Tag.class)).value();
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Tag {
        boolean annexed() default false;

        int value();
    }

    public TaggedFieldSerializer(Kryo kryo, Class cls) {
        super(kryo, cls, null, kryo.getTaggedFieldSerializerConfig().clone());
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer
    public void initializeCachedFields() {
        FieldSerializer.CachedField[] fields = getFields();
        int length = fields.length;
        for (int i = 0; i < length; i++) {
            if (fields[i].getField().getAnnotation(Tag.class) == null) {
                Log.a aVar = Log.a;
                super.removeField(fields[i]);
            }
        }
        FieldSerializer.CachedField[] fields2 = getFields();
        this.tags = new int[fields2.length];
        this.deprecated = new boolean[fields2.length];
        this.annexed = new boolean[fields2.length];
        this.writeFieldCount = fields2.length;
        Arrays.sort(fields2, TAGGED_VALUE_COMPARATOR);
        int length2 = fields2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Field field = fields2[i2].getField();
            this.tags[i2] = ((Tag) field.getAnnotation(Tag.class)).value();
            if (i2 > 0) {
                int[] iArr = this.tags;
                int i3 = i2 - 1;
                if (iArr[i2] == iArr[i3]) {
                    throw new KryoException(String.format("The fields [%s] and [%s] both have a Tag value of %d.", field, fields2[i3].getField(), Integer.valueOf(this.tags[i2])));
                }
            }
            if (field.getAnnotation(Deprecated.class) != null) {
                this.deprecated[i2] = true;
                this.writeFieldCount--;
            }
            if (((Tag) field.getAnnotation(Tag.class)).annexed()) {
                this.annexed[i2] = true;
            }
        }
        this.removedFields.clear();
    }

    @Deprecated
    public boolean isIgnoreUnkownTags() {
        return false;
    }

    public boolean isSkipUnknownTags() {
        return ((TaggedFieldSerializerConfig) this.config).isSkipUnknownTags();
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer, com.esotericsoftware.kryo.Serializer
    public T read(Kryo kryo, Input input, Class<T> cls) throws IOException, KryoException {
        boolean z2;
        FieldSerializer.CachedField cachedField;
        T tCreate = create(kryo, input, cls);
        kryo.reference(tCreate);
        int varInt = input.readVarInt(true);
        int[] iArr = this.tags;
        FieldSerializer.CachedField[] fields = getFields();
        InputChunked inputChunked = null;
        for (int i = 0; i < varInt; i++) {
            int varInt2 = input.readVarInt(true);
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    cachedField = null;
                    break;
                }
                if (iArr[i2] == varInt2) {
                    cachedField = fields[i2];
                    z2 = this.annexed[i2];
                    break;
                }
                i2++;
            }
            if (cachedField == null) {
                if (!isSkipUnknownTags()) {
                    StringBuilder sbV = outline.V("Unknown field tag: ", varInt2, " (");
                    sbV.append(getType().getName());
                    sbV.append(")");
                    throw new KryoException(sbV.toString());
                }
                if (inputChunked == null) {
                    inputChunked = new InputChunked(input, 1024);
                }
                inputChunked.nextChunks();
                Log.a aVar = Log.a;
            } else if (z2) {
                if (inputChunked == null) {
                    inputChunked = new InputChunked(input, 1024);
                }
                cachedField.read(inputChunked, tCreate);
                inputChunked.nextChunks();
            } else {
                cachedField.read(input, tCreate);
            }
        }
        return tCreate;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer
    public void removeField(String str) {
        super.removeField(str);
        initializeCachedFields();
    }

    @Deprecated
    public void setIgnoreUnknownTags(boolean z2) {
    }

    public void setSkipUnknownTags(boolean z2) {
        ((TaggedFieldSerializerConfig) this.config).setSkipUnknownTags(z2);
        rebuildCachedFields();
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer, com.esotericsoftware.kryo.Serializer
    public void write(Kryo kryo, Output output, T t) throws IOException, KryoException {
        FieldSerializer.CachedField[] fields = getFields();
        output.writeVarInt(this.writeFieldCount, true);
        int length = fields.length;
        OutputChunked outputChunked = null;
        for (int i = 0; i < length; i++) {
            if (!this.deprecated[i]) {
                output.writeVarInt(this.tags[i], true);
                if (this.annexed[i]) {
                    if (outputChunked == null) {
                        outputChunked = new OutputChunked(output, 1024);
                    }
                    fields[i].write(outputChunked, t);
                    outputChunked.endChunks();
                } else {
                    fields[i].write(output, t);
                }
            }
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer
    public void removeField(FieldSerializer.CachedField cachedField) {
        super.removeField(cachedField);
        initializeCachedFields();
    }
}
