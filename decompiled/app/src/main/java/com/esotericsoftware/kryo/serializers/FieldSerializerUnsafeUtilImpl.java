package com.esotericsoftware.kryo.serializers;

import b.e.a.Log;
import b.e.b.FieldAccess2;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.UnsafeCacheFields;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.UnsafeUtil;
import java.lang.reflect.Field;
import java.util.List;

/* loaded from: classes.dex */
public final class FieldSerializerUnsafeUtilImpl implements FieldSerializerUnsafeUtil {
    private FieldSerializer serializer;

    public FieldSerializerUnsafeUtilImpl(FieldSerializer fieldSerializer) {
        this.serializer = fieldSerializer;
    }

    private int fieldSizeOf(Class<?> cls) {
        if (cls == Integer.TYPE || cls == Float.TYPE) {
            return 4;
        }
        if (cls == Long.TYPE || cls == Double.TYPE) {
            return 8;
        }
        if (cls == Byte.TYPE || cls == Boolean.TYPE) {
            return 1;
        }
        if (cls == Short.TYPE || cls == Character.TYPE) {
            return 2;
        }
        return UnsafeUtil.unsafe().addressSize();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa  */
    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createUnsafeCacheFieldsAndRegions(List<Field> list, List<FieldSerializer.CachedField> list2, int i, IntArray intArray) {
        int i2;
        long j = 0;
        Field field = null;
        long j2 = -1;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        int i5 = -1;
        for (int size = list.size(); i3 < size; size = i2) {
            Field field2 = list.get(i3);
            if (this.serializer.access != null) {
                i2 = size;
                int iH = intArray.get(i + i3) == 1 ? ((FieldAccess2) this.serializer.access).h(field2.getName()) : -1;
                long jObjectFieldOffset = UnsafeUtil.unsafe().objectFieldOffset(field2);
                long jFieldSizeOf = jObjectFieldOffset + fieldSizeOf(field2.getType());
                if (field2.getType().isPrimitive() && z2) {
                    if (i4 > 1) {
                        Log.a aVar = Log.a;
                        UnsafeCacheFields.UnsafeRegionField unsafeRegionField = new UnsafeCacheFields.UnsafeRegionField(j, j2 - j);
                        unsafeRegionField.field = field;
                        list2.add(unsafeRegionField);
                    } else if (field != null) {
                        list2.add(this.serializer.newCachedField(field, list2.size(), i5));
                    }
                    list2.add(this.serializer.newCachedField(field2, list2.size(), iH));
                    z2 = false;
                } else if (field2.getType().isPrimitive()) {
                    list2.add(this.serializer.newCachedField(field2, list2.size(), iH));
                } else if (z2) {
                    i4++;
                } else {
                    j = jObjectFieldOffset;
                    z2 = true;
                    i4 = 1;
                }
                i3++;
                field = field2;
                i5 = iH;
                j2 = jFieldSizeOf;
            } else {
                i2 = size;
            }
            long jObjectFieldOffset2 = UnsafeUtil.unsafe().objectFieldOffset(field2);
            long jFieldSizeOf2 = jObjectFieldOffset2 + fieldSizeOf(field2.getType());
            if (field2.getType().isPrimitive()) {
                if (field2.getType().isPrimitive()) {
                }
            }
            i3++;
            field = field2;
            i5 = iH;
            j2 = jFieldSizeOf2;
        }
        if (!this.serializer.getUseAsmEnabled() && this.serializer.getUseMemRegions() && z2) {
            if (i4 <= 1) {
                if (field != null) {
                    list2.add(this.serializer.newCachedField(field, list2.size(), i5));
                }
            } else {
                Log.a aVar2 = Log.a;
                UnsafeCacheFields.UnsafeRegionField unsafeRegionField2 = new UnsafeCacheFields.UnsafeRegionField(j, j2 - j);
                unsafeRegionField2.field = field;
                list2.add(unsafeRegionField2);
            }
        }
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerUnsafeUtil
    public long getObjectFieldOffset(Field field) {
        return UnsafeUtil.unsafe().objectFieldOffset(field);
    }
}
