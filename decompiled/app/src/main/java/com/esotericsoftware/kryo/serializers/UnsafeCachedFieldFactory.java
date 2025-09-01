package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.UnsafeCacheFields;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class UnsafeCachedFieldFactory implements FieldSerializer.CachedFieldFactory {
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedFieldFactory
    public FieldSerializer.CachedField createCachedField(Class cls, Field field, FieldSerializer fieldSerializer) {
        return cls.isPrimitive() ? cls == Boolean.TYPE ? new UnsafeCacheFields.UnsafeBooleanField(field) : cls == Byte.TYPE ? new UnsafeCacheFields.UnsafeByteField(field) : cls == Character.TYPE ? new UnsafeCacheFields.UnsafeCharField(field) : cls == Short.TYPE ? new UnsafeCacheFields.UnsafeShortField(field) : cls == Integer.TYPE ? new UnsafeCacheFields.UnsafeIntField(field) : cls == Long.TYPE ? new UnsafeCacheFields.UnsafeLongField(field) : cls == Float.TYPE ? new UnsafeCacheFields.UnsafeFloatField(field) : cls == Double.TYPE ? new UnsafeCacheFields.UnsafeDoubleField(field) : new UnsafeCacheFields.UnsafeObjectField(fieldSerializer) : (cls != String.class || (fieldSerializer.kryo.getReferences() && fieldSerializer.kryo.getReferenceResolver().useReferences(String.class))) ? new UnsafeCacheFields.UnsafeObjectField(fieldSerializer) : new UnsafeCacheFields.UnsafeStringField(field);
    }
}
