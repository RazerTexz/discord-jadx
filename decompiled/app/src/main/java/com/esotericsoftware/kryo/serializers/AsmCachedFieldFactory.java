package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.serializers.AsmCacheFields;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class AsmCachedFieldFactory implements FieldSerializer.CachedFieldFactory {
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedFieldFactory
    public FieldSerializer.CachedField createCachedField(Class cls, Field field, FieldSerializer fieldSerializer) {
        return cls.isPrimitive() ? cls == Boolean.TYPE ? new AsmCacheFields.AsmBooleanField() : cls == Byte.TYPE ? new AsmCacheFields.AsmByteField() : cls == Character.TYPE ? new AsmCacheFields.AsmCharField() : cls == Short.TYPE ? new AsmCacheFields.AsmShortField() : cls == Integer.TYPE ? new AsmCacheFields.AsmIntField() : cls == Long.TYPE ? new AsmCacheFields.AsmLongField() : cls == Float.TYPE ? new AsmCacheFields.AsmFloatField() : cls == Double.TYPE ? new AsmCacheFields.AsmDoubleField() : new AsmCacheFields.AsmObjectField(fieldSerializer) : (cls != String.class || (fieldSerializer.kryo.getReferences() && fieldSerializer.kryo.getReferenceResolver().useReferences(String.class))) ? new AsmCacheFields.AsmObjectField(fieldSerializer) : new AsmCacheFields.AsmStringField();
    }
}
