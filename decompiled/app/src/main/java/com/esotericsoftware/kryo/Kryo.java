package com.esotericsoftware.kryo;

import b.d.b.a.outline;
import b.e.a.Log;
import b.e.b.ConstructorAccess;
import com.esotericsoftware.kryo.factories.PseudoSerializerFactory;
import com.esotericsoftware.kryo.factories.ReflectionSerializerFactory;
import com.esotericsoftware.kryo.factories.SerializerFactory;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.ClosureSerializer;
import com.esotericsoftware.kryo.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.serializers.DefaultArraySerializers;
import com.esotericsoftware.kryo.serializers.DefaultSerializers;
import com.esotericsoftware.kryo.serializers.FieldSerializer;
import com.esotericsoftware.kryo.serializers.FieldSerializerConfig;
import com.esotericsoftware.kryo.serializers.GenericsResolver;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import com.esotericsoftware.kryo.serializers.OptionalSerializers;
import com.esotericsoftware.kryo.serializers.TaggedFieldSerializerConfig;
import com.esotericsoftware.kryo.serializers.TimeSerializers;
import com.esotericsoftware.kryo.util.DefaultClassResolver;
import com.esotericsoftware.kryo.util.DefaultStreamFactory;
import com.esotericsoftware.kryo.util.IdentityMap;
import com.esotericsoftware.kryo.util.IntArray;
import com.esotericsoftware.kryo.util.MapReferenceResolver;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.esotericsoftware.kryo.util.Util;
import h0.b.a.ObjectInstantiator;
import h0.b.b.InstantiatorStrategy;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class Kryo {
    public static final byte NOT_NULL = 1;
    private static final int NO_REF = -2;
    public static final byte NULL = 0;
    private static final int REF = -1;
    private boolean autoReset;
    private ClassLoader classLoader;
    private final ClassResolver classResolver;
    private ObjectMap context;
    private int copyDepth;
    private boolean copyReferences;
    private boolean copyShallow;
    private SerializerFactory defaultSerializer;
    private final ArrayList<DefaultSerializerEntry> defaultSerializers;
    private int depth;
    private FieldSerializerConfig fieldSerializerConfig;
    private GenericsResolver genericsResolver;
    private ObjectMap graphContext;
    private final int lowPriorityDefaultSerializerCount;
    private int maxDepth;
    private Object needsCopyReference;
    private int nextRegisterID;
    private IdentityMap originalToCopy;
    private Object readObject;
    private final IntArray readReferenceIds;
    private ReferenceResolver referenceResolver;
    private boolean references;
    private boolean registrationRequired;
    private InstantiatorStrategy strategy;
    private StreamFactory streamFactory;
    private TaggedFieldSerializerConfig taggedFieldSerializerConfig;
    private volatile Thread thread;
    private boolean warnUnregisteredClasses;

    public static class DefaultInstantiatorStrategy implements InstantiatorStrategy {
        private InstantiatorStrategy fallbackStrategy;

        /* renamed from: com.esotericsoftware.kryo.Kryo$DefaultInstantiatorStrategy$1, reason: invalid class name */
        public class AnonymousClass1 implements ObjectInstantiator {
            public final /* synthetic */ ConstructorAccess val$access;
            public final /* synthetic */ Class val$type;

            public AnonymousClass1(ConstructorAccess constructorAccess, Class cls) {
                this.val$access = constructorAccess;
                this.val$type = cls;
            }

            @Override // h0.b.a.ObjectInstantiator
            public Object newInstance() {
                try {
                    return this.val$access.c();
                } catch (Exception e) {
                    StringBuilder sbU = outline.U("Error constructing instance of class: ");
                    sbU.append(Util.className(this.val$type));
                    throw new KryoException(sbU.toString(), e);
                }
            }
        }

        /* renamed from: com.esotericsoftware.kryo.Kryo$DefaultInstantiatorStrategy$2, reason: invalid class name */
        public class AnonymousClass2 implements ObjectInstantiator {
            public final /* synthetic */ Constructor val$constructor;
            public final /* synthetic */ Class val$type;

            public AnonymousClass2(Constructor constructor, Class cls) {
                this.val$constructor = constructor;
                this.val$type = cls;
            }

            @Override // h0.b.a.ObjectInstantiator
            public Object newInstance() {
                try {
                    return this.val$constructor.newInstance(new Object[0]);
                } catch (Exception e) {
                    StringBuilder sbU = outline.U("Error constructing instance of class: ");
                    sbU.append(Util.className(this.val$type));
                    throw new KryoException(sbU.toString(), e);
                }
            }
        }

        public DefaultInstantiatorStrategy() {
        }

        public InstantiatorStrategy getFallbackInstantiatorStrategy() {
            return this.fallbackStrategy;
        }

        @Override // h0.b.b.InstantiatorStrategy
        public ObjectInstantiator newInstantiatorOf(Class cls) throws NoSuchMethodException, SecurityException {
            Constructor declaredConstructor;
            if (!Util.IS_ANDROID) {
                if (!((cls.getEnclosingClass() == null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? false : true)) {
                    try {
                        return new AnonymousClass1(ConstructorAccess.a(cls), cls);
                    } catch (Exception unused) {
                    }
                }
            }
            try {
                try {
                    declaredConstructor = cls.getConstructor(null);
                } catch (Exception unused2) {
                    declaredConstructor = cls.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                }
                return new AnonymousClass2(declaredConstructor, cls);
            } catch (Exception unused3) {
                InstantiatorStrategy instantiatorStrategy = this.fallbackStrategy;
                if (instantiatorStrategy != null) {
                    return instantiatorStrategy.newInstantiatorOf(cls);
                }
                if (cls.isMemberClass() && !Modifier.isStatic(cls.getModifiers())) {
                    StringBuilder sbU = outline.U("Class cannot be created (non-static member class): ");
                    sbU.append(Util.className(cls));
                    throw new KryoException(sbU.toString());
                }
                StringBuilder sbU2 = outline.U("Class cannot be created (missing no-arg constructor): ");
                sbU2.append(Util.className(cls));
                StringBuilder sb = new StringBuilder(sbU2.toString());
                if (cls.getSimpleName().equals("")) {
                    outline.s0(sb, "\n\tThis is an anonymous class, which is not serializable by default in Kryo. Possible solutions: ", "1. Remove uses of anonymous classes, including double brace initialization, from the containing ", "class. This is the safest solution, as anonymous classes don't have predictable names for serialization.", "\n\t2. Register a FieldSerializer for the containing class and call ");
                    sb.append("FieldSerializer#setIgnoreSyntheticFields(false) on it. This is not safe but may be sufficient temporarily. ");
                    sb.append("Use at your own risk.");
                }
                throw new KryoException(sb.toString());
            }
        }

        public void setFallbackInstantiatorStrategy(InstantiatorStrategy instantiatorStrategy) {
            this.fallbackStrategy = instantiatorStrategy;
        }

        public DefaultInstantiatorStrategy(InstantiatorStrategy instantiatorStrategy) {
            this.fallbackStrategy = instantiatorStrategy;
        }
    }

    public static final class DefaultSerializerEntry {
        public final SerializerFactory serializerFactory;
        public final Class type;

        public DefaultSerializerEntry(Class cls, SerializerFactory serializerFactory) {
            this.type = cls;
            this.serializerFactory = serializerFactory;
        }
    }

    public Kryo() {
        this(new DefaultClassResolver(), new MapReferenceResolver(), new DefaultStreamFactory());
    }

    private void beginObject() {
        Log.a aVar = Log.a;
        int i = this.depth;
        if (i != this.maxDepth) {
            this.depth = i + 1;
        } else {
            StringBuilder sbU = outline.U("Max depth exceeded: ");
            sbU.append(this.depth);
            throw new KryoException(sbU.toString());
        }
    }

    public void addDefaultSerializer(Class cls, Serializer serializer) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        DefaultSerializerEntry defaultSerializerEntry = new DefaultSerializerEntry(cls, new PseudoSerializerFactory(serializer));
        ArrayList<DefaultSerializerEntry> arrayList = this.defaultSerializers;
        arrayList.add(arrayList.size() - this.lowPriorityDefaultSerializerCount, defaultSerializerEntry);
    }

    public <T> T copy(T t) {
        if (t == null) {
            return null;
        }
        if (this.copyShallow) {
            return t;
        }
        this.copyDepth++;
        try {
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            T t2 = (T) this.originalToCopy.get(t);
            if (t2 != null) {
                return t2;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t;
            }
            T t3 = t instanceof KryoCopyable ? (T) ((KryoCopyable) t).copy(this) : (T) getSerializer(t.getClass()).copy(this, t);
            if (this.needsCopyReference != null) {
                reference(t3);
            }
            Log.a aVar = Log.a;
            int i = this.copyDepth - 1;
            this.copyDepth = i;
            if (i == 0) {
                reset();
            }
            return t3;
        } finally {
            int i2 = this.copyDepth - 1;
            this.copyDepth = i2;
            if (i2 == 0) {
                reset();
            }
        }
    }

    public <T> T copyShallow(T t) {
        if (t == null) {
            return null;
        }
        this.copyDepth++;
        this.copyShallow = true;
        try {
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            T t2 = (T) this.originalToCopy.get(t);
            if (t2 != null) {
                return t2;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t;
            }
            T t3 = t instanceof KryoCopyable ? (T) ((KryoCopyable) t).copy(this) : (T) getSerializer(t.getClass()).copy(this, t);
            if (this.needsCopyReference != null) {
                reference(t3);
            }
            Log.a aVar = Log.a;
            this.copyShallow = false;
            int i = this.copyDepth - 1;
            this.copyDepth = i;
            if (i == 0) {
                reset();
            }
            return t3;
        } finally {
            this.copyShallow = false;
            int i2 = this.copyDepth - 1;
            this.copyDepth = i2;
            if (i2 == 0) {
                reset();
            }
        }
    }

    @Deprecated
    public boolean getAsmEnabled() {
        return this.fieldSerializerConfig.isUseAsm();
    }

    public ClassLoader getClassLoader() {
        return this.classLoader;
    }

    public ClassResolver getClassResolver() {
        return this.classResolver;
    }

    public ObjectMap getContext() {
        if (this.context == null) {
            this.context = new ObjectMap();
        }
        return this.context;
    }

    public Serializer getDefaultSerializer(Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        Serializer defaultSerializerForAnnotatedType = getDefaultSerializerForAnnotatedType(cls);
        if (defaultSerializerForAnnotatedType != null) {
            return defaultSerializerForAnnotatedType;
        }
        int size = this.defaultSerializers.size();
        for (int i = 0; i < size; i++) {
            DefaultSerializerEntry defaultSerializerEntry = this.defaultSerializers.get(i);
            if (defaultSerializerEntry.type.isAssignableFrom(cls)) {
                return defaultSerializerEntry.serializerFactory.makeSerializer(this, cls);
            }
        }
        return newDefaultSerializer(cls);
    }

    public Serializer getDefaultSerializerForAnnotatedType(Class cls) {
        if (cls.isAnnotationPresent(DefaultSerializer.class)) {
            return ReflectionSerializerFactory.makeSerializer(this, ((DefaultSerializer) cls.getAnnotation(DefaultSerializer.class)).value(), cls);
        }
        return null;
    }

    public int getDepth() {
        return this.depth;
    }

    public FieldSerializerConfig getFieldSerializerConfig() {
        return this.fieldSerializerConfig;
    }

    public GenericsResolver getGenericsResolver() {
        return this.genericsResolver;
    }

    public ObjectMap getGraphContext() {
        if (this.graphContext == null) {
            this.graphContext = new ObjectMap();
        }
        return this.graphContext;
    }

    public InstantiatorStrategy getInstantiatorStrategy() {
        return this.strategy;
    }

    public int getNextRegistrationId() {
        while (true) {
            int i = this.nextRegisterID;
            if (i == -2) {
                throw new KryoException("No registration IDs are available.");
            }
            if (this.classResolver.getRegistration(i) == null) {
                return this.nextRegisterID;
            }
            this.nextRegisterID++;
        }
    }

    public IdentityMap getOriginalToCopyMap() {
        return this.originalToCopy;
    }

    public ReferenceResolver getReferenceResolver() {
        return this.referenceResolver;
    }

    public boolean getReferences() {
        return this.references;
    }

    public Registration getRegistration(Class cls) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        Registration registration = this.classResolver.getRegistration(cls);
        if (registration != null) {
            return registration;
        }
        if (Proxy.isProxyClass(cls)) {
            registration = getRegistration(InvocationHandler.class);
        } else if (!cls.isEnum() && Enum.class.isAssignableFrom(cls) && !Enum.class.equals(cls)) {
            registration = getRegistration(cls.getEnclosingClass());
        } else if (EnumSet.class.isAssignableFrom(cls)) {
            registration = this.classResolver.getRegistration(EnumSet.class);
        } else if (isClosure(cls)) {
            registration = this.classResolver.getRegistration(ClosureSerializer.Closure.class);
        }
        if (registration != null) {
            return registration;
        }
        if (this.registrationRequired) {
            throw new IllegalArgumentException(unregisteredClassMessage(cls));
        }
        if (this.warnUnregisteredClasses) {
            Log.a.a(4, null, unregisteredClassMessage(cls), null);
        }
        return this.classResolver.registerImplicit(cls);
    }

    public Serializer getSerializer(Class cls) {
        return getRegistration(cls).getSerializer();
    }

    public StreamFactory getStreamFactory() {
        return this.streamFactory;
    }

    public TaggedFieldSerializerConfig getTaggedFieldSerializerConfig() {
        return this.taggedFieldSerializerConfig;
    }

    public boolean isClosure(Class cls) {
        if (cls != null) {
            return cls.getName().indexOf(47) >= 0;
        }
        throw new IllegalArgumentException("type cannot be null.");
    }

    public boolean isFinal(Class cls) {
        if (cls != null) {
            return cls.isArray() ? Modifier.isFinal(Util.getElementClass(cls).getModifiers()) : Modifier.isFinal(cls.getModifiers());
        }
        throw new IllegalArgumentException("type cannot be null.");
    }

    public boolean isRegistrationRequired() {
        return this.registrationRequired;
    }

    public boolean isWarnUnregisteredClasses() {
        return this.warnUnregisteredClasses;
    }

    public Serializer newDefaultSerializer(Class cls) {
        return this.defaultSerializer.makeSerializer(this, cls);
    }

    public <T> T newInstance(Class<T> cls) {
        Registration registration = getRegistration(cls);
        ObjectInstantiator instantiator = registration.getInstantiator();
        if (instantiator == null) {
            instantiator = newInstantiator(cls);
            registration.setInstantiator(instantiator);
        }
        return (T) instantiator.newInstance();
    }

    public ObjectInstantiator newInstantiator(Class cls) {
        return this.strategy.newInstantiatorOf(cls);
    }

    public Registration readClass(Input input) {
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        try {
            return this.classResolver.readClass(input);
        } finally {
            if (this.depth == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public Object readClassAndObject(Input input) {
        Object obj;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        beginObject();
        try {
            Registration registration = readClass(input);
            if (registration == null) {
                return null;
            }
            Class type = registration.getType();
            if (this.references) {
                registration.getSerializer().setGenerics(this, null);
                int referenceOrNull = readReferenceOrNull(input, type, false);
                if (referenceOrNull == -1) {
                    Object obj2 = this.readObject;
                    int i = this.depth - 1;
                    this.depth = i;
                    if (i == 0 && this.autoReset) {
                        reset();
                    }
                    return obj2;
                }
                obj = registration.getSerializer().read(this, input, type);
                if (referenceOrNull == this.readReferenceIds.size) {
                    reference(obj);
                }
            } else {
                obj = registration.getSerializer().read(this, input, type);
            }
            Log.a aVar = Log.a;
            int i2 = this.depth - 1;
            this.depth = i2;
            if (i2 == 0 && this.autoReset) {
                reset();
            }
            return obj;
        } finally {
            int i3 = this.depth - 1;
            this.depth = i3;
            if (i3 == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public <T> T readObject(Input input, Class<T> cls) {
        T t;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        beginObject();
        try {
            if (this.references) {
                int referenceOrNull = readReferenceOrNull(input, cls, false);
                if (referenceOrNull == -1) {
                    return (T) this.readObject;
                }
                t = (T) getRegistration(cls).getSerializer().read(this, input, cls);
                if (referenceOrNull == this.readReferenceIds.size) {
                    reference(t);
                }
            } else {
                t = (T) getRegistration(cls).getSerializer().read(this, input, cls);
            }
            Log.a aVar = Log.a;
            int i = this.depth - 1;
            this.depth = i;
            if (i == 0 && this.autoReset) {
                reset();
            }
            return t;
        } finally {
            int i2 = this.depth - 1;
            this.depth = i2;
            if (i2 == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public <T> T readObjectOrNull(Input input, Class<T> cls) {
        T t;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        beginObject();
        try {
            if (this.references) {
                int referenceOrNull = readReferenceOrNull(input, cls, true);
                if (referenceOrNull == -1) {
                    return (T) this.readObject;
                }
                t = (T) getRegistration(cls).getSerializer().read(this, input, cls);
                if (referenceOrNull == this.readReferenceIds.size) {
                    reference(t);
                }
            } else {
                Serializer serializer = getRegistration(cls).getSerializer();
                if (!serializer.getAcceptsNull() && input.readByte() == 0) {
                    Log.a aVar = Log.a;
                    int i = this.depth - 1;
                    this.depth = i;
                    if (i == 0 && this.autoReset) {
                        reset();
                    }
                    return null;
                }
                t = (T) serializer.read(this, input, cls);
            }
            Log.a aVar2 = Log.a;
            int i2 = this.depth - 1;
            this.depth = i2;
            if (i2 == 0 && this.autoReset) {
                reset();
            }
            return t;
        } finally {
            int i3 = this.depth - 1;
            this.depth = i3;
            if (i3 == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public int readReferenceOrNull(Input input, Class cls, boolean z2) throws KryoException {
        int varInt;
        if (cls.isPrimitive()) {
            cls = Util.getWrapperClass(cls);
        }
        boolean zUseReferences = this.referenceResolver.useReferences(cls);
        if (z2) {
            varInt = input.readVarInt(true);
            if (varInt == 0) {
                Log.a aVar = Log.a;
                this.readObject = null;
                return -1;
            }
            if (!zUseReferences) {
                this.readReferenceIds.add(-2);
                return this.readReferenceIds.size;
            }
        } else {
            if (!zUseReferences) {
                this.readReferenceIds.add(-2);
                return this.readReferenceIds.size;
            }
            varInt = input.readVarInt(true);
        }
        if (varInt == 1) {
            int iNextReadId = this.referenceResolver.nextReadId(cls);
            Log.a aVar2 = Log.a;
            this.readReferenceIds.add(iNextReadId);
            return this.readReferenceIds.size;
        }
        this.readObject = this.referenceResolver.getReadObject(cls, varInt - 2);
        Log.a aVar3 = Log.a;
        return -1;
    }

    public void reference(Object obj) {
        int iPop;
        if (this.copyDepth <= 0) {
            if (!this.references || obj == null || (iPop = this.readReferenceIds.pop()) == -2) {
                return;
            }
            this.referenceResolver.setReadObject(iPop, obj);
            return;
        }
        Object obj2 = this.needsCopyReference;
        if (obj2 != null) {
            if (obj == null) {
                throw new IllegalArgumentException("object cannot be null.");
            }
            this.originalToCopy.put(obj2, obj);
            this.needsCopyReference = null;
        }
    }

    public Registration register(Class cls) {
        Registration registration = this.classResolver.getRegistration(cls);
        return registration != null ? registration : register(cls, getDefaultSerializer(cls));
    }

    public void reset() {
        this.depth = 0;
        ObjectMap objectMap = this.graphContext;
        if (objectMap != null) {
            objectMap.clear();
        }
        this.classResolver.reset();
        if (this.references) {
            this.referenceResolver.reset();
            this.readObject = null;
        }
        this.copyDepth = 0;
        IdentityMap identityMap = this.originalToCopy;
        if (identityMap != null) {
            identityMap.clear(2048);
        }
        Log.a aVar = Log.a;
    }

    @Deprecated
    public void setAsmEnabled(boolean z2) {
        this.fieldSerializerConfig.setUseAsm(z2);
    }

    public void setAutoReset(boolean z2) {
        this.autoReset = z2;
    }

    public void setClassLoader(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new IllegalArgumentException("classLoader cannot be null.");
        }
        this.classLoader = classLoader;
    }

    public void setCopyReferences(boolean z2) {
        this.copyReferences = z2;
    }

    public void setDefaultSerializer(SerializerFactory serializerFactory) {
        if (serializerFactory == null) {
            throw new IllegalArgumentException("serializer cannot be null.");
        }
        this.defaultSerializer = serializerFactory;
    }

    public void setInstantiatorStrategy(InstantiatorStrategy instantiatorStrategy) {
        this.strategy = instantiatorStrategy;
    }

    public void setMaxDepth(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxDepth must be > 0.");
        }
        this.maxDepth = i;
    }

    public void setReferenceResolver(ReferenceResolver referenceResolver) {
        if (referenceResolver == null) {
            throw new IllegalArgumentException("referenceResolver cannot be null.");
        }
        this.references = true;
        this.referenceResolver = referenceResolver;
        Log.a aVar = Log.a;
    }

    public boolean setReferences(boolean z2) {
        if (z2 == this.references) {
            return z2;
        }
        this.references = z2;
        if (z2 && this.referenceResolver == null) {
            this.referenceResolver = new MapReferenceResolver();
        }
        Log.a aVar = Log.a;
        return !z2;
    }

    public void setRegistrationRequired(boolean z2) {
        this.registrationRequired = z2;
        Log.a aVar = Log.a;
    }

    public void setStreamFactory(StreamFactory streamFactory) {
        this.streamFactory = streamFactory;
    }

    public void setWarnUnregisteredClasses(boolean z2) {
        this.warnUnregisteredClasses = z2;
        Log.a aVar = Log.a;
    }

    public String unregisteredClassMessage(Class cls) {
        StringBuilder sbU = outline.U("Class is not registered: ");
        sbU.append(Util.className(cls));
        sbU.append("\nNote: To register this class use: kryo.register(");
        sbU.append(Util.className(cls));
        sbU.append(".class);");
        return sbU.toString();
    }

    public Registration writeClass(Output output, Class cls) {
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        try {
            return this.classResolver.writeClass(output, cls);
        } finally {
            if (this.depth == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public void writeClassAndObject(Output output, Object obj) {
        int i;
        boolean z2;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        beginObject();
        try {
            if (obj == null) {
                writeClass(output, null);
                if (i == 0) {
                    if (z2) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            Registration registrationWriteClass = writeClass(output, obj.getClass());
            if (this.references && writeReferenceOrNull(output, obj, false)) {
                registrationWriteClass.getSerializer().setGenerics(this, null);
                int i2 = this.depth - 1;
                this.depth = i2;
                if (i2 == 0 && this.autoReset) {
                    reset();
                    return;
                }
                return;
            }
            Log.a aVar = Log.a;
            registrationWriteClass.getSerializer().write(this, output, obj);
            int i3 = this.depth - 1;
            this.depth = i3;
            if (i3 == 0 && this.autoReset) {
                reset();
            }
        } finally {
            i = this.depth - 1;
            this.depth = i;
            if (i == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public void writeObject(Output output, Object obj) {
        int i;
        boolean z2;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (obj == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        beginObject();
        try {
            if (this.references && writeReferenceOrNull(output, obj, false)) {
                getRegistration(obj.getClass()).getSerializer().setGenerics(this, null);
                if (i == 0) {
                    if (z2) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            Log.a aVar = Log.a;
            getRegistration(obj.getClass()).getSerializer().write(this, output, obj);
            int i2 = this.depth - 1;
            this.depth = i2;
            if (i2 == 0 && this.autoReset) {
                reset();
            }
        } finally {
            i = this.depth - 1;
            this.depth = i;
            if (i == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public void writeObjectOrNull(Output output, Object obj, Class cls) {
        int i;
        boolean z2;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        beginObject();
        try {
            Serializer serializer = getRegistration(cls).getSerializer();
            if (this.references) {
                if (writeReferenceOrNull(output, obj, true)) {
                    serializer.setGenerics(this, null);
                    if (i == 0) {
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
            } else if (!serializer.getAcceptsNull()) {
                if (obj == null) {
                    Log.a aVar = Log.a;
                    output.writeByte((byte) 0);
                    int i2 = this.depth - 1;
                    this.depth = i2;
                    if (i2 == 0 && this.autoReset) {
                        reset();
                        return;
                    }
                    return;
                }
                output.writeByte((byte) 1);
            }
            Log.a aVar2 = Log.a;
            serializer.write(this, output, obj);
            int i3 = this.depth - 1;
            this.depth = i3;
            if (i3 == 0 && this.autoReset) {
                reset();
            }
        } finally {
            i = this.depth - 1;
            this.depth = i;
            if (i == 0 && this.autoReset) {
                reset();
            }
        }
    }

    public boolean writeReferenceOrNull(Output output, Object obj, boolean z2) throws IOException, KryoException {
        if (obj == null) {
            Log.a aVar = Log.a;
            output.writeVarInt(0, true);
            return true;
        }
        if (!this.referenceResolver.useReferences(obj.getClass())) {
            if (z2) {
                output.writeVarInt(1, true);
            }
            return false;
        }
        int writtenId = this.referenceResolver.getWrittenId(obj);
        if (writtenId != -1) {
            Log.a aVar2 = Log.a;
            output.writeVarInt(writtenId + 2, true);
            return true;
        }
        this.referenceResolver.addWrittenObject(obj);
        output.writeVarInt(1, true);
        Log.a aVar3 = Log.a;
        return false;
    }

    public Kryo(ReferenceResolver referenceResolver) {
        this(new DefaultClassResolver(), referenceResolver, new DefaultStreamFactory());
    }

    public Kryo(ClassResolver classResolver, ReferenceResolver referenceResolver) {
        this(classResolver, referenceResolver, new DefaultStreamFactory());
    }

    public Registration register(Class cls, int i) {
        Registration registration = this.classResolver.getRegistration(cls);
        return registration != null ? registration : register(cls, getDefaultSerializer(cls), i);
    }

    public void setDefaultSerializer(Class<? extends Serializer> cls) {
        if (cls != null) {
            this.defaultSerializer = new ReflectionSerializerFactory(cls);
            return;
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }

    public Kryo(ClassResolver classResolver, ReferenceResolver referenceResolver, StreamFactory streamFactory) {
        this.defaultSerializer = new ReflectionSerializerFactory(FieldSerializer.class);
        ArrayList<DefaultSerializerEntry> arrayList = new ArrayList<>(33);
        this.defaultSerializers = arrayList;
        this.classLoader = getClass().getClassLoader();
        this.strategy = new DefaultInstantiatorStrategy();
        this.maxDepth = Integer.MAX_VALUE;
        this.autoReset = true;
        this.readReferenceIds = new IntArray(0);
        this.copyReferences = true;
        this.genericsResolver = new GenericsResolver();
        this.fieldSerializerConfig = new FieldSerializerConfig();
        this.taggedFieldSerializerConfig = new TaggedFieldSerializerConfig();
        if (classResolver != null) {
            this.classResolver = classResolver;
            classResolver.setKryo(this);
            this.streamFactory = streamFactory;
            streamFactory.setKryo(this);
            this.referenceResolver = referenceResolver;
            if (referenceResolver != null) {
                referenceResolver.setKryo(this);
                this.references = true;
            }
            addDefaultSerializer(byte[].class, DefaultArraySerializers.ByteArraySerializer.class);
            addDefaultSerializer(char[].class, DefaultArraySerializers.CharArraySerializer.class);
            addDefaultSerializer(short[].class, DefaultArraySerializers.ShortArraySerializer.class);
            addDefaultSerializer(int[].class, DefaultArraySerializers.IntArraySerializer.class);
            addDefaultSerializer(long[].class, DefaultArraySerializers.LongArraySerializer.class);
            addDefaultSerializer(float[].class, DefaultArraySerializers.FloatArraySerializer.class);
            addDefaultSerializer(double[].class, DefaultArraySerializers.DoubleArraySerializer.class);
            addDefaultSerializer(boolean[].class, DefaultArraySerializers.BooleanArraySerializer.class);
            addDefaultSerializer(String[].class, DefaultArraySerializers.StringArraySerializer.class);
            addDefaultSerializer(Object[].class, DefaultArraySerializers.ObjectArraySerializer.class);
            addDefaultSerializer(KryoSerializable.class, DefaultSerializers.KryoSerializableSerializer.class);
            addDefaultSerializer(BigInteger.class, DefaultSerializers.BigIntegerSerializer.class);
            addDefaultSerializer(BigDecimal.class, DefaultSerializers.BigDecimalSerializer.class);
            addDefaultSerializer(Class.class, DefaultSerializers.ClassSerializer.class);
            addDefaultSerializer(Date.class, DefaultSerializers.DateSerializer.class);
            addDefaultSerializer(Enum.class, DefaultSerializers.EnumSerializer.class);
            addDefaultSerializer(EnumSet.class, DefaultSerializers.EnumSetSerializer.class);
            addDefaultSerializer(Currency.class, DefaultSerializers.CurrencySerializer.class);
            addDefaultSerializer(StringBuffer.class, DefaultSerializers.StringBufferSerializer.class);
            addDefaultSerializer(StringBuilder.class, DefaultSerializers.StringBuilderSerializer.class);
            addDefaultSerializer(Collections.EMPTY_LIST.getClass(), DefaultSerializers.CollectionsEmptyListSerializer.class);
            addDefaultSerializer(Collections.EMPTY_MAP.getClass(), DefaultSerializers.CollectionsEmptyMapSerializer.class);
            addDefaultSerializer(Collections.EMPTY_SET.getClass(), DefaultSerializers.CollectionsEmptySetSerializer.class);
            addDefaultSerializer(Collections.singletonList(null).getClass(), DefaultSerializers.CollectionsSingletonListSerializer.class);
            addDefaultSerializer(Collections.singletonMap(null, null).getClass(), DefaultSerializers.CollectionsSingletonMapSerializer.class);
            addDefaultSerializer(Collections.singleton(null).getClass(), DefaultSerializers.CollectionsSingletonSetSerializer.class);
            addDefaultSerializer(TreeSet.class, DefaultSerializers.TreeSetSerializer.class);
            addDefaultSerializer(Collection.class, CollectionSerializer.class);
            addDefaultSerializer(TreeMap.class, DefaultSerializers.TreeMapSerializer.class);
            addDefaultSerializer(Map.class, MapSerializer.class);
            addDefaultSerializer(TimeZone.class, DefaultSerializers.TimeZoneSerializer.class);
            addDefaultSerializer(Calendar.class, DefaultSerializers.CalendarSerializer.class);
            addDefaultSerializer(Locale.class, DefaultSerializers.LocaleSerializer.class);
            addDefaultSerializer(Charset.class, DefaultSerializers.CharsetSerializer.class);
            addDefaultSerializer(URL.class, DefaultSerializers.URLSerializer.class);
            OptionalSerializers.addDefaultSerializers(this);
            TimeSerializers.addDefaultSerializers(this);
            this.lowPriorityDefaultSerializerCount = arrayList.size();
            register(Integer.TYPE, new DefaultSerializers.IntSerializer());
            register(String.class, new DefaultSerializers.StringSerializer());
            register(Float.TYPE, new DefaultSerializers.FloatSerializer());
            register(Boolean.TYPE, new DefaultSerializers.BooleanSerializer());
            register(Byte.TYPE, new DefaultSerializers.ByteSerializer());
            register(Character.TYPE, new DefaultSerializers.CharSerializer());
            register(Short.TYPE, new DefaultSerializers.ShortSerializer());
            register(Long.TYPE, new DefaultSerializers.LongSerializer());
            register(Double.TYPE, new DefaultSerializers.DoubleSerializer());
            register(Void.TYPE, new DefaultSerializers.VoidSerializer());
            return;
        }
        throw new IllegalArgumentException("classResolver cannot be null.");
    }

    public void addDefaultSerializer(Class cls, SerializerFactory serializerFactory) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializerFactory != null) {
            DefaultSerializerEntry defaultSerializerEntry = new DefaultSerializerEntry(cls, serializerFactory);
            ArrayList<DefaultSerializerEntry> arrayList = this.defaultSerializers;
            arrayList.add(arrayList.size() - this.lowPriorityDefaultSerializerCount, defaultSerializerEntry);
            return;
        }
        throw new IllegalArgumentException("serializerFactory cannot be null.");
    }

    public Registration register(Class cls, Serializer serializer) {
        Registration registration = this.classResolver.getRegistration(cls);
        if (registration != null) {
            registration.setSerializer(serializer);
            return registration;
        }
        return this.classResolver.register(new Registration(cls, serializer, getNextRegistrationId()));
    }

    public Registration register(Class cls, Serializer serializer, int i) {
        if (i >= 0) {
            return register(new Registration(cls, serializer, i));
        }
        throw new IllegalArgumentException(outline.q("id must be >= 0: ", i));
    }

    public void addDefaultSerializer(Class cls, Class<? extends Serializer> cls2) {
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (cls2 != null) {
            DefaultSerializerEntry defaultSerializerEntry = new DefaultSerializerEntry(cls, new ReflectionSerializerFactory(cls2));
            ArrayList<DefaultSerializerEntry> arrayList = this.defaultSerializers;
            arrayList.add(arrayList.size() - this.lowPriorityDefaultSerializerCount, defaultSerializerEntry);
            return;
        }
        throw new IllegalArgumentException("serializerClass cannot be null.");
    }

    public Registration register(Registration registration) {
        int id2 = registration.getId();
        if (id2 >= 0) {
            getRegistration(registration.getId());
            Log.a aVar = Log.a;
            return this.classResolver.register(registration);
        }
        throw new IllegalArgumentException(outline.q("id must be > 0: ", id2));
    }

    public void writeObject(Output output, Object obj, Serializer serializer) {
        int i;
        boolean z2;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (obj == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        if (serializer != null) {
            beginObject();
            try {
                if (this.references && writeReferenceOrNull(output, obj, false)) {
                    serializer.setGenerics(this, null);
                    if (i == 0) {
                        if (z2) {
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                Log.a aVar = Log.a;
                serializer.write(this, output, obj);
                int i2 = this.depth - 1;
                this.depth = i2;
                if (i2 == 0 && this.autoReset) {
                    reset();
                    return;
                }
                return;
            } finally {
                i = this.depth - 1;
                this.depth = i;
                if (i == 0 && this.autoReset) {
                    reset();
                }
            }
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }

    public <T> T copy(T t, Serializer serializer) {
        T t2;
        if (t == null) {
            return null;
        }
        if (this.copyShallow) {
            return t;
        }
        this.copyDepth++;
        try {
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            T t3 = (T) this.originalToCopy.get(t);
            if (t3 != null) {
                return t3;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t;
            }
            if (t instanceof KryoCopyable) {
                t2 = (T) ((KryoCopyable) t).copy(this);
            } else {
                t2 = (T) serializer.copy(this, t);
            }
            if (this.needsCopyReference != null) {
                reference(t2);
            }
            Log.a aVar = Log.a;
            int i = this.copyDepth - 1;
            this.copyDepth = i;
            if (i == 0) {
                reset();
            }
            return t2;
        } finally {
            int i2 = this.copyDepth - 1;
            this.copyDepth = i2;
            if (i2 == 0) {
                reset();
            }
        }
    }

    public <T> T readObject(Input input, Class<T> cls, Serializer serializer) {
        T t;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer != null) {
            beginObject();
            try {
                if (this.references) {
                    int referenceOrNull = readReferenceOrNull(input, cls, false);
                    if (referenceOrNull == -1) {
                        return (T) this.readObject;
                    }
                    t = (T) serializer.read(this, input, cls);
                    if (referenceOrNull == this.readReferenceIds.size) {
                        reference(t);
                    }
                } else {
                    t = (T) serializer.read(this, input, cls);
                }
                Log.a aVar = Log.a;
                int i = this.depth - 1;
                this.depth = i;
                if (i == 0 && this.autoReset) {
                    reset();
                }
                return t;
            } finally {
                int i2 = this.depth - 1;
                this.depth = i2;
                if (i2 == 0 && this.autoReset) {
                    reset();
                }
            }
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }

    public void writeObjectOrNull(Output output, Object obj, Serializer serializer) {
        int i;
        boolean z2;
        if (output == null) {
            throw new IllegalArgumentException("output cannot be null.");
        }
        if (serializer != null) {
            beginObject();
            try {
                if (this.references) {
                    if (writeReferenceOrNull(output, obj, true)) {
                        serializer.setGenerics(this, null);
                        if (i == 0) {
                            if (z2) {
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                } else if (!serializer.getAcceptsNull()) {
                    if (obj == null) {
                        Log.a aVar = Log.a;
                        output.writeByte((byte) 0);
                        int i2 = this.depth - 1;
                        this.depth = i2;
                        if (i2 == 0 && this.autoReset) {
                            reset();
                            return;
                        }
                        return;
                    }
                    output.writeByte((byte) 1);
                }
                Log.a aVar2 = Log.a;
                serializer.write(this, output, obj);
                int i3 = this.depth - 1;
                this.depth = i3;
                if (i3 == 0 && this.autoReset) {
                    reset();
                    return;
                }
                return;
            } finally {
                i = this.depth - 1;
                this.depth = i;
                if (i == 0 && this.autoReset) {
                    reset();
                }
            }
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }

    public <T> T copyShallow(T t, Serializer serializer) {
        T t2;
        if (t == null) {
            return null;
        }
        this.copyDepth++;
        this.copyShallow = true;
        try {
            if (this.originalToCopy == null) {
                this.originalToCopy = new IdentityMap();
            }
            T t3 = (T) this.originalToCopy.get(t);
            if (t3 != null) {
                return t3;
            }
            if (this.copyReferences) {
                this.needsCopyReference = t;
            }
            if (t instanceof KryoCopyable) {
                t2 = (T) ((KryoCopyable) t).copy(this);
            } else {
                t2 = (T) serializer.copy(this, t);
            }
            if (this.needsCopyReference != null) {
                reference(t2);
            }
            Log.a aVar = Log.a;
            this.copyShallow = false;
            int i = this.copyDepth - 1;
            this.copyDepth = i;
            if (i == 0) {
                reset();
            }
            return t2;
        } finally {
            this.copyShallow = false;
            int i2 = this.copyDepth - 1;
            this.copyDepth = i2;
            if (i2 == 0) {
                reset();
            }
        }
    }

    public Registration getRegistration(int i) {
        return this.classResolver.getRegistration(i);
    }

    public <T> T readObjectOrNull(Input input, Class<T> cls, Serializer serializer) {
        T t;
        if (input == null) {
            throw new IllegalArgumentException("input cannot be null.");
        }
        if (cls == null) {
            throw new IllegalArgumentException("type cannot be null.");
        }
        if (serializer != null) {
            beginObject();
            try {
                if (this.references) {
                    int referenceOrNull = readReferenceOrNull(input, cls, true);
                    if (referenceOrNull == -1) {
                        return (T) this.readObject;
                    }
                    t = (T) serializer.read(this, input, cls);
                    if (referenceOrNull == this.readReferenceIds.size) {
                        reference(t);
                    }
                } else {
                    if (!serializer.getAcceptsNull() && input.readByte() == 0) {
                        Log.a aVar = Log.a;
                        int i = this.depth - 1;
                        this.depth = i;
                        if (i == 0 && this.autoReset) {
                            reset();
                        }
                        return null;
                    }
                    t = (T) serializer.read(this, input, cls);
                }
                Log.a aVar2 = Log.a;
                int i2 = this.depth - 1;
                this.depth = i2;
                if (i2 == 0 && this.autoReset) {
                    reset();
                }
                return t;
            } finally {
                int i3 = this.depth - 1;
                this.depth = i3;
                if (i3 == 0 && this.autoReset) {
                    reset();
                }
            }
        }
        throw new IllegalArgumentException("serializer cannot be null.");
    }
}
