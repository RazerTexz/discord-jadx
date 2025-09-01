package lombok.core.configuration;

import com.adjust.sdk.Constants;
import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: discord:lombok/core/configuration/ConfigurationDataType.SCL.lombok */
public final class ConfigurationDataType {
    private static final Map<Class<?>, ConfigurationValueParser> SIMPLE_TYPES;
    private final boolean isList;
    private final ConfigurationValueParser parser;

    /* renamed from: lombok.core.configuration.ConfigurationDataType$1, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/ConfigurationDataType$1.SCL.lombok */
    class AnonymousClass1 implements ConfigurationValueParser {
        AnonymousClass1() {
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public Object parse(String value) {
            return value;
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String description() {
            return "string";
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String exampleValue() {
            return "<text>";
        }
    }

    static {
        Map<Class<?>, ConfigurationValueParser> map = new HashMap<>();
        map.put(String.class, new AnonymousClass1());
        map.put(Integer.class, new AnonymousClass2());
        map.put(Long.class, new AnonymousClass3());
        map.put(Double.class, new AnonymousClass4());
        map.put(Boolean.class, new AnonymousClass5());
        SIMPLE_TYPES = map;
    }

    /* renamed from: lombok.core.configuration.ConfigurationDataType$2, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/ConfigurationDataType$2.SCL.lombok */
    class AnonymousClass2 implements ConfigurationValueParser {
        AnonymousClass2() {
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public Object parse(String value) {
            return Integer.valueOf(Integer.parseInt(value));
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String description() {
            return "int";
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String exampleValue() {
            return "<int>";
        }
    }

    /* renamed from: lombok.core.configuration.ConfigurationDataType$3, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/ConfigurationDataType$3.SCL.lombok */
    class AnonymousClass3 implements ConfigurationValueParser {
        AnonymousClass3() {
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public Object parse(String value) {
            return Long.valueOf(Long.parseLong(value));
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String description() {
            return Constants.LONG;
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String exampleValue() {
            return "<long>";
        }
    }

    /* renamed from: lombok.core.configuration.ConfigurationDataType$4, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/ConfigurationDataType$4.SCL.lombok */
    class AnonymousClass4 implements ConfigurationValueParser {
        AnonymousClass4() {
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public Object parse(String value) {
            return Double.valueOf(Double.parseDouble(value));
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String description() {
            return "double";
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String exampleValue() {
            return "<double>";
        }
    }

    /* renamed from: lombok.core.configuration.ConfigurationDataType$5, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/ConfigurationDataType$5.SCL.lombok */
    class AnonymousClass5 implements ConfigurationValueParser {
        AnonymousClass5() {
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public Object parse(String value) {
            return Boolean.valueOf(Boolean.parseBoolean(value));
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String description() {
            return "boolean";
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String exampleValue() {
            return "[false | true]";
        }
    }

    private static ConfigurationValueParser enumParser(Type enumType) {
        Class<?> type = (Class) enumType;
        return new AnonymousClass6(type, type);
    }

    /* renamed from: lombok.core.configuration.ConfigurationDataType$6, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/ConfigurationDataType$6.SCL.lombok */
    class AnonymousClass6 implements ConfigurationValueParser {
        private final /* synthetic */ Class val$rawType;
        private final /* synthetic */ Class val$type;

        AnonymousClass6(Class cls, Class cls2) {
            this.val$rawType = cls;
            this.val$type = cls2;
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public Object parse(String value) {
            try {
                return Enum.valueOf(this.val$rawType, value);
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < value.length(); i++) {
                    char c = value.charAt(i);
                    if (Character.isUpperCase(c) && i > 0) {
                        sb.append("_");
                    }
                    sb.append(Character.toUpperCase(c));
                }
                return Enum.valueOf(this.val$rawType, sb.toString());
            }
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String description() {
            return "enum (" + this.val$type.getName() + ")";
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String exampleValue() {
            ExampleValueString evs = (ExampleValueString) this.val$type.getAnnotation(ExampleValueString.class);
            return evs != null ? evs.value() : Arrays.toString(this.val$type.getEnumConstants()).replace(",", " |");
        }
    }

    private static ConfigurationValueParser valueTypeParser(Type argumentType) throws NoSuchMethodException, SecurityException {
        Class<?> type = (Class) argumentType;
        Method valueOfMethod = getMethod(type, "valueOf", String.class);
        Method descriptionMethod = getMethod(type, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION, new Class[0]);
        Method exampleValueMethod = getMethod(type, "exampleValue", new Class[0]);
        return new AnonymousClass7(valueOfMethod, descriptionMethod, exampleValueMethod);
    }

    /* renamed from: lombok.core.configuration.ConfigurationDataType$7, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/ConfigurationDataType$7.SCL.lombok */
    class AnonymousClass7 implements ConfigurationValueParser {
        private final /* synthetic */ Method val$valueOfMethod;
        private final /* synthetic */ Method val$descriptionMethod;
        private final /* synthetic */ Method val$exampleValueMethod;

        AnonymousClass7(Method method, Method method2, Method method3) {
            this.val$valueOfMethod = method;
            this.val$descriptionMethod = method2;
            this.val$exampleValueMethod = method3;
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public Object parse(String value) {
            return invokeStaticMethod(this.val$valueOfMethod, value);
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String description() {
            return (String) invokeStaticMethod(this.val$descriptionMethod, new Object[0]);
        }

        @Override // lombok.core.configuration.ConfigurationValueParser
        public String exampleValue() {
            return (String) invokeStaticMethod(this.val$exampleValueMethod, new Object[0]);
        }

        private <R> R invokeStaticMethod(Method method, Object... objArr) {
            try {
                return (R) method.invoke(null, objArr);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("The method " + method.getName() + " ", e);
            } catch (InvocationTargetException e2) {
                throw ((RuntimeException) e2.getTargetException());
            }
        }
    }

    public static ConfigurationDataType toDataType(Class<? extends ConfigurationKey<?>> keyClass) throws NoSuchMethodException, SecurityException {
        if (keyClass.getSuperclass() != ConfigurationKey.class) {
            throw new IllegalArgumentException("No direct subclass of ConfigurationKey: " + keyClass.getName());
        }
        Type type = keyClass.getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalArgumentException("Missing type parameter in " + type);
        }
        ParameterizedType parameterized = (ParameterizedType) type;
        Type argumentType = parameterized.getActualTypeArguments()[0];
        boolean isList = false;
        if (argumentType instanceof ParameterizedType) {
            ParameterizedType parameterizedArgument = (ParameterizedType) argumentType;
            if (parameterizedArgument.getRawType() == List.class) {
                isList = true;
                argumentType = parameterizedArgument.getActualTypeArguments()[0];
            }
        }
        if (SIMPLE_TYPES.containsKey(argumentType)) {
            return new ConfigurationDataType(isList, SIMPLE_TYPES.get(argumentType));
        }
        if (isEnum(argumentType)) {
            return new ConfigurationDataType(isList, enumParser(argumentType));
        }
        if (isConfigurationValueType(argumentType)) {
            return new ConfigurationDataType(isList, valueTypeParser(argumentType));
        }
        throw new IllegalArgumentException("Unsupported type parameter in " + type);
    }

    private ConfigurationDataType(boolean isList, ConfigurationValueParser parser) {
        this.isList = isList;
        this.parser = parser;
    }

    public boolean isList() {
        return this.isList;
    }

    ConfigurationValueParser getParser() {
        return this.parser;
    }

    public String toString() {
        return this.isList ? "list of " + this.parser.description() : this.parser.description();
    }

    private static boolean isEnum(Type argumentType) {
        return (argumentType instanceof Class) && ((Class) argumentType).isEnum();
    }

    private static boolean isConfigurationValueType(Type argumentType) {
        return (argumentType instanceof Class) && ConfigurationValueType.class.isAssignableFrom((Class) argumentType);
    }

    private static Method getMethod(Class<?> argumentType, String name, Class<?>... clsArr) throws NoSuchMethodException, SecurityException {
        try {
            return argumentType.getMethod(name, clsArr);
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Method " + name + " with parameters " + Arrays.toString(clsArr) + " was not found.", e);
        } catch (SecurityException e2) {
            throw new IllegalStateException("Cannot inspect methods of type " + argumentType, e2);
        }
    }
}
