package com.esotericsoftware.kryo.serializers;

import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.ObjectField;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class ObjectCachedFieldFactory implements FieldSerializer.CachedFieldFactory {
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializer.CachedFieldFactory
    public FieldSerializer.CachedField createCachedField(Class cls, Field field, FieldSerializer fieldSerializer) {
        return cls.isPrimitive() ? cls == Boolean.TYPE ? new ObjectField.ObjectBooleanField(fieldSerializer) : cls == Byte.TYPE ? new ObjectField.ObjectByteField(fieldSerializer) : cls == Character.TYPE ? new ObjectField.ObjectCharField(fieldSerializer) : cls == Short.TYPE ? new ObjectField.ObjectShortField(fieldSerializer) : cls == Integer.TYPE ? new ObjectField.ObjectIntField(fieldSerializer) : cls == Long.TYPE ? new ObjectField.ObjectLongField(fieldSerializer) : cls == Float.TYPE ? new ObjectField.ObjectFloatField(fieldSerializer) : cls == Double.TYPE ? new ObjectField.ObjectDoubleField(fieldSerializer) : new ObjectField(fieldSerializer) : new ObjectField(fieldSerializer);
    }
}
