package lombok.core.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.core.configuration.ConfigurationParser;
import lombok.core.configuration.ConfigurationSource;

/* loaded from: discord:lombok/core/configuration/SingleConfigurationSource.SCL.lombok */
public final class SingleConfigurationSource implements ConfigurationSource {
    private final Map<ConfigurationKey<?>, ConfigurationSource.Result> values = new HashMap();
    private final List<ConfigurationFile> imports;

    public static ConfigurationSource parse(ConfigurationFile context, ConfigurationParser parser) {
        Map<ConfigurationKey<?>, ConfigurationSource.Result> values = new HashMap<>();
        List<ConfigurationFile> imports = new ArrayList<>();
        ConfigurationParser.Collector collector = new AnonymousClass1(imports, values);
        parser.parse(context, collector);
        return new SingleConfigurationSource(values, imports);
    }

    /* renamed from: lombok.core.configuration.SingleConfigurationSource$1, reason: invalid class name */
    /* loaded from: discord:lombok/core/configuration/SingleConfigurationSource$1.SCL.lombok */
    class AnonymousClass1 implements ConfigurationParser.Collector {
        private final /* synthetic */ List val$imports;
        private final /* synthetic */ Map val$values;

        AnonymousClass1(List list, Map map) {
            this.val$imports = list;
            this.val$values = map;
        }

        @Override // lombok.core.configuration.ConfigurationParser.Collector
        public void addImport(ConfigurationFile importFile, ConfigurationFile context, int lineNumber) {
            this.val$imports.add(importFile);
        }

        @Override // lombok.core.configuration.ConfigurationParser.Collector
        public void clear(ConfigurationKey<?> key, ConfigurationFile context, int lineNumber) {
            this.val$values.put(key, new ConfigurationSource.Result(null, true));
        }

        @Override // lombok.core.configuration.ConfigurationParser.Collector
        public void set(ConfigurationKey<?> key, Object value, ConfigurationFile context, int lineNumber) {
            this.val$values.put(key, new ConfigurationSource.Result(value, true));
        }

        @Override // lombok.core.configuration.ConfigurationParser.Collector
        public void add(ConfigurationKey<?> key, Object value, ConfigurationFile context, int lineNumber) {
            modifyList(key, value, true);
        }

        @Override // lombok.core.configuration.ConfigurationParser.Collector
        public void remove(ConfigurationKey<?> key, Object value, ConfigurationFile context, int lineNumber) {
            modifyList(key, value, false);
        }

        private void modifyList(ConfigurationKey<?> key, Object value, boolean add) {
            List<ConfigurationSource.ListModification> list;
            ConfigurationSource.Result result = (ConfigurationSource.Result) this.val$values.get(key);
            if (result == null || result.getValue() == null) {
                list = new ArrayList<>();
                this.val$values.put(key, new ConfigurationSource.Result(list, result != null));
            } else {
                list = (List) result.getValue();
            }
            list.add(new ConfigurationSource.ListModification(value, add));
        }
    }

    private SingleConfigurationSource(Map<ConfigurationKey<?>, ConfigurationSource.Result> values, List<ConfigurationFile> imports) {
        for (Map.Entry<ConfigurationKey<?>, ConfigurationSource.Result> entry : values.entrySet()) {
            ConfigurationSource.Result result = entry.getValue();
            if (result.getValue() instanceof List) {
                this.values.put(entry.getKey(), new ConfigurationSource.Result(Collections.unmodifiableList((List) result.getValue()), result.isAuthoritative()));
            } else {
                this.values.put(entry.getKey(), result);
            }
        }
        this.imports = Collections.unmodifiableList(imports);
    }

    @Override // lombok.core.configuration.ConfigurationSource
    public ConfigurationSource.Result resolve(ConfigurationKey<?> key) {
        return this.values.get(key);
    }

    @Override // lombok.core.configuration.ConfigurationSource
    public List<ConfigurationFile> imports() {
        return this.imports;
    }
}
